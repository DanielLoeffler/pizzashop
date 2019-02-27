package ch.ti8m.azubi.lod.pizzashop.web;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.service.PizzaService;
import ch.ti8m.azubi.lod.pizzashop.service.ServiceRegistry;
import ch.ti8m.azubi.lod.pizzashop.template.FreemarkerConfig;
import ch.ti8m.azubi.lod.pizzashop.webservice.config.ObjectMapperFactory;
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

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * Connection between the Web and the backend
 */
@WebServlet("/pizza")
public class PizzaServlet extends HttpServlet {


    private Template template;
    private PizzaService pizzaService = ServiceRegistry.getInstance().get(PizzaService.class);


    public void init() throws ServletException {
        template = new FreemarkerConfig().loadTemplate("pizzashop.ftl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");


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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String namecreate = req.getParameter("namecreate");
        String pricecreate = req.getParameter("pricecreate");

        if (namecreate == null || namecreate.trim().length() == 0) {
            throw new ServletException("pizza name is required");
        }

        double priceCreateDouble;
        try {
            priceCreateDouble = pizzaService.priceToDouble(pricecreate);
        } catch (NumberFormatException ex) {
            throw new ServletException("pizza price is required and must be a number");
        }

        Pizza createPizza = pizzaService.createPizza(namecreate, priceCreateDouble);
        pizzaService.makePizza(createPizza);

        ObjectMapperFactory objectMapperFactory = new ObjectMapperFactory();
        String jsonPizza = objectMapperFactory.objectMapper().writeValueAsString(createPizza);

        resp.sendRedirect(req.getRequestURI());
    }
}
