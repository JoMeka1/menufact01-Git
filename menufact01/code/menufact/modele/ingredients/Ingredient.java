package modele.ingredients;

import modele.ingredients.UniteMesure;
import modele.ingredients.TypeIngredient;

/**
 * Représente un ingrédient utilisé dans le système Menufact.
 * Un ingrédient est caractérisé par son nom, sa description, son type (par exemple, fruit, légume), et son unité de mesure (par exemple, grammes, millilitres).
 */
public class Ingredient {
    /** Nom de l'ingrédient. */
    private String nom;

    /** Description de l'ingrédient. */
    private String description;

    /** Type de l'ingrédient, défini par l'énumération TypeIngredient. */
    private TypeIngredient typeIngredient;

    /** Unité de mesure de l'ingrédient, définie par l'interface UniteMesure. */
    private UniteMesure unite;

    /**
     * Construit un ingrédient avec un nom, une description, un type, et une unité de mesure.
     *
     * @param nom Le nom de l'ingrédient.
     * @param description La description de l'ingrédient.
     * @param typeIngredient Le type de l'ingrédient (par exemple, FRUIT, LEGUME).
     * @param unite L'unité de mesure de l'ingrédient (par exemple, UniteSolide, UniteLiquide).
     */
    public Ingredient(String nom, String description, TypeIngredient typeIngredient, UniteMesure unite) {
        this.nom = nom;
        this.description = description;
        this.typeIngredient = typeIngredient;
        this.unite = unite;
    }

    /**
     * Construit un ingrédient sans initialisation des attributs.
     * Les attributs restent à leurs valeurs par défaut (null pour les objets, chaîne vide pour les chaînes).
     */
    public Ingredient() {
        //Voir si ajouter valeurs par defaut ou alors dans les ingredients (legumes...)
    }

    /**
     * Retourne le nom de l'ingrédient.
     *
     * @return Le nom de l'ingrédient.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit un nouveau nom pour l'ingrédient.
     *
     * @param nom Le nouveau nom de l'ingrédient.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la description de l'ingrédient.
     *
     * @return La description de l'ingrédient.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit une nouvelle description pour l'ingrédient.
     *
     * @param description La nouvelle description de l'ingrédient.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le type de l'ingrédient.
     *
     * @return Le type de l'ingrédient, défini par TypeIngredient.
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Définit un nouveau type pour l'ingrédient.
     *
     * @param typeIngredient Le nouveau type de l'ingrédient.
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    /**
     * Retourne l'unité de mesure de l'ingrédient.
     *
     * @return L'unité de mesure de l'ingrédient, définie par UniteMesure.
     */
    public UniteMesure getUnite() {
        return unite;
    }

    /**
     * Définit une nouvelle unité de mesure pour l'ingrédient.
     *
     * @param unite La nouvelle unité de mesure de l'ingrédient.
     */
    public void setUnite(UniteMesure unite) {
        this.unite = unite;
    }
}