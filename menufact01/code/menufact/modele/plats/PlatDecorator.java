package modele.plats;

import modele.ingredients.Ingredient;
import java.util.HashMap;
import java.util.Map;

public abstract class PlatDecorator implements Plat {
    protected Plat plat;
    protected Map<Ingredient, Double> ingredientQuantities;

    public PlatDecorator(Plat plat) {
        this.plat = plat;
        this.ingredientQuantities = new HashMap<>(plat.getIngredientQuantities());
    }

    public PlatDecorator(Plat plat, Map<Ingredient, Double> ingredientQuantities) {
        this.plat = plat;
        this.ingredientQuantities = new HashMap<>(ingredientQuantities != null ? ingredientQuantities : plat.getIngredientQuantities());
    }

    @Override
    public String getDescription() {
        return plat.getDescription();
    }

    @Override
    public double getPrix() {
        return plat.getPrix();
    }

    @Override
    public int getCode() {
        return plat.getCode();
    }

    @Override
    public String toString() {
        return plat.toString() + " (décoré avec ingredients=" + ingredientQuantities + ")";
    }

    @Override
    public Map<Ingredient, Double> getIngredientQuantities() {
        Map<Ingredient, Double> allIngredients = new HashMap<>(plat.getIngredientQuantities());
        allIngredients.putAll(ingredientQuantities);
        return allIngredients;
    }

    public void ajouterIngredient(Ingredient ingredient, double quantite) {
        if (ingredient != null && quantite > 0) {
            ingredientQuantities.put(ingredient, quantite);
        }
    }
}