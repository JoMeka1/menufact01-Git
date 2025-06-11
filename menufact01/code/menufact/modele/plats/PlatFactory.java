package modele.plats;

import modele.ingredients.Ingredient;
import java.util.Map;

public interface PlatFactory {
    Plat creerPlat(TypePlat type, int code, String description, double prix,
                   double kcal, double chol, double gras, double proportion, Map<Ingredient, Double> ingredientQuantities)
            throws IllegalArgumentException;
}