package modele.ingredients;

import modele.ingredients.exceptions.IngredientException;

public class IngredientInventaire {
    private Ingredient ingredient;
    private double quantite;

    public IngredientInventaire(Ingredient ingredient, double quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void retirerQuantite(double quantite) throws IngredientException {
        setQuantite(this.quantite - quantite);
    }


    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }
}
