package modele.plats;

import modele.ingredients.Ingredient;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe abstraite servant de base pour le pattern Décorateur dans le système Menufact.
 * Cette classe permet d'enrichir un plat existant avec des fonctionnalités ou des ingrédients supplémentaires
 * tout en préservant l'interface {@link Plat}.
 */
public abstract class PlatDecorator implements Plat {
    /** Le plat sous-jacent à décorer. */
    protected Plat plat;

    /** Map des ingrédients spécifiques ajoutés par le décorateur, avec leurs quantités. */
    protected Map<Ingredient, Double> ingredientQuantities;

    /**
     * Construit un décorateur pour un plat donné, en copiant ses quantités d'ingrédients.
     *
     * @param plat Le plat à décorer.
     */
    public PlatDecorator(Plat plat) {
        this.plat = plat;
        this.ingredientQuantities = new HashMap<>(plat.getIngredientQuantities());
    }

    /**
     * Construit un décorateur pour un plat donné avec une map d'ingrédients spécifiques.
     * Si la map fournie est null, les ingrédients du plat sous-jacent sont utilisés.
     *
     * @param plat Le plat à décorer.
     * @param ingredientQuantities Une map associant les ingrédients supplémentaires à leurs quantités.
     */
    public PlatDecorator(Plat plat, Map<Ingredient, Double> ingredientQuantities) {
        this.plat = plat;
        this.ingredientQuantities = new HashMap<>(ingredientQuantities != null ? ingredientQuantities : plat.getIngredientQuantities());
    }

    /**
     * Retourne la description du plat décoré.
     * Par défaut, délègue au plat sous-jacent.
     *
     * @return La description du plat.
     */
    @Override
    public String getDescription() {
        return plat.getDescription();
    }

    /**
     * Retourne le prix du plat décoré.
     * Par défaut, délègue au plat sous-jacent.
     *
     * @return Le prix du plat.
     */
    @Override
    public double getPrix() {
        return plat.getPrix();
    }

    /**
     * Retourne le code unique du plat décoré.
     * Par défaut, délègue au plat sous-jacent.
     *
     * @return Le code du plat.
     */
    @Override
    public int getCode() {
        return plat.getCode();
    }

    /**
     * Retourne une représentation textuelle du plat décoré, incluant les informations du plat sous-jacent
     * et les ingrédients spécifiques au décorateur.
     *
     * @return Une chaîne décrivant le plat décoré.
     */
    @Override
    public String toString() {
        return plat.toString() + " (décoré avec ingredients=" + ingredientQuantities + ")";
    }

    /**
     * Retourne une map combinée des quantités d'ingrédients requises par le plat sous-jacent
     * et celles ajoutées par le décorateur.
     *
     * @return Une map associant chaque ingrédient à sa quantité requise.
     */
    @Override
    public Map<Ingredient, Double> getIngredientQuantities() {
        Map<Ingredient, Double> allIngredients = new HashMap<>(plat.getIngredientQuantities());
        allIngredients.putAll(ingredientQuantities);
        return allIngredients;
    }

    /**
     * Ajoute un ingrédient avec sa quantité à la map des ingrédients du décorateur.
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