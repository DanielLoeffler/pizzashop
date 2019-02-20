package ch.ti8m.azubi.lod.pizzashop;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.dto.PizzaOrder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderTest {

    @Test
    public void testOrderJSON() throws Exception {

        Order order = new Order();
        order.setId(2);
        order.setPhone("0552323234");
        order.setAddress("Hauptsrasse 5");

        List<PizzaOrder> bestellung = new LinkedList<>();
        bestellung.add(new PizzaOrder(1, 5, 12.50));
        bestellung.add(new PizzaOrder(2, 2, 17.60));
        order.setBestellungen(bestellung);

        String json = objectMapper().writeValueAsString(order);
        System.out.println(json);

        Order restored = objectMapper().readValue(json, Order.class);
        Assert.assertEquals(order.getId(), restored.getId());
        Assert.assertEquals(order.getPhone(), restored.getPhone());
        Assert.assertEquals(order.getAddress(), restored.getAddress());
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
