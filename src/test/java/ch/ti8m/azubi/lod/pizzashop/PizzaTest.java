package ch.ti8m.azubi.lod.pizzashop;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Assert;
import org.junit.Test;

public class PizzaTest {


    @Test
    public void testPizzaJSON() throws Exception {

        Pizza pizza = new Pizza();
        pizza.setId(1);
        pizza.setName("Calabrese");
        pizza.setPrice(19.75);

        String json = objectMapper().writeValueAsString(pizza);
        System.out.println(json);

        Pizza restored = objectMapper().readValue(json, Pizza.class);
        Assert.assertEquals(pizza.getId(), restored.getId());
        Assert.assertEquals(pizza.getName(), restored.getName());
        Assert.assertEquals(pizza.getPrice(), restored.getPrice(), 1e-10);
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
