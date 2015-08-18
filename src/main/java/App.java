import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("place", request.session().attribute("place"));
        
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/places", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();

     String newPlace = request.queryParams("newPlace");
     Places addedPlace = new Places(newPlace);
     request.session().attribute("place", addedPlace);

     model.put("template", "templates/places.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
