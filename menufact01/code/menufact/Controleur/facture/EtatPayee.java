package menufact.controleur.facture;

import menufact.modele.plats.PlatChoisi;

public class EtatPayee extends FactureEtat {

    public EtatPayee(Facture facture) {
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
    }

    @Override
    public String afficher(Facture facture) {
        double sousTotal = facture.sousTotal();
        double taxes = facture.tps() + facture.tvq();
        double total = sousTotal + taxes;
        return String.format("Facture payée - Sous-total: %.2f$, Taxes: %.2f$, Total: %.2f$", sousTotal, taxes, total);
    }

    @Override
    public void payer(){
        System.out.println("Facture payer");
    }
}
