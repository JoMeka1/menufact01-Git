package menufact.controleur.facture;

import menufact.modele.plats.PlatChoisi;

public class EtatPayee extends FactureEtat {

    public EtatPayee(Facture facture) {
        super(facture);
    }

    @Override
    public void ajouterPlat(PlatChoisi plat) throws Exception {
        throw new Exception("La facture est payée, impossible d'ajouter un plat.");
    }

    @Override
    public void retirerPlat(PlatChoisi plat) throws Exception {
        throw new Exception("La facture est payée, impossible de retirer un plat.");
    }

    @Override
    public void fermer() throws Exception {
        facture.etat = new EtatFermee(facture);
    }

    @Override
    public void selectionnerPlat(PlatChoisi plat) throws Exception {
        throw new Exception("La facture est payée, impossible de sélectionner un plat.");
    }

    @Override
    public void ouvrir() throws Exception {
        throw new Exception("La facture est payée, impossible de l'ouvrir.");
    }

    @Override
    public String afficherMontants(Facture facture) {
        double sousTotal = facture.sousTotal();
        double taxes = facture.tps() + facture.tvq();
        double total = sousTotal + taxes;
        return String.format("Facture payée - Sous-total: %.2f$, Taxes: %.2f$, Total: %.2f$", sousTotal, taxes, total);
    }

    @Override
    public void payer() throws Exception {
        throw new Exception("La facture est déjà payée.");
    }
}
