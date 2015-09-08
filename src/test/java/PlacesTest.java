import org.junit.*;
import static org.junit.Assert.*;


public class PlacesTest {

  @Test
  public void newPlaces_instantiatesCorrectly_true() {
    Places newPlaces = new Places("Portland");
    assertEquals(true, newPlaces instanceof Places);
  }

  @Test
  public void newPlaces_instantiatesWithPlaceNameCorrectly_true() {
    Places newPlaces = new Places("Portland");
    assertEquals("Portland", newPlaces.getDescription());
  }
}
