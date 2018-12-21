package ch.ti8m.azubi.lod.pizzashop;

import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;
import ch.ti8m.azubi.lod.pizzashop.persistence.ObjectMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSONTest {

    private ObjectMapperFactory objectMapperFactory;
    private PizzaBestellung pizzaBestellung;

    @Before
    public void setUp() {
        objectMapperFactory = new ObjectMapperFactory();
        pizzaBestellung = new PizzaBestellung(1, 1, 2, 18);

    }

    @Test
    public void setObjectMapperFactoryTest() throws JsonProcessingException {
        String json = objectMapperFactory.objectMapper().writeValueAsString(pizzaBestellung);
        assertEquals("{\n" +
                "  \"bestell-id\" : 1,\n" +
                "  \"pizza-id\" : 1,\n" +
                "  \"anzahl\" : 2,\n" +
                "  \"preis\" : 18.0\n" +
                "}", json);

    }


}
