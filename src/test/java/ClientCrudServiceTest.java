import org.greenSnake.CRUD.ClientCrudService;
import org.greenSnake.data.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientCrudServiceTest {
    ClientCrudService service = new ClientCrudService();
    Client client;
    @BeforeEach
    public void beforeEach(){
        client = new Client();
        client.setName("ANTONY");
    }

    @Test
    public void testThatCreateIsCorrect(){
        service.create(client);
        String anton = service.getById(client.getId());
        Assertions.assertEquals(client.getName(),anton);
    }

    @Test
    public void testGetById(){
        long id = 11L;
        String expect = client.getName();
        String name = service.getById(id);
        Assertions.assertEquals(expect,name);
    }

    @Test
    public void testSetName(){
        String expect = client.getName() + "2";
        service.setName(client.getId(),expect);
        String actual = service.getById(client.getId());
        Assertions.assertEquals(expect,actual);
    }
    @Test
    public void testThatDeleteById(){
        boolean actual = service.isDeleteById(client.getId());
        Assertions.assertTrue(actual);
    }
}
