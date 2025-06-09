package menufact.controleur.facture;

import menufact.modele.plats.PlatChoisi;

public class EtatFermee extends FactureEtat{

    public EtatFermee(Facture facture) {
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

    }

    @Override
    public  void selectionnerPlat(PlatChoisi plat){

    }

    @Override
    public void ouvrir(){
    }

    @Override
    public String afficher() {
        return "";
    }

    @Override
    public void payer(){

    }
}
