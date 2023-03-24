import org.greenSnake.CRUD.PlanetCrudService;
import org.greenSnake.data.Planet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlanetCrudServiceTest {
    PlanetCrudService planet = new PlanetCrudService();
    Planet plan;
    @BeforeEach
    public void beforeEach(){
        plan = new Planet();
        plan.setId("MED");
        plan.setName("MEDUSA");
    }

    @Test
    public void testThatCreateIsCorrect(){
        planet.create(plan);
        String med = planet.getById("MED");
        Assertions.assertEquals(plan.getName(),med);
    }

    @Test
    public void testGetById(){
        String id = "MED";
        String expect = "MEDUSA";
        String name = planet.getById(id);
        Assertions.assertEquals(expect,name);
    }

    @Test
    public void testSetName(){
        String expect = "MEDUSA2";
        planet.setName(plan.getId(),expect);
        String actual = planet.getById(plan.getId());
        Assertions.assertEquals(expect,actual);
    }
    @Test
    public void testThatDeleteById(){
        boolean actual = planet.isDeleteById(plan.getId());
        Assertions.assertTrue(actual);
    }
}
