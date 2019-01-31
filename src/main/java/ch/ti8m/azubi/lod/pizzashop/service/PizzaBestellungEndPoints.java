package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class PizzaBestellungEndPoints {

    private PizzaBestellungService pizzaBestellungService = ServiceRegistry.getInstance().get(PizzaBestellungService.class);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PizzaBestellung> list() throws Exception {
        return pizzaBestellungService.list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PizzaBestellung getPizzaBestellungByID(@PathParam("id") int x) {
        return pizzaBestellungService.getPizzaBestellungByID(x);
    }

    //not in Use
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePizzaBestellungByID(PizzaBestellung pb, @PathParam("id") int x) {
        pizzaBestellungService.updatePizzaBestellungByID(pb, x);
    }

    //not in Use
    @DELETE
    @Path("/{id}")
    public void deletePizzaBestellungByID(@PathParam("id") int x) {
        pizzaBestellungService.deletePizzaBestellungByID(x);
    }
}
