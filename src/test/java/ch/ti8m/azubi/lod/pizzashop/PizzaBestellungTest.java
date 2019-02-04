package ch.ti8m.azubi.lod.pizzashop;

import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Assert;
import org.junit.Test;

public class PizzaBestellungTest {

    @Test
    public void testPizzaBestellungJSON() throws Exception {

        PizzaBestellung pizzaBestellung = new PizzaBestellung();
        pizzaBestellung.setBestellung_id(2);
        pizzaBestellung.setPizza_id(3);
        pizzaBestellung.setAnzahl(5);
        pizzaBestellung.setPreis(14.55);

        String json = objectMapper().writeValueAsString(pizzaBestellung);
        System.out.println(json);

        PizzaBestellung restored = objectMapper().readValue(json, PizzaBestellung.class);
        Assert.assertEquals(pizzaBestellung.getBestellung_id(), restored.getBestellung_id());
        Assert.assertEquals(pizzaBestellung.getPizza_id(), restored.getPizza_id());
        Assert.assertEquals(pizzaBestellung.getAnzahl(), restored.getAnzahl());
        Assert.assertEquals(pizzaBestellung.getPreis(), restored.getPreis(), 1e-10);
    }

    public ObjectMapper objectMapper() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return mapper;
    }
}
