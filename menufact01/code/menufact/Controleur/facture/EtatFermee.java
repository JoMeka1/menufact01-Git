package controleur.facture;

import controleur.facture.exceptions.FactureException;
import modele.plats.PlatChoisi;

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
        System.out.println("Facture fermer");
    }

    @Override
    public  void selectionnerPlat(PlatChoisi plat){

    }

    @Override
    public void ouvrir() {
        try {
            facture.ouvrir();
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String afficher(Facture facture) {
        double sousTotal = facture.sousTotal();
        double taxes = facture.tps() + facture.tvq();
        double total = sousTotal + taxes;
        return String.format("Facture fermée - Sous-total: %.2f$, Taxes: %.2f$, Total: %.2f$", sousTotal, taxes, total);}

    @Override
    public void payer(){
        facture.payer();
    }
}
