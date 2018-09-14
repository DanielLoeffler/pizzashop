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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/pizzashop")
public class PizzaServlet extends HttpServlet {


    private Template template;

    public void init() throws ServletException {
        template = new FreemarkerConfig().loadTemplate("pizzashop.ftl");
    }

/*
    private Configuration configuration() {
        Configuration config = new Configuration();
        config.setDefaultEncoding("UTF-8");
        config.setLocale(Locale.getDefault());
        config.setClassForTemplateLoading(getClass(), "/templates");
        config.setIncompatibleImprovements(new Version(2, 3, 20));
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return config;
    }


    public Template loadTemplate(String resourcePath) throws ServletException {
        try {
            return configuration().getTemplate(resourcePath);
        } catch (IOException e) {
            throw new ServletException("Failed to load Template" + e.getMessage());
        }
    }
*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");

        //PrintWriter writer = new PrintWriter(resp.getWriter());

        PizzaServiceImpl pizzaService = new PizzaServiceImpl();

        /*String id = req.getParameter("idzahl");


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

            Map<String, Object> model = new HashMap<>();
            model.put("pizzas", pizzas);

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


/*
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>\n" +
                "\t\t\tPizzashop HTML\n" +
                "\t\t</title>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"Pizza.css\">\n" +
                "</head>\n" +
                "<body background=\"http://cdn4.micasa.ch/medias/sys_master/zoom/1/c/5/6/id_10295631904798_zoom.jpg\"><b>\n" +
                "<a href=\"Pizza Restaurant.html\">\n" +
                "\t<h1>Pizzeria HTML</h1>\n" +
                "</a><br>\n" +
                "<br>\n" +
                "Pizza lieferung:\n" +
                "<a href=\"https://www.dieci.ch/de/\">\n" +
                "bitte hier klicken um Die bestellung zu machen.<br>\n" +
                "</a><br>\n" +
                "Zur auswahl stehen folgende Sorten mit dem Preis f&uumlr die Kleine Pizza\n" +
                "<br>\n" +
                "<br>\n" +
                "<button type=\"button\">show all</button>\n" +
                "<br>\n" +
                "<br>\n" +
                "show Pizza <form><label for=\"idzahl\">Nummer: <input id=\"idzahl\" name=\"idzahl\"></label></form>" +
                "<br>\n" +
                "<br>\n" +
                pizza +
                "<br>\n" +
                "<br>\n" +
                "<form> creat<label for=\"idcreate\">Id: <input id=\"idcreate\" name=\"idcreate\"></label>" +
                "<br>\n" +
                "<br>\n" +
                "creat <label for=\"namecreate\">Name: <input id=\"namecreate\" name=\"namecreate\"></label>" +
                "<br>\n" +
                "<br>\n" +
                "creat <label for=\"pricecreate\">Price: <input id=\"pricecreate\" name=\"pricecreate\"></label></form>" +
                "<br>\n" +
                "<br>\n" +
                createPizza +
                "<br>\n" +
                "<br>\n" +
                "<table>\n" +
                "\t<tr>\n" +
                "\t\t<th>Name</th>\n" +
                "\t\t<th>Preis</th>\n" +
                "\t\t<th>Bild</th>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td>Pizza Margherita</td>\n" +
                "\t\t<td>6.-</td>\n" +
                "\t\t<td><img src=\"http://www.cbc.ca/inthekitchen/assets_c/2012/11/MargheritaPizza21-thumb-596x350-247022.jpg\" width=\"200\"></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td>Pizza Hawaii</td>\n" +
                "\t\t<td>6.50 Fr.</td>\n" +
                "\t\t<td><img src=\"https://images.kurier.at/46-90332057.jpg/620x340/248.134.343\"width=\"200\"></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td>Pizza Napoli</td>\n" +
                "\t\t<td>7.50 Fr.</td>\n" +
                "\t\t<td><img src=\"https://media-cdn.tripadvisor.com/media/photo-s/0d/11/36/0c/pizza-napoli.jpg\"width=\"200\"></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td>Pizza Verdi</td>\n" +
                "\t\t<td>5.50 Fr.</td>\n" +
                "\t\t<td><img src=\"https://media-cdn.tripadvisor.com/media/photo-s/0a/80/8a/21/pizza-verdi.jpg\"width=\"200\"></td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td>&#9733 Pizza a la HTML &#9733</td>\n" +
                "\t\t<td>8.-</td>\n" +
                "\t\t<td><img src=\"http://blog.prospective.ch/wp-content/uploads/2012/08/qr-code.png\"width=\"200\"></td>\n" +
                "\t</tr>\n" +
                "</table><br>\n" +
                "<br>\n" +
                "\n" +
                "\n" +
                "</b>\n" +
                "</body>\n" +
                "</html>");

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
