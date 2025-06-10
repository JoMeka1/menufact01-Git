package menufact.modele.ingredients;

import java.util.List;
import java.util.Map;
import menufact.modele.ingredients.exceptions.IngredientException;

public class StockVerifie {
    private Map<Ingredient, IngredientInventaire> stock;

    public StockVerifie(Map<Ingredient, IngredientInventaire> stock) {
        this.stock = stock;
    }

    public boolean estDisponible(List<IngredientRequis> requis) {
        for (IngredientRequis iq : requis) {
            IngredientInventaire ii = stock.get(iq.getIngredient());
            if (ii == null || ii.getQuantite() < iq.getQuantite()) {
                return false;
            }
        }
        return true;
    }

    public void consommer(List<IngredientRequis> requis) throws IngredientException {
        if (!estDisponible(requis)) {
            throw new IngredientException("Ingrédients insuffisants.");
        }
        for (IngredientRequis iq : requis) {
            IngredientInventaire ii = stock.get(iq.getIngredient());
            ii.retirerQuantite(iq.getQuantite());
        }
    }
}
