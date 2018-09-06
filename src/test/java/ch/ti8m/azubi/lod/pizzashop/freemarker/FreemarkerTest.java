package ch.ti8m.azubi.lod.pizzashop.freemarker;

import ch.ti8m.azubi.lod.pizzashop.freemarker.data.Ingredient;
import ch.ti8m.azubi.lod.pizzashop.freemarker.data.Recipe;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.junit.Assert;
import org.junit.Test;
import ch.ti8m.azubi.lod.pizzashop.freemarker.data.Ingredient;
import ch.ti8m.azubi.lod.pizzashop.freemarker.data.Recipe;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Tests for Freemarker template engine
 *
 * @author wap
 * @since 02.07.2018
 */
public class FreemarkerTest {

    private Configuration configuration() {
        Configuration config = new Configuration();
        config.setDefaultEncoding("UTF-8");
        config.setLocale(Locale.getDefault());
        config.setClassForTemplateLoading(getClass(), "/templates");
        config.setIncompatibleImprovements(new Version(2, 3, 20));
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return config;
    }


    @Test
    public void helloWorld() throws Exception {

        Template template = configuration().getTemplate("hello.ftl");

        Map<String, Object> model = new HashMap<>();
        model.put("name", "World");

        StringWriter writer = new StringWriter();
        template.process(model, writer);

        Assert.assertEquals("Hello World", writer.toString());
    }

    @Test
    public void recipe() throws Exception {

        Template template = configuration().getTemplate("recipe.ftl");

        Recipe recipe = new Recipe("Käsewähe");
        recipe.add(new Ingredient("1", "Kuchenteig, rund, ausgewallt"));
        recipe.add(new Ingredient("200g", "milder Gruyère, gerieben"));
        recipe.add(new Ingredient("100g", "Emmentaler, gerieben"));
        recipe.add(new Ingredient("1 EL", "Mehl"));
        recipe.add(new Ingredient("1.8 dl", "Halbrahm"));
        recipe.add(new Ingredient("2 dl", "Milch"));
        recipe.add(new Ingredient("2", "Eier"));
        recipe.add(new Ingredient("1 Prise", "Salz, Pfeffer, Muskat"));
        recipe.setInstructions("Alles gut verrühren, mit dem Käse mischen, auf dem Teigboden verteilen, und 30min bei 220° backen");

        StringWriter writer = new StringWriter();
        template.process(recipe, writer);
        System.out.println(writer);
    }
}
