package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class OrderEndPoints {

    private OrderServiceImpl orderService = ServiceRegistry.getInstance().get(OrderServiceImpl.class);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> list() throws Exception {
        return orderService.list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrderByID(@PathParam("id") int x) {
        return orderService.getOrderByID(x);
    }


    //not in Use
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOrderByID(Order o, @PathParam("id") int x) {
        orderService.updateOrderByID(o, x);
    }

    //not in Use
    @DELETE
    @Path("/{id}")
    public void deleteOrderByID(@PathParam("id") int x) {
        orderService.deleteOrderByID(x);
    }
}
