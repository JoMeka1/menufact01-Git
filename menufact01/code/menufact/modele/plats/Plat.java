package modele.plats;

import modele.ingredients.Ingredient;
import java.util.HashMap;
import java.util.Map;

public interface Plat {
    String getDescription();
    double getPrix();
    int getCode();
    String toString();
    Map<Ingredient, Double> getIngredientQuantities();
}