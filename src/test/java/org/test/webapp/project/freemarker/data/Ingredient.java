package org.test.webapp.project.freemarker.data;

/**
 * An ingredient of a recipe.
 *
 * @author wap
 * @since 02.07.2018
 */
public class Ingredient {

    private final String amount;
    private final String name;

    public Ingredient(String amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
