package modele.ingredients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniteLiquideTest {

    private UniteLiquide uniteLiquide;

    @BeforeEach
    void setUp() {
        // Initialiser une instance d'UniteLiquide avant chaque test
        uniteLiquide = new UniteLiquide();
    }

    @Test
    void getUnite() {
        // Vérifier que getUnite retourne "mL"
        assertEquals("mL", uniteLiquide.getUnite(), "L'unité devrait être 'mL'");

        // Vérifier que la valeur retournée n'est pas nulle
        assertNotNull(uniteLiquide.getUnite(), "L'unité ne devrait pas être nulle");

        // Vérifier que plusieurs appels retournent la même valeur
        assertEquals("mL", uniteLiquide.getUnite(), "Les appels répétés à getUnite devraient retourner 'mL'");
    }

    @Test
    void estCompatibleAvec() {
        // Tester la compatibilité avec une autre instance d'UniteLiquide
        UniteLiquide autreUniteLiquide = new UniteLiquide();
        assertTrue(uniteLiquide.estCompatibleAvec(autreUniteLiquide), "Une autre instance d'UniteLiquide devrait être compatible");

        // Tester la compatibilité avec la même instance
        assertTrue(uniteLiquide.estCompatibleAvec(uniteLiquide), "L'unité devrait être compatible avec elle-même");

        // Tester la compatibilité avec une instance d'UniteSolide
        UniteMesure uniteSolide = new UniteSolide();
        assertFalse(uniteLiquide.estCompatibleAvec(uniteSolide), "UniteLiquide ne devrait pas être compatible avec UniteSolide");

        // Tester la compatibilité avec null
        assertFalse(uniteLiquide.estCompatibleAvec(null), "UniteLiquide ne devrait pas être compatible avec null");

        // Tester avec une autre implémentation hypothétique de UniteMesure
        UniteMesure uniteMock = new UniteMesure() {
            @Override
            public String getUnite() { return "kg"; }
            @Override
            public boolean estCompatibleAvec(UniteMesure autre) { return false; }
        };
        assertFalse(uniteLiquide.estCompatibleAvec(uniteMock), "UniteLiquide ne devrait pas être compatible avec une autre implémentation de UniteMesure");
    }
}