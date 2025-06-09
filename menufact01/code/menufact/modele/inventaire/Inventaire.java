package menufact.modele.inventaire;

import menufact.modele.ingredients.Ingredient;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();

    public void ajouter (Ingredient ingredient)
    {
        lesIngredients.add(ingredient);
    }

}
