import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class Places {
  private String mplaceName;


  public Places(String placeName) {
    mplaceName = placeName;
  }

  public String getDescription() {;
    return mplaceName;
   }
}
