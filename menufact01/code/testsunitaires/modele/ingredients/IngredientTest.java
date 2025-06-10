package modele.ingredients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    private Ingredient ingredient;
    private final String TEST_NOM = "Pomme";
    private final String TEST_DESCRIPTION = "Pomme rouge sucrée";
    private final TypeIngredient TEST_TYPE = TypeIngredient.FRUIT;
    private final UniteMesure TEST_UNITE = new UniteSolide();

    @BeforeEach
    void setUp() {
        // Initialiser un ingrédient avec des valeurs de test avant chaque test
        ingredient = new Ingredient(TEST_NOM, TEST_DESCRIPTION, TEST_TYPE, TEST_UNITE);
    }

    @Test
    void getNom() {
        // Vérifier que getNom retourne le nom défini dans le constructeur
        assertEquals(TEST_NOM, ingredient.getNom(), "Le nom devrait être celui défini dans le constructeur");

        // Tester avec un ingrédient créé via le constructeur par défaut
        Ingredient defaultIngredient = new Ingredient();
        assertNull(defaultIngredient.getNom(), "Le nom devrait être null pour un ingrédient par défaut");
    }

    @Test
    void setNom() {
        // Tester le changement de nom avec une valeur valide
        String nouveauNom = "Poire";
        ingredient.setNom(nouveauNom);
        assertEquals(nouveauNom, ingredient.getNom(), "Le nom devrait être mis à jour");

        // Tester avec une valeur nulle
        ingredient.setNom(null);
        assertNull(ingredient.getNom(), "Le nom devrait pouvoir être défini à null");

        // Tester avec une chaîne vide
        ingredient.setNom("");
        assertEquals("", ingredient.getNom(), "Le nom devrait pouvoir être une chaîne vide");
    }

    @Test
    void getDescription() {
        // Vérifier que getDescription retourne la description définie dans le constructeur
        assertEquals(TEST_DESCRIPTION, ingredient.getDescription(), "La description devrait être celle définie dans le constructeur");

        // Tester avec un ingrédient créé via le constructeur par défaut
        Ingredient defaultIngredient = new Ingredient();
        assertNull(defaultIngredient.getDescription(), "La description devrait être null pour un ingrédient par défaut");
    }

    @Test
    void setDescription() {
        // Tester le changement de description avec une valeur valide
        String nouvelleDescription = "Poire verte juteuse";
        ingredient.setDescription(nouvelleDescription);
        assertEquals(nouvelleDescription, ingredient.getDescription(), "La description devrait être mise à jour");

        // Tester avec une valeur nulle
        ingredient.setDescription(null);
        assertNull(ingredient.getDescription(), "La description devrait pouvoir être définie à null");

        // Tester avec une chaîne vide
        ingredient.setDescription("");
        assertEquals("", ingredient.getDescription(), "La description devrait pouvoir être une chaîne vide");
    }

    @Test
    void getTypeIngredient() {
        // Vérifier que getTypeIngredient retourne le type défini dans le constructeur
        assertEquals(TEST_TYPE, ingredient.getTypeIngredient(), "Le type d'ingrédient devrait être celui défini dans le constructeur");

        // Tester avec un ingrédient créé via le constructeur par défaut
        Ingredient defaultIngredient = new Ingredient();
        assertNull(defaultIngredient.getTypeIngredient(), "Le type d'ingrédient devrait être null pour un ingrédient par défaut");
    }

    @Test
    void setTypeIngredient() {
        // Tester le changement de type avec une valeur valide
        TypeIngredient nouveauType = TypeIngredient.LEGUME;
        ingredient.setTypeIngredient(nouveauType);
        assertEquals(nouveauType, ingredient.getTypeIngredient(), "Le type d'ingrédient devrait être mis à jour");

        // Tester avec une valeur nulle
        ingredient.setTypeIngredient(null);
        assertNull(ingredient.getTypeIngredient(), "Le type d'ingrédient devrait pouvoir être défini à null");
    }

    @Test
    void getUnite() {
        // Vérifier que getUnite retourne l'unité définie dans le constructeur
        assertEquals(TEST_UNITE, ingredient.getUnite(), "L'unité de mesure devrait être celle définie dans le constructeur");

        // Tester avec un ingrédient créé via le constructeur par défaut
        Ingredient defaultIngredient = new Ingredient();
        assertNull(defaultIngredient.getUnite(), "L'unité de mesure devrait être null pour un ingrédient par défaut");
    }

    @Test
    void setUnite() {
        // Tester le changement d'unité avec une valeur valide
        UniteMesure nouvelleUnite = new UniteLiquide();
        ingredient.setUnite(nouvelleUnite);
        assertEquals(nouvelleUnite, ingredient.getUnite(), "L'unité de mesure devrait être mise à jour");

        // Tester avec une valeur nulle
        ingredient.setUnite(null);
        assertNull(ingredient.getUnite(), "L'unité de mesure devrait pouvoir être définie à null");
    }
}