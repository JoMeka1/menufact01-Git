package modele.plats;

import modele.ingredients.Ingredient;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PlatAuMenu implements Plat {
    private int code;
    private String description;
    private double prix;
    private Map<Ingredient, Double> ingredientQuantities = new HashMap<>();

    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
    }

    public PlatAuMenu(int code, String description, double prix, Map<Ingredient, Double> ingredientQuantities) {
        this(code, description, prix);
        if (ingredientQuantities != null) {
            this.ingredientQuantities.putAll(ingredientQuantities);
        }
    }

    public PlatAuMenu() {
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "PlatAuMenu{code=" + code + ", description='" + description + "', prix=" + String.format("%.2f", prix) +
                ", ingredients=" + ingredientQuantities.entrySet().stream()
                .map(e -> e.getKey().getNom() + "=" + e.getValue() + " " + e.getKey().getUnite().getUnite())
                .collect(Collectors.joining(", ", "{", "}")) + "}";
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public Map<Ingredient, Double> getIngredientQuantities() {
        return new HashMap<>(ingredientQuantities);
    }

    public void ajouterIngredient(Ingredient ingredient, double quantite) {
        if (ingredient != null && quantite > 0) {
            ingredientQuantities.put(ingredient, quantite);
        }
    }
}