package modele;

import modele.plats.PlatAuMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatAuMenuTest {
    private PlatAuMenu plat;

    @BeforeEach
    void setUp() {
        plat = new PlatAuMenu(1, "Poulet Rôti", 12.50);
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
        String result = plat.toString();
        assertTrue(result.contains("code=1") && result.contains("description='Poulet Rôti'") && result.contains("prix=12.5"),
                "toString devrait inclure code=1, description='Poulet Rôti' et prix=12.5");
    }

    @Test
    void setCode() {
        plat.setCode(2);
        assertEquals(2, plat.getCode(), "Le code devrait être mis à jour à 2");
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
    void constructorWithoutArgs() {
        PlatAuMenu emptyPlat = new PlatAuMenu();
        assertNull(emptyPlat.getDescription(), "La description devrait être null par défaut");
        assertEquals(0.0, emptyPlat.getPrix(), 0.01, "Le prix devrait être 0.0 par défaut");
        assertEquals(0, emptyPlat.getCode(), "Le code devrait être 0 par défaut");
    }
}