package modele.plats;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtatEnPreparationTest {
    private EtatEnPreparation etat;
    private PlatChoisi platChoisi;

    @BeforeEach
    void setUp() {
        etat = new EtatEnPreparation(); // Vérifie que cette ligne compile
        platChoisi = new PlatChoisi(new PlatAuMenu(1, "Poulet Rôti", 12.50), 1.0);
        platChoisi.setEtatCourant(etat); // Simule l'état après ajout par Chef
    }

    @Test
    void preparerThrowsException() {
        assertThrows(IllegalStateException.class, () -> etat.preparer(platChoisi),
                "Devrait lever une IllegalStateException car déjà en préparation");
        assertEquals(etat, platChoisi.getEtatCourant());
    }

    @Test
    void terminerChangesState() {
        etat.terminer(platChoisi);
        assertTrue(platChoisi.getEtatCourant() instanceof EtatTermine,
                "Devrait passer à EtatTermine comme dans l'intégration");
    }

    @Test
    void servirChangesState() {
        etat.servir(platChoisi);
        assertTrue(platChoisi.getEtatCourant() instanceof EtatServi,
                "Devrait passer à EtatServi comme dans l'intégration");
    }

    @Test
    void rendreInservableChangesState() {
        etat.rendreInservable(platChoisi);
        assertTrue(platChoisi.getEtatCourant() instanceof EtatPasServable,
                "Devrait passer à EtatPasServable comme dans l'intégration");
    }

    @Test
    void afficherReturnsCorrectMessage() {
        assertEquals("Plat en préparation", etat.afficher(platChoisi),
                "Devrait retourner 'Plat en préparation' comme dans l'intégration");
    }
}