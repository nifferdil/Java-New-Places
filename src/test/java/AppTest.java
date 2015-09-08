import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import java.util.ArrayList;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Places I've been!");
  }

  @Test
  public void placeIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#newPlace").with("Portland");
    submit(".btn");
    assertThat(pageSource()).contains("Your new place has been saved.");
  }

  @Test
  public void placeIsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#newPlace").with("Portland");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Portland");
  }

  @Test
  public void multipleplacesDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#newPlace").with("Portland");
    submit(".btn");
    assertThat(pageSource()).contains("Your new place has been saved.");
  }

  @Test
  public void multiplePlacesAreDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#newPlace").with("Portland");
    submit(".btn");
    click("a", withText("Go Back"));
    fill("#description").with("California");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Portland");
    assertThat(pageSource()).contains("California");
  }
}
