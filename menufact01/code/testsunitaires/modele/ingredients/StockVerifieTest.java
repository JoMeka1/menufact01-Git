package modele.ingredients;

import modele.ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StockVerifieTest {

    private StockVerifie stockVerifie;
    private Ingredient pomme;
    private Ingredient carotte;
    private IngredientInventaire inventairePomme;
    private IngredientInventaire inventaireCarotte;
    private Map<Ingredient, IngredientInventaire> stock;

    @BeforeEach
    void setUp() {
        // Initialiser les ingrédients et l'inventaire
        pomme = new Ingredient("Pomme", "Pomme rouge sucrée", TypeIngredient.FRUIT, new UniteSolide());
        carotte = new Ingredient("Carotte", "Carotte fraîche", TypeIngredient.LEGUME, new UniteSolide());
        inventairePomme = new IngredientInventaire(pomme, 100.0); // 100 g de pommes
        inventaireCarotte = new IngredientInventaire(carotte, 50.0); // 50 g de carottes

        // Initialiser le stock avec les inventaires
        stock = new HashMap<>();
        stock.put(pomme, inventairePomme);
        stock.put(carotte, inventaireCarotte);

        // Initialiser StockVerifie
        stockVerifie = new StockVerifie(stock);
    }

    @Test
    void estDisponible() {
        // Tester avec une liste de requis disponibles
        IngredientRequis requisPomme = new IngredientRequis(pomme, 50.0);
        IngredientRequis requisCarotte = new IngredientRequis(carotte, 30.0);
        List<IngredientRequis> requisList = Arrays.asList(requisPomme, requisCarotte);
        assertTrue(stockVerifie.estDisponible(requisList), "Tous les ingrédients requis devraient être disponibles");

        // Tester avec une quantité excessive pour un ingrédient
        IngredientRequis requisPommeTrop = new IngredientRequis(pomme, 150.0);
        List<IngredientRequis> requisTropList = Arrays.asList(requisPommeTrop, requisCarotte);
        assertFalse(stockVerifie.estDisponible(requisTropList), "Un ingrédient en quantité excessive ne devrait pas être disponible");

        // Tester avec un ingrédient non présent
        Ingredient poire = new Ingredient("Poire", "Poire juteuse", TypeIngredient.FRUIT, new UniteSolide());
        IngredientRequis requisPoire = new IngredientRequis(poire, 10.0);
        List<IngredientRequis> requisNonPresentList = Arrays.asList(requisPomme, requisPoire);
        assertFalse(stockVerifie.estDisponible(requisNonPresentList), "Un ingrédient non présent ne devrait pas être disponible");

        // Tester avec une liste vide
        List<IngredientRequis> requisVide = Collections.emptyList();
        assertTrue(stockVerifie.estDisponible(requisVide), "Une liste vide de requis devrait être disponible");

        // Tester avec un ingrédient null dans la liste
        IngredientRequis requisNull = new IngredientRequis(null, 10.0);
        List<IngredientRequis> requisNullList = Arrays.asList(requisPomme, requisNull);
        assertFalse(stockVerifie.estDisponible(requisNullList), "Une liste contenant un ingrédient null ne devrait pas être disponible");

        // Tester avec une quantité nulle
        IngredientRequis requisZero = new IngredientRequis(pomme, 0.0);
        List<IngredientRequis> requisZeroList = Arrays.asList(requisZero);
        assertTrue(stockVerifie.estDisponible(requisZeroList), "Une quantité nulle devrait être disponible");
    }

    @Test
    void consommer() {
        // Tester la consommation d'une liste de requis valides
        IngredientRequis requisPomme = new IngredientRequis(pomme, 50.0);
        IngredientRequis requisCarotte = new IngredientRequis(carotte, 30.0);
        List<IngredientRequis> requisList = Arrays.asList(requisPomme, requisCarotte);
        try {
            stockVerifie.consommer(requisList);
            assertEquals(50.0, inventairePomme.getQuantite(), "La quantité de pommes devrait être réduite à 50 g");
            assertEquals(20.0, inventaireCarotte.getQuantite(), "La quantité de carottes devrait être réduite à 20 g");
        } catch (IngredientException e) {
            fail("La consommation d'une liste valide ne devrait pas lever d'exception : " + e.getMessage());
        }

        // Tester la consommation d'une liste vide
        try {
            stockVerifie.consommer(Collections.emptyList());
            assertEquals(50.0, inventairePomme.getQuantite(), "Une liste vide ne devrait pas modifier le stock de pommes");
            assertEquals(20.0, inventaireCarotte.getQuantite(), "Une liste vide ne devrait pas modifier le stock de carottes");
        } catch (IngredientException e) {
            fail("La consommation d'une liste vide ne devrait pas lever d'exception : " + e.getMessage());
        }

        // Tester la consommation avec une quantité excessive
        IngredientRequis requisPommeTrop = new IngredientRequis(pomme, 60.0);
        List<IngredientRequis> requisTropList = Arrays.asList(requisPommeTrop, requisCarotte);
        IngredientException exception = assertThrows(IngredientException.class, () -> {
            stockVerifie.consommer(requisTropList);
        }, "Consommer une quantité excessive devrait lever une IngredientException");
        assertEquals("IngredientException: Ingrédients insuffisants.", exception.getMessage(), "Le message d'exception devrait être correct");
        assertEquals(50.0, inventairePomme.getQuantite(), "Le stock de pommes ne devrait pas être modifié");
        assertEquals(20.0, inventaireCarotte.getQuantite(), "Le stock de carottes ne devrait pas être modifié");

        // Tester la consommation d'un ingrédient non présent
        Ingredient poire = new Ingredient("Poire", "Poire juteuse", TypeIngredient.FRUIT, new UniteSolide());
        IngredientRequis requisPoire = new IngredientRequis(poire, 10.0);
        List<IngredientRequis> requisNonPresentList = Arrays.asList(requisPomme, requisPoire);
        exception = assertThrows(IngredientException.class, () -> {
            stockVerifie.consommer(requisNonPresentList);
        }, "Consommation d'un ingrédient non présent devrait lever une IngredientException");
        assertEquals("IngredientException: Ingrédients insuffisants.", exception.getMessage(), "Le message d'exception devrait être correct");
        assertEquals(50.0, inventairePomme.getQuantite(), "Le stock de pommes ne devrait pas être modifié");
        assertEquals(20.0, inventaireCarotte.getQuantite(), "Le stock de carottes ne devrait pas être modifié");

        // Tester la consommation avec un ingrédient null
        IngredientRequis requisNull = new IngredientRequis(null, 10.0);
        List<IngredientRequis> requisNullList = Arrays.asList(requisPomme, requisNull);
        exception = assertThrows(IngredientException.class, () -> {
            stockVerifie.consommer(requisNullList);
        }, "Consommation d'un ingrédient null requis devrait lever une IngredientException");
        assertEquals("IngredientException: Ingrédients insuffisants.", exception.getMessage(), "Le message d'exception devrait être correct");
        assertEquals(50.0, inventairePomme.getQuantite(), "Le stock de pommes ne devrait pas être modifié");
        assertEquals(20.0, inventaireCarotte.getQuantite(), "Le stock de carottes ne devrait pas être modifié");
    }
}