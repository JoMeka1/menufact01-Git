package menufact.vue;

import menufact.controleur.facture.Facture;
import menufact.controleur.facture.exceptions.FactureException;
import menufact.modele.Client;
import menufact.modele.Chef;
import menufact.modele.Observateur;
import menufact.modele.exceptions.MenuException;
import menufact.modele.plats.*;
import menufact.modele.Menu;

public class TestMenuFact02 {

    public static void main(String[] args) {
        boolean trace = true;
        TestMenuFact02 t = new TestMenuFact02();

        // Utilisation de ConcretePlatFactory pour créer les plats
        ConcretePlatFactory factory = new ConcretePlatFactory();
        Plat p1 = factory.creerPlat(TypePlat.NORMAL, 0, "PlatAuMenu0", 10.0, 0.0, 0.0, 0.0, 0.0);
        Plat p2 = factory.creerPlat(TypePlat.NORMAL, 1, "PlatAuMenu1", 20.0, 0.0, 0.0, 0.0, 0.0);
        Plat p3 = factory.creerPlat(TypePlat.NORMAL, 2, "PlatAuMenu2", 30.0, 0.0, 0.0, 0.0, 0.0);
        Plat p4 = factory.creerPlat(TypePlat.NORMAL, 3, "PlatAuMenu3", 40.0, 0.0, 0.0, 0.0, 0.0);
        Plat p5 = factory.creerPlat(TypePlat.NORMAL, 4, "PlatAuMenu4", 50.0, 0.0, 0.0, 0.0, 0.0);
        Plat ps1 = factory.creerPlat(TypePlat.SANTE, 10, "PlatSante0", 10.0, 200.0, 0.0, 5.0, 0.0);
        Plat ps2 = factory.creerPlat(TypePlat.SANTE, 11, "PlatSante1", 20.0, 200.0, 0.0, 5.0, 0.0);
        Plat ps3 = factory.creerPlat(TypePlat.SANTE, 12, "PlatSante2", 30.0, 200.0, 0.0, 5.0, 0.0);
        Plat ps4 = factory.creerPlat(TypePlat.SANTE, 13, "PlatSante3", 40.0, 200.0, 0.0, 5.0, 0.0);
        Plat ps5 = factory.creerPlat(TypePlat.SANTE, 14, "PlatSante4", 50.0, 200.0, 0.0, 5.0, 0.0);

        Menu m1 = Menu.getInstance("menufact.Menu 1");
        Menu m2 = Menu.getInstance("menufact.Menu 2");

        Facture f1 = new Facture("Ma facture");

        Client c1 = new Client(1, "Mr Client", "1234567890");
        Observateur chef = new Chef();

        t.test1_AffichePlats(trace, p1, p2, p3, p4, p5);
        t.test2_AffichePlatsSante(trace, ps1, ps2, ps3, ps4, ps5);

        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2, m2, p3, p4, ps3, ps4);

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
            t.test7_CreerFacture(f1, m1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        t.test8_AjouterClientFacture(f1, c1);

        try {
            t.test8_AjouterPlatsFacture(f1, m1, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        t.test9_PayerFacture(f1);

        try {
            t.test10_FermerFacture(f1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test8_AjouterPlatsFacture(f1, m1, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            f1.ouvrir();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("FIN DE TOUS LES TESTS...");
        System.out.println(f1.afficherMontants());
    }

    private void test1_AffichePlats(boolean trace, Plat p1, Plat p2, Plat p3, Plat p4, Plat p5) {
        System.out.println("=== test1_AffichePlats");
        if (trace) {
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
        }
    }

    private void test2_AffichePlatsSante(boolean trace, Plat ps1, Plat ps2, Plat ps3, Plat ps4, Plat ps5) {
        System.out.println("=== test2_AffichePlatsSante");
        if (trace) {
            System.out.println(ps1);
            System.out.println(ps2);
            System.out.println(ps3);
            System.out.println(ps4);
            System.out.println(ps5);
        }
    }

    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1, Plat p1, Plat p2, Plat ps1, Plat ps2, Menu m2, Plat p3, Plat p4, Plat ps3, Plat ps4) {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);

        System.out.println("=== Ajout de plats au menu 2");
        m2.ajoute(p3);
        m2.ajoute(p4);
        m2.ajoute(ps3);
        m2.ajoute(ps4);

        if (trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }

    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException {
        System.out.println("=== test5_DeplacementMenuAvancer");
        System.out.println("=== Selectionner un plat du menu 0");
        m1.position(0);

        System.out.println("=== Afficher le plat courant");
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
        System.out.println("=== Selectionner un plat du menu 3");
        m1.position(3);

        System.out.println("=== Afficher le plat courant");
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

    private void test7_CreerFacture(Facture f1, Menu m1) throws Exception {
        System.out.println("=== test7_CreerFacture");
        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(), 5);
        try {
            f1.ajoutePlat(platChoisi);
        } catch (Exception e) {
            throw e;
        }
        System.out.println(f1);
    }

    private void test8_AjouterClientFacture(Facture f1, Client c1) {
        System.out.println("=== test8_AjouterClientFacture");
        f1.associerClient(c1);
        System.out.println(f1);
    }

    private void test8_AjouterPlatsFacture(Facture f1, Menu m1, int pos) throws Exception {
        System.out.println("=== test8_AjouterPlatsFacture");
        try {
            for (int i = 0; i < pos; i++) {
                m1.positionSuivante();
            }
        } catch (MenuException me) {
            throw me;
        }
        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(), 5);
        try {
            f1.ajoutePlat(platChoisi);
        } catch (Exception e) {
            throw e;
        }
        System.out.println(f1);
    }

    private void test9_PayerFacture(Facture f1) {
        System.out.println("=== test9_PayerFacture");
        System.out.println("Avant payer la facture");
        System.out.println(f1);
        try {
            f1.payer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Après avoir payé la facture");
        System.out.println(f1.afficherMontants());
    }

    private void test10_FermerFacture(Facture f1) {
        System.out.println("=== test10_FermerFacture");
        System.out.println("Avant fermer la facture");
        System.out.println(f1);
        try {
            f1.fermer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Après avoir fermé la facture");
        System.out.println(f1.afficherMontants());
    }
}