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


    // @Test
    // public void newTriangle_ifTriangleIsEquilateral_true() {
    //   Triangle app = new Triangle(2,2,2);
    //   assertEquals(true, app.isEquilateral());
    //   }
    //
    // @Test
    // public void newTriangle_ifTriangleIsIsosceles_true() {
    //   Triangle app = new Triangle(2,2,1);
    //   assertEquals(true, app.isIsosceles());
    //   }
    //
    //
    //
    // @Test
    // public void newTriangle_ifTriangleIsScalene_true() {
    //   Triangle app = new Triangle(1,2,3);
    //   assertEquals(true, app.isScalene());
    //   }

  }
