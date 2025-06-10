package menufact.modele.ingredients;

import menufact.modele.ingredients.UniteMesure;

public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    private UniteMesure unite;

    public Ingredient(String nom, String description, TypeIngredient typeIngredient,UniteMesure unite) {
        this.nom = nom;
        this.description = description;
        this.typeIngredient = typeIngredient;
        this.unite = unite;
    }

    public Ingredient() {
        //Voir si ajouter valeurs par defaut ou alors dans les ingredients (legumes...)
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    public UniteMesure getUnite() {
        return unite;
    }

    public void setUnite(UniteMesure unite) {
        this.unite = unite;
    }
}
