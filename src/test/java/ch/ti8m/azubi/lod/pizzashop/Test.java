package ch.ti8m.azubi.lod.pizzashop;

import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;
import ch.ti8m.azubi.lod.pizzashop.persistence.ObjectMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Test {


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapperFactory objectMapperFactory = new ObjectMapperFactory();
        PizzaBestellung pizzaBestellung = new PizzaBestellung(1, 1, 2, 18);
        String json = objectMapperFactory.objectMapper().writeValueAsString(pizzaBestellung);
        System.out.println(json);

    }
}
