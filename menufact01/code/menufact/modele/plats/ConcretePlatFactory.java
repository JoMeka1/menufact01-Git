package modele.plats;

import modele.ingredients.Ingredient;
import modele.ingredients.TypeIngredient;
import modele.ingredients.UniteSolide;

import java.util.Map;

public class ConcretePlatFactory implements PlatFactory {
    @Override
    public Plat creerPlat(TypePlat type, int code, String description, double prix,
                          double kcal, double chol, double gras, double proportion, Map<Ingredient, Double> ingredientQuantities)
            throws IllegalArgumentException {
        Plat basePlat = new PlatAuMenu(code, description, prix, ingredientQuantities);
        switch (type) {
            case NORMAL:
                if (kcal != 0.0 || chol != 0.0 || gras != 0.0 || proportion != 0.0) {
                    throw new IllegalArgumentException("Plat normal ne nécessite pas d'extras");
                }
                return basePlat;
            case SANTE:
                if (kcal <= 0.0 || chol < 0.0 || gras < 0.0) {
                    throw new IllegalArgumentException("Valeurs invalides pour kcal, chol, ou gras");
                }
                if (proportion != 0.0) {
                    throw new IllegalArgumentException("Proportion non applicable pour un plat santé");
                }
                SanteDecorateur sante = new SanteDecorateur(basePlat, kcal, chol, gras, ingredientQuantities);
                if (ingredientQuantities == null || ingredientQuantities.isEmpty()) {
                    sante.ajouterIngredient(new Ingredient("Légume", "Santé", TypeIngredient.LEGUME, new UniteSolide()), 100.0);
                }
                return sante;
            case ENFANT:
                if (proportion <= 0.0 || proportion > 1.0) {
                    throw new IllegalArgumentException("Proportion doit être entre 0 et 1");
                }
                if (kcal != 0.0 || chol != 0.0 || gras != 0.0) {
                    throw new IllegalArgumentException("Métriques santé non applicables pour un plat enfant");
                }
                EnfantDecorator enfant = new EnfantDecorator(basePlat, proportion, ingredientQuantities);
                if (ingredientQuantities == null || ingredientQuantities.isEmpty()) {
                    enfant.ajouterIngredient(new Ingredient("Petite portion", "Enfant", TypeIngredient.LEGUME, new UniteSolide()), 50.0);
                }
                return enfant;
            default:
                throw new IllegalArgumentException("Type inconnu : " + type);
        }
    }
}