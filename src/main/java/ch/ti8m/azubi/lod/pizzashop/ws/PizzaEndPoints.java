package ch.ti8m.azubi.lod.pizzashop.ws;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.service.PizzaService;
import ch.ti8m.azubi.lod.pizzashop.service.ServiceRegistry;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * Endpoints for the Pizzas
 */
@Path("/pizza")
public class PizzaEndPoints {

    private PizzaService pizzaService = ServiceRegistry.getInstance().get(PizzaService.class);

    @GET
    //@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pizza> list() throws Exception {
        return pizzaService.list();
    }

    @POST
    //@Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pizza createPizza(Pizza pizza) {
        pizza.setId(null);
        pizzaService.makePizza(pizza);
        return pizza;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pizza getPizzaByID(@PathParam("id") int x) {
        return pizzaService.getPizzaByID(x);
    }

    //not in Use
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePizzaByID(Pizza pizza, @PathParam("id") int id) {
        pizza.setId(id);
        pizzaService.updatePizza(pizza);
    }

    //not in Use
    @DELETE
    @Path("/{id}")
    public void deletePizzaByID(@PathParam("id") int x) {
        pizzaService.deletePizzaByID(x);
    }

}
