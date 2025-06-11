package modele.plats;

import modele.ingredients.Ingredient;
import modele.ingredients.TypeIngredient;
import modele.ingredients.UniteSolide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConcretePlatFactoryTest {
    private ConcretePlatFactory factory;
    private Map<Ingredient, Double> ingredientQuantities;

    @BeforeEach
    void setUp() {
        factory = new ConcretePlatFactory();
        ingredientQuantities = new HashMap<>();
        ingredientQuantities.put(new Ingredient("Tomate", "Légume rouge", TypeIngredient.LEGUME, new UniteSolide()), 200.0);
        ingredientQuantities.put(new Ingredient("Sel", "Assaisonnement", TypeIngredient.EPICE, new UniteSolide()), 5.0);
    }

    @Test
    void creerPlatNormal() {
        Plat plat = factory.creerPlat(TypePlat.NORMAL, 1, "Poulet Rôti", 12.50, 0.0, 0.0, 0.0, 0.0, ingredientQuantities);
        assertNotNull(plat, "Le plat créé ne devrait pas être null");
        assertTrue(plat instanceof PlatAuMenu, "Devrait créer un PlatAuMenu pour NORMAL");
        assertEquals(1, plat.getCode(), "Le code devrait être 1");
        assertEquals("Poulet Rôti", plat.getDescription(), "La description devrait être 'Poulet Rôti'");
        assertEquals(12.50, plat.getPrix(), 0.01, "Le prix devrait être 12.50");
        assertEquals(ingredientQuantities, plat.getIngredientQuantities(), "Les quantités d'ingrédients devraient correspondre");
    }

    @Test
    void creerPlatSante() {
        Plat plat = factory.creerPlat(TypePlat.SANTE, 2, "Salade Santé", 8.00, 300.0, 50.0, 5.0, 0.0, ingredientQuantities);
        assertNotNull(plat, "Le plat créé ne devrait pas être null");
        assertTrue(plat instanceof SanteDecorateur, "Devrait créer un SanteDecorateur pour SANTE");
        assertEquals(2, plat.getCode(), "Le code devrait être 2");
        assertEquals("Salade Santé", plat.getDescription(), "La description devrait être 'Salade Santé'");
        assertEquals(8.00, plat.getPrix(), 0.01, "Le prix devrait être 8.00");
        assertEquals(ingredientQuantities, plat.getIngredientQuantities(), "Les quantités d'ingrédients devraient correspondre");
    }

    @Test
    void creerPlatEnfant() {
        Plat plat = factory.creerPlat(TypePlat.ENFANT, 3, "Poulet Enfant", 6.00, 0.0, 0.0, 0.0, 0.5, ingredientQuantities);
        assertNotNull(plat, "Le plat créé ne devrait pas être null");
        assertTrue(plat instanceof EnfantDecorator, "Devrait créer un EnfantDecorator pour ENFANT");
        assertEquals(3, plat.getCode(), "Le code devrait être 3");
        assertEquals("Poulet Enfant", plat.getDescription(), "La description devrait être 'Poulet Enfant'");
        assertEquals(3.00, plat.getPrix(), 0.01, "Le prix devrait être 6.00 * 0.5 = 3.00");
        assertEquals(ingredientQuantities, plat.getIngredientQuantities(), "Les quantités d'ingrédients devraient correspondre");
    }

    @Test
    void creerPlatNormalWithExtras() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.NORMAL, 1, "Poulet Rôti", 12.50, 100.0, 0.0, 0.0, 0.0, ingredientQuantities),
                "Devrait lever une exception pour des extras sur un plat NORMAL");
    }

    @Test
    void creerPlatSanteInvalidMetrics() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.SANTE, 2, "Salade Santé", 8.00, -1.0, 50.0, 5.0, 0.0, ingredientQuantities),
                "Devrait lever une exception pour kcal négatif");
    }

    @Test
    void creerPlatSanteWithProportion() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.SANTE, 2, "Salade Santé", 8.00, 300.0, 50.0, 5.0, 0.5, ingredientQuantities),
                "Devrait lever une exception pour une proportion sur un plat SANTE");
    }

    @Test
    void creerPlatEnfantInvalidProportion() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.ENFANT, 3, "Poulet Enfant", 6.00, 0.0, 0.0, 0.0, 1.5, ingredientQuantities),
                "Devrait lever une exception pour une proportion > 1");
    }

    @Test
    void creerPlatEnfantWithMetrics() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.ENFANT, 3, "Poulet Enfant", 6.00, 100.0, 0.0, 0.0, 0.5, ingredientQuantities),
                "Devrait lever une exception pour des métriques sur un plat ENFANT");
    }

    @Test
    void creerPlatUnknownType() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.valueOf("INVALIDE"), 1, "Invalide", 10.00, 0.0, 0.0, 0.0, 0.0, ingredientQuantities),
                "Devrait lever une exception pour un type inconnu");
    }
}