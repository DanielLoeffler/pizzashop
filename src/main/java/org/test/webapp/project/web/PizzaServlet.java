package org.test.webapp.project.web;

import freemarker.template.*;
import org.test.webapp.project.dto.Pizza;
import org.test.webapp.project.service.PizzaService;
import org.test.webapp.project.service.PizzaServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@WebServlet("/pizzashop")
public class PizzaServlet extends HttpServlet {



    private Configuration configuration() {
        Configuration config = new Configuration();
        config.setDefaultEncoding("UTF-8");
        config.setLocale(Locale.getDefault());
        config.setClassForTemplateLoading(getClass(), "/templates");
        config.setIncompatibleImprovements(new Version(2, 3, 20));
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return config;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");

        PrintWriter writer = new PrintWriter(resp.getWriter());

        PizzaServiceImpl pizzaService = new PizzaServiceImpl();


        String id = req.getParameter("idzahl");
        String idcreate = req.getParameter("idcreate");
        String namecreate = req.getParameter("namecreate");
        String pricecreate = req.getParameter("pricecreate");


        int idInt = pizzaService.idToInt(id);
        int idCreateInt = pizzaService.idToInt(idcreate);
        double priceCreateDouble = pizzaService.priceToDouble(pricecreate);
        Pizza pizzaString = pizzaService.getPizzaByID(idInt);
        String nameCreateString = namecreate;
        Pizza createPizza = pizzaService.crreatePizza(idCreateInt,nameCreateString,priceCreateDouble);



        Template template = configuration().getTemplate("pizzashop.ftl");



        Map<String, Object> model = new HashMap<>();
        model.put("pizzaString", pizzaString);
        model.put("createPizzaString", createPizza);


        StringWriter writerer = new StringWriter();
        try {
            template.process(model, writerer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(pizzaString, writerer.toString());


        if (id != null) {
            try {
                idInt = pizzaService.idToInt(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

/*
        if (idInt >= 1) {
            pizzaString = pizzaService.getPizzaByID(idInt);

        } else {
            pizzaString = "Keine Negativen IDs.";
        }
*/

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

/*
        if (idCreateInt > 0 && nameCreateString != null && priceCreateDouble > 0) {
            Pizza p = pizzaService.crreatePizza(idCreateInt, nameCreateString, priceCreateDouble);
            createPizzaString = p.toString();
            pizzaService.makePizza(p);
        } else {
            createPizzaString = "Fehler beim erstellen der neuen Pizza.";
        }
*/

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
                pizzaString +
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
                createPizzaString +
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
    }
}
