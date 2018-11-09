package ch.ti8m.azubi.lod.pizzashop.web;


import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.service.OrderServiceImpl;
import ch.ti8m.azubi.lod.pizzashop.service.PizzaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/pizzashop")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        PizzaServiceImpl pizzaService = new PizzaServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();


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
            throw new ServletException("pizza auswahl has error");
        }

        Order creatOrder = orderService.createOrder(telString, addressString);
        orderService.makeOrder(creatOrder);
        double total = orderService.calculatePrice(pricedouble, anzahlInt);


        resp.sendRedirect(req.getRequestURI());
    }


}
