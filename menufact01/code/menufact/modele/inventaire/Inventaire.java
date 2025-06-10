package modele.inventaire;

import modele.ingredients.Ingredient;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();

    public void ajouter (Ingredient ingredient)
    {
        if (ingredient == null) {
            throw new NullPointerException("L'ingrédient ne peut pas être null");
        }
        lesIngredients.add(ingredient);
    }

    public int getTaille() {
        return lesIngredients.size();
    }

    public boolean contient(Ingredient ingredient) {
        return lesIngredients.contains(ingredient);
    }

}
