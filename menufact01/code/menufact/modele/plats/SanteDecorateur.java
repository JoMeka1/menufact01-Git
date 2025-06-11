package modele.plats;

import modele.ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class SanteDecorateur extends PlatDecorator {
    private double kcal;
    private double chol;
    private double gras;

    public SanteDecorateur(Plat plat, double kcal, double chol, double gras, Map<Ingredient, Double> ingredientQuantities) {
        super(plat, ingredientQuantities);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    @Override
    public double getPrix() {
        return super.getPrix();
    }

    @Override
    public String toString() {
        return super.toString() + ", kcal=" + kcal + ", chol=" + chol + ", gras=" + gras;
    }
}