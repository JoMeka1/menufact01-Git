package modele.ingredients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniteSolideTest {

    private UniteSolide uniteSolide;

    @BeforeEach
    void setUp() {
        // Initialiser une instance d'UniteSolide avant chaque test
        uniteSolide = new UniteSolide();
    }

    @Test
    void getUnite() {
        // Vérifier que getUnite retourne "g"
        assertEquals("g", uniteSolide.getUnite(), "L'unité devrait être 'g'");

        // Vérifier que la valeur retournée n'est pas nulle
        assertNotNull(uniteSolide.getUnite(), "L'unité ne devrait pas être nulle");

        // Vérifier que plusieurs appels retournent la même valeur
        assertEquals("g", uniteSolide.getUnite(), "Les appels répétés à getUnite devraient retourner 'g'");
    }

    @Test
    void estCompatibleAvec() {
        // Tester la compatibilité avec une autre instance d'UniteSolide
        UniteSolide autreUniteSolide = new UniteSolide();
        assertTrue(uniteSolide.estCompatibleAvec(autreUniteSolide), "Une autre instance d'UniteSolide devrait être compatible");

        // Tester la compatibilité avec la même instance
        assertTrue(uniteSolide.estCompatibleAvec(uniteSolide), "L'unité devrait être compatible avec elle-même");

        // Tester la compatibilité avec une instance d'UniteLiquide
        UniteMesure uniteLiquide = new UniteLiquide();
        assertFalse(uniteSolide.estCompatibleAvec(uniteLiquide), "UniteSolide ne devrait pas être compatible avec UniteLiquide");

        // Tester la compatibilité avec null
        assertFalse(uniteSolide.estCompatibleAvec(null), "UniteSolide ne devrait pas être compatible avec null");

        // Tester avec une autre implémentation hypothétique de UniteMesure
        UniteMesure uniteMock = new UniteMesure() {
            @Override
            public String getUnite() { return "kg"; }
            @Override
            public boolean estCompatibleAvec(UniteMesure autre) { return false; }
        };
        assertFalse(uniteSolide.estCompatibleAvec(uniteMock), "UniteSolide ne devrait pas être compatible avec une autre implémentation de UniteMesure");
    }
}