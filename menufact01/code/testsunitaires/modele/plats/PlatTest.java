package modele.plats;

import modele.ingredients.Ingredient;
import modele.ingredients.TypeIngredient;
import modele.ingredients.UniteSolide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlatTest {
    private PlatAuMenu plat;

    @BeforeEach
    void setUp() {
        Map<Ingredient, Double> ingredientQuantities = new HashMap<>();
        ingredientQuantities.put(new Ingredient("Tomate", "Légume rouge", TypeIngredient.LEGUME, new UniteSolide()), 200.0);
        plat = new PlatAuMenu(1, "Poulet Rôti", 12.50, ingredientQuantities);
    }

    @Test
    void getDescription() {
        assertEquals("Poulet Rôti", plat.getDescription(), "La description devrait être 'Poulet Rôti'");
    }

    @Test
    void getPrix() {
        assertEquals(12.50, plat.getPrix(), 0.01, "Le prix devrait être 12.50");
    }

    @Test
    void getCode() {
        assertEquals(1, plat.getCode(), "Le code devrait être 1");
    }

    @Test
    void testToString() {
        String expected = "PlatAuMenu{code=1, description='Poulet Rôti', prix=12.50, ingredients={Tomate=200.0 g}}";
        assertEquals(expected, plat.toString(), "toString devrait retourner la chaîne attendue avec ingrédients");
    }

    @Test
    void setDescription() {
        plat.setDescription("Poulet Grillé");
        assertEquals("Poulet Grillé", plat.getDescription(), "La description devrait être mise à jour");
    }

    @Test
    void setPrix() {
        plat.setPrix(15.00);
        assertEquals(15.00, plat.getPrix(), 0.01, "Le prix devrait être mis à jour à 15.00");
    }

    @Test
    void setCode() {
        plat.setCode(2);
        assertEquals(2, plat.getCode(), "Le code devrait être mis à jour à 2");
    }

    @Test
    void defaultConstructor() {
        PlatAuMenu emptyPlat = new PlatAuMenu();
        assertNull(emptyPlat.getDescription(), "La description devrait être null par défaut");
        assertEquals(0.0, emptyPlat.getPrix(), 0.01, "Le prix devrait être 0.0 par défaut");
        assertEquals(0, emptyPlat.getCode(), "Le code devrait être 0 par défaut");
        assertTrue(emptyPlat.getIngredientQuantities().isEmpty(), "Les quantités d'ingrédients devraient être vides par défaut");
    }
}