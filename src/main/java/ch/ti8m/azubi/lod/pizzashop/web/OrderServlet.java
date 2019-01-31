package ch.ti8m.azubi.lod.pizzashop.web;


import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;
import ch.ti8m.azubi.lod.pizzashop.persistence.ObjectMapperFactory;
import ch.ti8m.azubi.lod.pizzashop.service.*;
import ch.ti8m.azubi.lod.pizzashop.template.FreemarkerConfig;
import freemarker.template.Template;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/order")
public class OrderServlet extends HttpServlet {


    private PizzaService pizzaService = ServiceRegistry.getInstance().get(PizzaService.class);
    private OrderService orderService = ServiceRegistry.getInstance().get(OrderService.class);
    private PizzaBestellungService pizzaBestellungService = ServiceRegistry.getInstance().get(PizzaBestellungService.class);

    private Template template;

    public void init() throws ServletException {
        template = new FreemarkerConfig().loadTemplate("pizzashop.ftl");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");


        //PrintWriter writer = new PrintWriter(resp.getWriter());

        OrderServiceImpl orderService = new OrderServiceImpl();


        try {
            List<Order> orders = orderService.list();
            PrintWriter writer = resp.getWriter();
            Map<String, Object> model = new HashMap<>();
            model.put("orders", orders);
            template.process(model, writer);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String anzahlString = req.getParameter("anzahl");

        //muss auswahl aus pizza holen um zum preis zu kommen
        String pizzaIDString = req.getParameter("pizza");

        String telString = req.getParameter("tel");
        String addressString = req.getParameter("address");

        int anzahlInt;
        int pizzaIDInt;
        double pricedouble;

        try {
            anzahlInt = pizzaService.idToInt(anzahlString);
        } catch (NumberFormatException ex) {
            throw new ServletException("pizza anzahl is required and must be a number");
        }

        try {
            pizzaIDInt = pizzaService.idToInt(pizzaIDString);
        } catch (NumberFormatException ex) {
            throw new ServletException("pizza auswahl has error");
        }

        try {
            pricedouble = orderService.getPriceById(pizzaIDInt);
        } catch (NumberFormatException ex) {
            throw new ServletException("pizza preis has error");
        }

        Order creatOrder = orderService.createOrder(telString, addressString);
        creatOrder = orderService.makeOrder(creatOrder);
        double total = orderService.calculatePrice(pricedouble, anzahlInt);
        PizzaBestellung pizzaBestellung = pizzaBestellungService.createPizzaBestellung(creatOrder.getId(), pizzaIDInt, anzahlInt, total);
        pizzaBestellungService.makePizzaBestellung(pizzaBestellung);

        ObjectMapperFactory objectMapperFactory = new ObjectMapperFactory();
        String jsonPizzaBestellung = objectMapperFactory.objectMapper().writeValueAsString(pizzaBestellung);

        resp.sendRedirect(req.getRequestURI() + "?order=" + creatOrder.getId());
    }


}
