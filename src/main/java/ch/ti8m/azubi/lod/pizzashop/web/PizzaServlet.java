package ch.ti8m.azubi.lod.pizzashop.web;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.service.PizzaServiceImpl;
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

@WebServlet("/pizzashop")
public class PizzaServlet extends HttpServlet {


    private Template template;

    public void init() throws ServletException {
        template = new FreemarkerConfig().loadTemplate("pizzashop.ftl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");


        //PrintWriter writer = new PrintWriter(resp.getWriter());

        PizzaServiceImpl pizzaService = new PizzaServiceImpl();


        /*
        String id = req.getParameter("idzahl");


        int idInt;

        if (id != null) {
            idInt = pizzaService.idToInt(id);
        } else {
            idInt = 0;
        }


        Pizza pizza = pizzaService.getPizzaByID(idInt);
        Map<String, Object> model = new HashMap<>();
        model.put("pizzaString", pizza);
        */


        try {
            List<Pizza> pizzas = pizzaService.list();
            PrintWriter writer = resp.getWriter();
            Map<String, Object> model = new HashMap<>();
            model.put("pizzas", pizzas);
            template.process(model, writer);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e);
        }





/*
        if (id != null) {
            try {
                idInt = pizzaService.idToInt(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }


        if (idInt >= 1) {
            pizza = pizzaService.getPizzaByID(idInt);

        } else {
            pizza = "Keine Negativen IDs.";
        }


        if (idcreate != null) {
            try {
                idCreateInt = pizzaService.idToInt(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }


        if (namecreate != null) {
            try {
                nameCreateString = namecreate;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }


        if (pricecreate != null) {
            try {
                priceCreateDouble = pizzaService.priceToDouble(pricecreate);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PizzaServiceImpl pizzaService = new PizzaServiceImpl();

        String idcreate = req.getParameter("idcreate");
        String namecreate = req.getParameter("namecreate");
        String pricecreate = req.getParameter("pricecreate");


        int idCreateInt = pizzaService.idToInt(idcreate);
        double priceCreateDouble = pizzaService.priceToDouble(pricecreate);
        String nameCreateString = namecreate;
        Pizza createPizza = pizzaService.createPizza(idCreateInt, nameCreateString, priceCreateDouble);
        if (idCreateInt > 0 && nameCreateString != null && priceCreateDouble > 0) {
            try {
                pizzaService.makePizza(createPizza);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        super.doPost(req, resp);
    }
}
