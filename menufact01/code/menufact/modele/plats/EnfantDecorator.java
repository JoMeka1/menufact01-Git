package modele.plats;

import modele.ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class EnfantDecorator extends PlatDecorator {
    private double proportion;

    public EnfantDecorator(Plat plat, double proportion, Map<Ingredient, Double> ingredientQuantities) {
        super(plat, ingredientQuantities);
        this.proportion = proportion;
    }

    @Override
    public double getPrix() {
        return super.getPrix() * proportion; // Applique la proportion au prix de base
    }

    @Override
    public String toString() {
        return super.toString() + ", proportion=" + proportion + ", ingredientQuantities=" + getIngredientQuantities();
    }
}