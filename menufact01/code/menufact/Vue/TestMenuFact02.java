package vue;

import controleur.facture.Facture;
import controleur.facture.exceptions.FactureException;
import modele.Client;
import modele.Chef;
import modele.Observateur;
import modele.exceptions.MenuException;
import modele.ingredients.Ingredient;
import modele.ingredients.TypeIngredient;
import modele.ingredients.UniteMesure;
import modele.ingredients.UniteSolide;
import modele.plats.*;
import modele.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestMenuFact02 {

    public static void main(String[] args) {
        boolean trace = true;
        TestMenuFact02 t = new TestMenuFact02();

        ConcretePlatFactory factory = new ConcretePlatFactory();
        Map<Ingredient, Double> ingredientQuantities = new HashMap<>();
        ingredientQuantities.put(new Ingredient("Tomate", "Légume rouge", TypeIngredient.LEGUME, new UniteSolide()), 200.0);
        ingredientQuantities.put(new Ingredient("Sel", "Assaisonnement", TypeIngredient.EPICE, new UniteSolide()), 5.0);

        Plat p1 = factory.creerPlat(TypePlat.NORMAL, 0, "PlatAuMenu0", 10.0, 0.0, 0.0, 0.0, 0.0, ingredientQuantities);
        Plat p2 = factory.creerPlat(TypePlat.NORMAL, 1, "PlatAuMenu1", 20.0, 0.0, 0.0, 0.0, 0.0, ingredientQuantities);
        Plat p3 = factory.creerPlat(TypePlat.NORMAL, 2, "PlatAuMenu2", 30.0, 0.0, 0.0, 0.0, 0.0, ingredientQuantities);
        Plat p4 = factory.creerPlat(TypePlat.NORMAL, 3, "PlatAuMenu3", 40.0, 0.0, 0.0, 0.0, 0.0, ingredientQuantities);
        Plat p5 = factory.creerPlat(TypePlat.NORMAL, 4, "PlatAuMenu4", 50.0, 0.0, 0.0, 0.0, 0.0, ingredientQuantities);
        Plat p6 = factory.creerPlat(TypePlat.NORMAL, 5, "PlatAuMenu5", 60.0, 0.0, 0.0, 0.0, 0.0, ingredientQuantities);
        Plat ps1 = factory.creerPlat(TypePlat.SANTE, 10, "PlatSante0", 10.0, 200.0, 0.0, 5.0, 0.0, ingredientQuantities);
        Plat ps2 = factory.creerPlat(TypePlat.SANTE, 11, "PlatSante1", 20.0, 200.0, 0.0, 5.0, 0.0, ingredientQuantities);
        Plat ps3 = factory.creerPlat(TypePlat.SANTE, 12, "PlatSante2", 30.0, 200.0, 0.0, 5.0, 0.0, ingredientQuantities);
        Plat ps4 = factory.creerPlat(TypePlat.SANTE, 13, "PlatSante3", 40.0, 200.0, 0.0, 5.0, 0.0, ingredientQuantities);
        Plat ps5 = factory.creerPlat(TypePlat.SANTE, 14, "PlatSante4", 50.0, 200.0, 0.0, 5.0, 0.0, ingredientQuantities);

        Menu m1 = Menu.getInstance("menufact.Menu 1");

        Facture f1 = new Facture("Ma facture");

        Client c1 = new Client(1, "Mr Client", "1234567890");
        Observateur chef = new Chef();

        t.test1_AffichePlats(trace, p1, p2, p3, p4, p5, p6);
        t.test2_AffichePlatsSante(trace, ps1, ps2, ps3, ps4, ps5);

        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2);

        try {
            t.test5_DeplacementMenuAvancer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test6_DeplacementMenuReculer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test7_CreerFacture(f1, m1, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        t.test8_AjouterClientFacture(f1, c1);

        try {
            t.test8_AjouterPlatsFacture(f1, m1, 1, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test11_EtatPlatEtObservateur(f1, m1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test9_PayerFacture(f1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test10_FermerFacture(f1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test8_AjouterPlatsFacture(f1, m1, 1, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            f1.ouvrir();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("FIN DE TOUS LES TESTS...");
        System.out.println(f1.genererFacture());
    }

    private void test1_AffichePlats(boolean trace, Plat p1, Plat p2, Plat p3, Plat p4, Plat p5, Plat p6) {
        System.out.println("=== test1_AffichePlats");
        if (trace) {
            System.out.println("Plats avec quantités et ingrédients :");
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
            System.out.println(p6);
        }
    }

    private void test2_AffichePlatsSante(boolean trace, Plat ps1, Plat ps2, Plat ps3, Plat ps4, Plat ps5) {
        System.out.println("=== test2_AffichePlatsSante");
        if (trace) {
            System.out.println("Plats santé avec quantités et ingrédients :");
            System.out.println(ps1);
            System.out.println(ps2);
            System.out.println(ps3);
            System.out.println(ps4);
            System.out.println(ps5);
        }
    }

    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1, Plat p1, Plat p2, Plat ps1, Plat ps2) {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1 avec quantités et ingrédients");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);

        if (trace) {
            System.out.println("Menu avec quantités et ingrédients : " + m1);
        }
    }

    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException {
        System.out.println("=== test5_DeplacementMenuAvancer");
        System.out.println("=== Sélectionner le plat à la position 0 du menu");
        m1.position(0);

        System.out.println("=== Afficher le plat courant avec quantités et ingrédients");
        System.out.println(m1.platCourant());
        try {
            System.out.println("=== Avancer le plat courant");
            System.out.println("1.");
            m1.positionSuivante();
            System.out.println("2.");
            m1.positionSuivante();
            System.out.println("3.");
            m1.positionSuivante();
            System.out.println("4.");
            m1.positionSuivante();
            System.out.println("5.");
            m1.positionSuivante();
        } catch (MenuException me) {
            throw me;
        }
    }

    private void test6_DeplacementMenuReculer(Menu m1) throws MenuException {
        System.out.println("=== test6_DeplacementMenuReculer");
        System.out.println("=== Sélectionner le plat à la position 3 du menu");
        m1.position(3);

        System.out.println("=== Afficher le plat courant avec quantités et ingrédients");
        System.out.println(m1.platCourant());
        try {
            System.out.println("=== Reculer le plat courant");
            System.out.println("2.");
            m1.positionPrecedente();
            System.out.println("1.");
            m1.positionPrecedente();
            System.out.println("0.");
            m1.positionPrecedente();
            System.out.println("-1.");
            m1.positionPrecedente();
            System.out.println("-2.");
            m1.positionPrecedente();
        } catch (MenuException me) {
            throw me;
        }
    }

    private void test7_CreerFacture(Facture f1, Menu m1, double quantite) throws Exception {
        System.out.println("=== test7_CreerFacture");
        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(), quantite);
        try {
            f1.ajoutePlat(platChoisi);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("Facture avec quantités et ingrédients : " + f1);
        System.out.println("Sous-total attendu : " + (m1.platCourant().getPrix() * quantite));
        System.out.println("Sous-total réel : " + f1.sousTotal());
        System.out.println("Ingrédients avec quantités : " + platChoisi.getIngredientQuantities());
    }

    private void test8_AjouterClientFacture(Facture f1, Client c1) {
        System.out.println("=== test8_AjouterClientFacture");
        f1.associerClient(c1);
        System.out.println("Facture avec client, quantités et ingrédients : " + f1);
    }

    private void test8_AjouterPlatsFacture(Facture f1, Menu m1, int pos, double quantite) throws Exception {
        System.out.println("=== test8_AjouterPlatsFacture");
        try {
            for (int i = 0; i < pos; i++) {
                m1.positionSuivante();
            }
        } catch (MenuException me) {
            throw me;
        }
        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(), quantite);
        try {
            f1.ajoutePlat(platChoisi);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("Facture avec plat ajouté, quantités et ingrédients : " + f1);
        System.out.println("Sous-total attendu : " + (m1.platCourant().getPrix() * quantite));
        System.out.println("Sous-total réel : " + f1.sousTotal());
        System.out.println("Ingrédients avec quantités : " + platChoisi.getIngredientQuantities());
    }

    private void test9_PayerFacture(Facture f1) {
        System.out.println("=== test9_PayerFacture");
        System.out.println("Avant payer la facture avec quantités et ingrédients : " + f1);
        try {
            f1.payer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Après avoir payé la facture : " + f1.afficherMontants());
    }

    private void test10_FermerFacture(Facture f1) {
        System.out.println("=== test10_FermerFacture");
        System.out.println("Avant fermer la facture avec quantités et ingrédients : " + f1);
        try {
            f1.fermer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Après avoir fermé la facture : " + f1.afficherMontants());
    }

    private void test11_EtatPlatEtObservateur(Facture f1, Menu m1, double quantite) throws Exception {
        System.out.println("=== test11_EtatPlatEtObservateur");
        System.out.println("=== Créer et ajouter un plat à la facture pour tester l'observateur");
        m1.position(0);
        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(), quantite);
        try {
            f1.ajoutePlat(platChoisi);
            System.out.println("État du plat après ajout (devrait être EnPreparation) : " + platChoisi.getEtatCourant().getClass().getSimpleName());
            System.out.println("Affichage de l'état EnPreparation : " + platChoisi.getEtatCourant().afficher(platChoisi));
            System.out.println("Ingrédients avec quantités : " + platChoisi.getIngredientQuantities());
            System.out.println("Quantité : " + platChoisi.getQuantite());
            if (!(platChoisi.getEtatCourant() instanceof EtatEnPreparation)) {
                throw new Exception("L'observateur n'a pas mis le plat en EtatEnPreparation.");
            }
            if (!platChoisi.getEtatCourant().afficher(platChoisi).equals("Plat en préparation")) {
                throw new Exception("Affichage de l'état EnPreparation incorrect.");
            }
        } catch (FactureException fe) {
            throw new Exception("Échec de l'ajout du plat : " + fe.getMessage());
        }

        System.out.println("=== Tester les transitions d'état");
        // Transition vers EtatTermine
        platChoisi.getEtatCourant().terminer(platChoisi);
        System.out.println("État après terminer (devrait être Termine) : " + platChoisi.getEtatCourant().getClass().getSimpleName());
        System.out.println("Affichage de l'état Termine : " + platChoisi.getEtatCourant().afficher(platChoisi));
        System.out.println("Ingrédients avec quantités après terminer : " + platChoisi.getIngredientQuantities());
        System.out.println("Quantité après terminer : " + platChoisi.getQuantite());
        if (!(platChoisi.getEtatCourant() instanceof EtatTermine)) {
            throw new Exception("Transition vers EtatTermine échouée.");
        }
        if (!platChoisi.getEtatCourant().afficher(platChoisi).equals("Plat terminé")) {
            throw new Exception("Affichage de l'état Termine incorrect.");
        }

        // Transition vers EtatServi
        platChoisi.getEtatCourant().servir(platChoisi);
        System.out.println("État après servir (devrait être Servi) : " + platChoisi.getEtatCourant().getClass().getSimpleName());
        System.out.println("Affichage de l'état Servi : " + platChoisi.getEtatCourant().afficher(platChoisi));
        System.out.println("Ingrédients avec quantités après servir : " + platChoisi.getIngredientQuantities());
        System.out.println("Quantité après servir : " + platChoisi.getQuantite());
        if (!(platChoisi.getEtatCourant() instanceof EtatServi)) {
            throw new Exception("Transition vers EtatServi échouée.");
        }
        if (!platChoisi.getEtatCourant().afficher(platChoisi).equals("Plat servi")) {
            throw new Exception("Affichage de l'état Servi incorrect.");
        }

        // Tester une transition invalide depuis EtatServi
        System.out.println("=== Tester une transition invalide depuis EtatServi");
        try {
            platChoisi.getEtatCourant().preparer(platChoisi);
            throw new Exception("Préparer un plat servi aurait dû lever une exception.");
        } catch (IllegalStateException e) {
            System.out.println("Exception attendue : " + e.getMessage());
        }

        // Créer un autre plat pour tester EtatPasServable
        System.out.println("=== Tester EtatPasServable");
        PlatChoisi platChoisi2 = new PlatChoisi(m1.platCourant(), 2);
        f1.ajoutePlat(platChoisi2);
        platChoisi2.getEtatCourant().rendreInservable(platChoisi2);
        System.out.println("État après rendre inservable (devrait être PasServable) : " + platChoisi2.getEtatCourant().getClass().getSimpleName());
        System.out.println("Affichage de l'état PasServable : " + platChoisi2.getEtatCourant().afficher(platChoisi2));
        System.out.println("Ingrédients avec quantités après rendre inservable : " + platChoisi2.getIngredientQuantities());
        System.out.println("Quantité après rendre inservable : " + platChoisi2.getQuantite());
        if (!(platChoisi2.getEtatCourant() instanceof EtatPasServable)) {
            throw new Exception("Transition vers EtatPasServable échouée.");
        }
        if (!platChoisi2.getEtatCourant().afficher(platChoisi2).equals("Impossible de servir ce plat")) {
            throw new Exception("Affichage de l'état PasServable incorrect.");
        }

        // Tester une transition invalide depuis EtatPasServable
        System.out.println("=== Tester une transition invalide depuis EtatPasServable");
        try {
            platChoisi2.getEtatCourant().servir(platChoisi2);
            throw new Exception("Servir un plat inservable aurait dû lever une exception.");
        } catch (IllegalStateException e) {
            System.out.println("Exception attendue : " + e.getMessage());
        }

        // Tester une transition invalide depuis EtatCommande
        System.out.println("=== Tester une transition invalide depuis EtatCommande");
        PlatChoisi platChoisi3 = new PlatChoisi(m1.platCourant(), 1);
        try {
            platChoisi3.getEtatCourant().servir(platChoisi3);
            throw new Exception("Servir un plat commandé aurait dû lever une exception.");
        } catch (IllegalStateException e) {
            System.out.println("Exception attendue : " + e.getMessage());
        }
    }
}