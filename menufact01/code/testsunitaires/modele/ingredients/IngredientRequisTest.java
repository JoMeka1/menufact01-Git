package modele.ingredients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientRequisTest {

    private IngredientRequis ingredientRequis;
    private Ingredient ingredient;
    private final double TEST_QUANTITE = 50.0;

    @BeforeEach
    void setUp() {
        // Initialiser un ingrédient et un IngredientRequis avant chaque test
        ingredient = new Ingredient("Pomme", "Pomme rouge sucrée", TypeIngredient.FRUIT, new UniteSolide());
        ingredientRequis = new IngredientRequis(ingredient, TEST_QUANTITE);
    }

    @Test
    void getIngredient() {
        // Vérifier que getIngredient retourne l'ingrédient défini dans le constructeur
        assertEquals(ingredient, ingredientRequis.getIngredient(), "L'ingrédient devrait être celui défini dans le constructeur");

        // Tester avec un ingrédient null
        IngredientRequis requisNull = new IngredientRequis(null, TEST_QUANTITE);
        assertNull(requisNull.getIngredient(), "L'ingrédient devrait être null si défini comme tel dans le constructeur");
    }

    @Test
    void getQuantite() {
        // Vérifier que getQuantite retourne la quantité définie dans le constructeur
        assertEquals(TEST_QUANTITE, ingredientRequis.getQuantite(), "La quantité devrait être celle définie dans le constructeur");

        // Tester avec une quantité nulle (0.0)
        IngredientRequis requisZero = new IngredientRequis(ingredient, 0.0);
        assertEquals(0.0, requisZero.getQuantite(), "La quantité devrait pouvoir être 0");

        // Tester avec une quantité négative
        IngredientRequis requisNegatif = new IngredientRequis(ingredient, -10.0);
        assertEquals(-10.0, requisNegatif.getQuantite(), "La quantité devrait pouvoir être négative");

        // Tester avec une quantité très grande
        IngredientRequis requisGrand = new IngredientRequis(ingredient, Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, requisGrand.getQuantite(), "La quantité devrait pouvoir être très grande");
    }
}