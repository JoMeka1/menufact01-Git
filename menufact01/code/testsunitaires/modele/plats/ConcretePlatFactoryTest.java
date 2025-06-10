package modele.plats;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcretePlatFactoryTest {
    private ConcretePlatFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ConcretePlatFactory();
    }

    @Test
    void creerPlatNormal() {
        Plat plat = factory.creerPlat(TypePlat.NORMAL, 1, "Poulet Rôti", 12.50, 0.0, 0.0, 0.0, 0.0);
        assertNotNull(plat, "Le plat créé ne devrait pas être null");
        assertTrue(plat instanceof PlatAuMenu, "Devrait créer un PlatAuMenu pour NORMAL");
        assertEquals(1, plat.getCode(), "Le code devrait être 1");
        assertEquals("Poulet Rôti", plat.getDescription(), "La description devrait être 'Poulet Rôti'");
        assertEquals(12.50, plat.getPrix(), 0.01, "Le prix devrait être 12.50");
    }

    @Test
    void creerPlatSante() {
        Plat plat = factory.creerPlat(TypePlat.SANTE, 2, "Salade Santé", 8.00, 300.0, 50.0, 5.0, 0.0);
        assertNotNull(plat, "Le plat créé ne devrait pas être null");
        assertTrue(plat instanceof SanteDecorateur, "Devrait créer un SanteDecorateur pour SANTE");
        assertEquals(2, plat.getCode(), "Le code devrait être 2");
        assertEquals("Salade Santé", plat.getDescription(), "La description devrait être 'Salade Santé'");
        assertEquals(8.00, plat.getPrix(), 0.01, "Le prix devrait être 8.00");
    }

    @Test
    void creerPlatEnfant() {
        Plat plat = factory.creerPlat(TypePlat.ENFANT, 3, "Poulet Enfant", 6.00, 0.0, 0.0, 0.0, 0.5);
        assertNotNull(plat, "Le plat créé ne devrait pas être null");
        assertTrue(plat instanceof EnfantDecorator, "Devrait créer un EnfantDecorator pour ENFANT");
        assertEquals(3, plat.getCode(), "Le code devrait être 3");
        assertEquals("Poulet Enfant", plat.getDescription(), "La description devrait être 'Poulet Enfant'");
        assertEquals(3.00, plat.getPrix(), 0.01, "Le prix devrait être 3.00");
    }

    @Test
    void creerPlatNormalWithExtras() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.NORMAL, 1, "Poulet Rôti", 12.50, 100.0, 0.0, 0.0, 0.0),
                "Devrait lever une exception pour des extras sur un plat NORMAL");
    }

    @Test
    void creerPlatSanteInvalidMetrics() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.SANTE, 2, "Salade Santé", 8.00, -1.0, 50.0, 5.0, 0.0),
                "Devrait lever une exception pour kcal négatif");
    }

    @Test
    void creerPlatSanteWithProportion() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.SANTE, 2, "Salade Santé", 8.00, 300.0, 50.0, 5.0, 0.5),
                "Devrait lever une exception pour une proportion sur un plat SANTE");
    }

    @Test
    void creerPlatEnfantInvalidProportion() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.ENFANT, 3, "Poulet Enfant", 6.00, 0.0, 0.0, 0.0, 1.5),
                "Devrait lever une exception pour une proportion > 1");
    }

    @Test
    void creerPlatEnfantWithMetrics() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.ENFANT, 3, "Poulet Enfant", 6.00, 100.0, 0.0, 0.0, 0.5),
                "Devrait lever une exception pour des métriques sur un plat ENFANT");
    }

    @Test
    void creerPlatUnknownType() {
        assertThrows(IllegalArgumentException.class, () ->
                        factory.creerPlat(TypePlat.valueOf("INVALIDE"), 1, "Invalide", 10.00, 0.0, 0.0, 0.0, 0.0),
                "Devrait lever une exception pour un type inconnu");
    }
}
