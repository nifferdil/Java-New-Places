import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("places", request.session().attribute("places"));

        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



    post("/places", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();


     // array name is name of Class
     ArrayList<Places> places = request.session().attribute("places");
     //first time thru array only
     if (places == null) {
       places = new ArrayList<Places>();
       // putting our arraylist into our value
       request.session().attribute("places", places);
 }

     String newPlace = request.queryParams("newPlace");
     Places addedPlace = new Places(newPlace);

     // adding the Place object as opposed to the String from user second input
     places.add(addedPlace);

     model.put("template", "templates/places.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
