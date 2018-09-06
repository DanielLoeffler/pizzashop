package ch.ti8m.azubi.lod.pizzashop.freemarker.data;

import java.util.LinkedList;
import java.util.List;

/**
 * A recipe
 *
 * @author wap
 * @since 02.07.2018
 */
public class Recipe {

    private String name;
    private List<Ingredient> ingredients = new LinkedList<>();
    private String instructions;

    public Recipe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
