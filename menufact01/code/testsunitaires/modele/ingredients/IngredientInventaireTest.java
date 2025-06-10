package modele.ingredients;

import modele.ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientInventaireTest {

    private IngredientInventaire ingredientInventaire;
    private Ingredient ingredient;
    private final double INITIAL_QUANTITE = 100.0;

    @BeforeEach
    void setUp() {
        // Initialiser un ingrédient et un IngredientInventaire avant chaque test
        ingredient = new Ingredient("Pomme", "Pomme rouge sucrée", TypeIngredient.FRUIT, new UniteSolide());
        ingredientInventaire = new IngredientInventaire(ingredient, INITIAL_QUANTITE);
    }

    @Test
    void getIngredient() {
        // Vérifier que getIngredient retourne l'ingrédient défini dans le constructeur
        assertEquals(ingredient, ingredientInventaire.getIngredient(), "L'ingrédient devrait être celui défini dans le constructeur");

        // Tester avec un ingrédient null
        IngredientInventaire inventaireNull = new IngredientInventaire(null, INITIAL_QUANTITE);
        assertNull(inventaireNull.getIngredient(), "L'ingrédient devrait être null si défini comme tel dans le constructeur");
    }

    @Test
    void retirerQuantite() {
        // Tester le retrait d'une quantité valide
        try {
            ingredientInventaire.retirerQuantite(50.0);
            assertEquals(INITIAL_QUANTITE - 50.0, ingredientInventaire.getQuantite(), "La quantité devrait être réduite de 50.0");
        } catch (IngredientException e) {
            fail("Le retrait d'une quantité valide ne devrait pas lever d'exception : " + e.getMessage());
        }

        // Tester le retrait d'une quantité égale à la quantité restante
        try {
            ingredientInventaire.retirerQuantite(50.0);
            assertEquals(0.0, ingredientInventaire.getQuantite(), "La quantité devrait être 0 après avoir retiré tout le reste");
        } catch (IngredientException e) {
            fail("Le retrait de la quantité restante ne devrait pas lever d'exception : " + e.getMessage());
        }

        // Tester le retrait d'une quantité négative
        try {
            ingredientInventaire.retirerQuantite(-10.0);
            assertEquals(10.0, ingredientInventaire.getQuantite(), "Retirer une quantité négative devrait augmenter la quantité");
        } catch (IngredientException e) {
            fail("Retirer une quantité négative ne devrait pas lever d'exception : " + e.getMessage());
        }

        // Tester le retrait d'une quantité qui rendrait la quantité négative
        IngredientException exception = assertThrows(IngredientException.class, () -> {
            ingredientInventaire.retirerQuantite(20.0);
        }, "Retirer plus que la quantité disponible devrait lever une IngredientException");
        assertEquals("IngredientException: Il n'est pas possible d'avoir une quantité negative", exception.getMessage(), "Le message d'exception devrait être correct");
    }

    @Test
    void getQuantite() {
        // Vérifier que getQuantite retourne la quantité définie dans le constructeur
        assertEquals(INITIAL_QUANTITE, ingredientInventaire.getQuantite(), "La quantité devrait être celle définie dans le constructeur");

        // Tester après modification via setQuantite
        try {
            ingredientInventaire.setQuantite(200.0);
            assertEquals(200.0, ingredientInventaire.getQuantite(), "La quantité devrait être mise à jour après setQuantite");
        } catch (IngredientException e) {
            fail("La définition d'une quantité valide ne devrait pas lever d'exception : " + e.getMessage());
        }
    }

    @Test
    void setQuantite() {
        // Tester la définition d'une quantité valide
        try {
            ingredientInventaire.setQuantite(150.0);
            assertEquals(150.0, ingredientInventaire.getQuantite(), "La quantité devrait être mise à jour à 150.0");
        } catch (IngredientException e) {
            fail("La définition d'une quantité valide ne devrait pas lever d'exception : " + e.getMessage());
        }

        // Tester la définition d'une quantité nulle (0)
        try {
            ingredientInventaire.setQuantite(0.0);
            assertEquals(0.0, ingredientInventaire.getQuantite(), "La quantité devrait pouvoir être définie à 0");
        } catch (IngredientException e) {
            fail("La définition de la quantité à 0 ne devrait pas lever d'exception : " + e.getMessage());
        }

        // Tester la définition d'une quantité négative
        IngredientException exception = assertThrows(IngredientException.class, () -> {
            ingredientInventaire.setQuantite(-10.0);
        }, "Définir une quantité négative devrait lever une IngredientException");
        assertEquals("IngredientException: Il n'est pas possible d'avoir une quantité negative", exception.getMessage(), "Le message d'exception devrait être correct");

        // Tester une quantité très grande
        try {
            ingredientInventaire.setQuantite(Double.MAX_VALUE);
            assertEquals(Double.MAX_VALUE, ingredientInventaire.getQuantite(), "La quantité devrait pouvoir être définie à une valeur très grande");
        } catch (IngredientException e) {
            fail("La définition d'une quantité très grande ne devrait pas lever d'exception : " + e.getMessage());
        }
    }
}