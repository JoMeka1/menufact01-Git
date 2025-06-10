package controleur.facture;

import modele.plats.PlatChoisi;

public class EtatOuverte extends FactureEtat {

    public EtatOuverte(Facture facture) {
        super(facture);
    }

    @Override
    public void ajouterPlat(PlatChoisi plat) {
    }

    @Override
    public void retirerPlat(PlatChoisi plat){

    }

    @Override
    public  void fermer(){
        facture.fermer();
    }

    @Override
    public  void selectionnerPlat(PlatChoisi plat){

    }

    @Override
    public void ouvrir(){
        System.out.println("Facture ouverte");
    }

    @Override
    public String afficher() {
        return "";
    }

    @Override
    public void payer(){
        facture.payer();
    }


}
