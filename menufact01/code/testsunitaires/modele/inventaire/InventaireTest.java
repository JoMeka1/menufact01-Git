package modele.inventaire;

import modele.ingredients.Ingredient;
import modele.ingredients.TypeIngredient;
import modele.ingredients.UniteMesure;
import modele.ingredients.UniteSolide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {
    private Inventaire inventaire;
    private Ingredient ingredient;
    private UniteMesure uniteSolide;

    @BeforeEach
    void setUp() {
        inventaire = new Inventaire();
        uniteSolide = new UniteSolide(); // Instance explicite d'unité solide
        ingredient = new Ingredient("Tomate", "Légume rouge", TypeIngredient.LEGUME, uniteSolide);
        // Vérification que l'unité est compatible avec un légume (solide)
        assertTrue(uniteSolide.estCompatibleAvec(uniteSolide), "L'unité solide doit être compatible avec elle-même pour un légume");
    }

    @Test
    void ajouter() {
        int initialSize = inventaire.getTaille();
        inventaire.ajouter(ingredient);
        assertEquals(initialSize + 1, inventaire.getTaille(), "La taille devrait augmenter de 1");
        assertTrue(inventaire.contient(ingredient), "L'ingrédient devrait être dans la liste");
    }

    @Test
    void ajouterNull() {
        assertThrows(NullPointerException.class, () ->
                inventaire.ajouter(null), "Devrait lever une NullPointerException pour un ingrédient null");
    }

    @Test
    void ajouterDoublon() {
        inventaire.ajouter(ingredient);
        inventaire.ajouter(ingredient); // Ajout du même ingrédient
        assertEquals(2, inventaire.getTaille(), "Devrait accepter les doublons et la taille devrait être 2");
    }
}