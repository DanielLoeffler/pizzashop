package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pizza")
public class PizzaEndPoints {

    private PizzaService pizzaService = ServiceRegistry.getInstance().get(PizzaService.class);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pizza> list() throws Exception {
        return pizzaService.list();
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
    public void updatePizzaByID(Pizza p, @PathParam("id") int x) {
        pizzaService.updatePizzaByID(p, x);
    }

    //not in Use
    @DELETE
    @Path("/{id}")
    public void deletePizzaByID(@PathParam("id") int x) {
        pizzaService.deletePizzaByID(x);
    }

}
