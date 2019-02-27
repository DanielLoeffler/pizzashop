package ch.ti8m.azubi.lod.pizzashop.ws;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.service.OrderService;
import ch.ti8m.azubi.lod.pizzashop.service.ServiceRegistry;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * Endpoints for the Orders
 */
@Path("/order")
public class OrderEndPoints {

    private OrderService orderService = ServiceRegistry.getInstance().get(OrderService.class);

    @GET
    //@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> list() throws Exception {
        return orderService.list();
    }

    @POST
    //@Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order createOrder(Order order) {
        order.setId(null);
        orderService.makeOrder(order);
        return order;
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
