package controleur.facture;

import modele.Client;
import modele.plats.Plat;
import modele.plats.PlatAuMenu;
import modele.plats.PlatChoisi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {
    private Facture facture; // Déclaration au niveau de la classe
    private Client client;
    private PlatChoisi platChoisi;

    @BeforeEach
    void setUp() {
        client = new Client(1, "TestClient", "1234-5678-9012-3456");
        platChoisi = new PlatChoisi(new PlatAuMenu(1, "Poulet Rôti", 12.50), 2.0);
        facture = new Facture("Facture Test"); // Initialisation
        facture.associerClient(client);
    }

    @Test
    void associerClient() {
        Client newClient = new Client(2, "NewClient", "9876-5432-1098-7654");
        facture.associerClient(newClient);
        assertEquals(newClient, facture.getClient(), "Le client devrait être mis à jour");
    }

    // ... (autres tests restent inchangés, juste un extrait ici pour démonstration)
    @Test
    void sousTotal() {
        try {
            facture.ajoutePlat(platChoisi);
            assertEquals(25.0, facture.sousTotal(), 0.01, "Le sous-total devrait être 25.0");
        } catch (Exception e) {
            fail("Aucune exception ne devrait être levée ici: " + e.getMessage());
        }
    }

    // ... (reste du code avec les mocks EtatOuverte, EtatPayee, EtatFermee)
}