package modele.plats;

import modele.ingredients.Ingredient;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Représente un plat de base dans le système Menufact, implémentant l'interface Plat.
 * Cette classe définit un plat avec un code unique, une description, un prix, et une map des ingrédients requis avec leurs quantités.
 */
public class PlatAuMenu implements Plat {
    /** Identifiant unique du plat. */
    private int code;

    /** Description textuelle du plat. */
    private String description;

    /** Prix du plat. */
    private double prix;

    /** Map associant chaque ingrédient à la quantité requise pour le plat. */
    private Map<Ingredient, Double> ingredientQuantities = new HashMap<>();

    /**
     * Construit un plat avec un code, une description, et un prix.
     * La map des ingrédients reste vide par défaut.
     *
     * @param code L'identifiant unique du plat.
     * @param description La description textuelle du plat.
     * @param prix Le prix du plat.
     */
    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
    }

    /**
     * Construit un plat avec un code, une description, un prix, et une map d'ingrédients requis.
     *
     * @param code L'identifiant unique du plat.
     * @param description La description textuelle du plat.
     * @param prix Le prix du plat.
     * @param ingredientQuantities Une map associant les ingrédients à leurs quantités requises.
     */
    public PlatAuMenu(int code, String description, double prix, Map<Ingredient, Double> ingredientQuantities) {
        this(code, description, prix);
        if (ingredientQuantities != null) {
            this.ingredientQuantities.putAll(ingredientQuantities);
        }
    }

    /**
     * Construit un plat sans initialisation des attributs.
     * Les attributs restent à leurs valeurs par défaut (0 pour code et prix, null pour description, map vide pour les ingrédients).
     */
    public PlatAuMenu() {
    }

    /**
     * Retourne la description textuelle du plat.
     *
     * @return La description du plat.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Retourne le prix du plat.
     *
     * @return Le prix du plat.
     */
    @Override
    public double getPrix() {
        return prix;
    }

    /**
     * Retourne le code unique du plat.
     *
     * @return Le code du plat.
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * Retourne une représentation textuelle du plat, incluant son code, sa description, son prix, et les quantités d'ingrédients avec leurs unités.
     *
     * @return Une chaîne décrivant le plat.
     */
    @Override
    public String toString() {
        return "PlatAuMenu{code=" + code + ", description='" + description + "', prix=" + String.format("%.2f", prix) +
                ", ingredients=" + ingredientQuantities.entrySet().stream()
                .map(e -> e.getKey().getNom() + "=" + e.getValue() + " " + e.getKey().getUnite().getUnite())
                .collect(Collectors.joining(", ", "{", "}")) + "}";
    }

    /**
     * Définit un nouveau code pour le plat.
     *
     * @param code Le nouvel identifiant du plat.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Définit une nouvelle description pour le plat.
     *
     * @param description La nouvelle description du plat.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Définit un nouveau prix pour le plat.
     *
     * @param prix Le nouveau prix du plat.
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Retourne une copie de la map des ingrédients requis et de leurs quantités.
     *
     * @return Une map associant chaque ingrédient à sa quantité requise.
     */
    @Override
    public Map<Ingredient, Double> getIngredientQuantities() {
        return new HashMap<>(ingredientQuantities);
    }

    /**
     * Ajoute un ingrédient avec sa quantité à la map des ingrédients requis.
     * L'ingrédient et la quantité sont validés avant l'ajout.
     *
     * @param ingredient L'ingrédient à ajouter.
     * @param quantite La quantité requise de l'ingrédient (doit être positive).
     */
    public void ajouterIngredient(Ingredient ingredient, double quantite) {
        if (ingredient != null && quantite > 0) {
            ingredientQuantities.put(ingredient, quantite);
        }
    }
}