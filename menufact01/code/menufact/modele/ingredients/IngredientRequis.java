package menufact.modele.ingredients;

public class IngredientRequis {

    private Ingredient ingredient;
    private double quantite;

    public IngredientRequis(Ingredient ingredient,double quantite){
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public Ingredient getIngredient(){
        return ingredient;
    }

    public double getQuantite(){
        return quantite;
    }
}
