package menufact.controleur.facture;

import menufact.controleur.facture.exceptions.FactureException;
import menufact.modele.plats.PlatChoisi;

public class EtatFermee extends FactureEtat{

    public EtatFermee(Facture facture) {
        super(facture);
    }

    @Override
    public void ajouterPlat(PlatChoisi plat) throws Exception {
        throw new Exception("La facture est fermée, impossible d'ajouter un plat.");
    }

    @Override
    public void retirerPlat(PlatChoisi plat) throws Exception {
        throw new Exception("La facture est fermée, impossible de retirer un plat.");
    }

    @Override
    public void fermer() throws Exception {
        throw new Exception("La facture est déjà fermée.");
    }

    @Override
    public void selectionnerPlat(PlatChoisi plat) throws Exception {
        throw new Exception("La facture est fermée, impossible de sélectionner un plat.");
    }

    @Override
    public void ouvrir() throws Exception {
        throw new Exception("La facture est fermée, impossible de l'ouvrir.");
    }

    @Override
    public String afficherMontants(Facture facture) {
        double sousTotal = facture.sousTotal();
        double taxes = facture.tps() + facture.tvq();
        double total = sousTotal + taxes;
        return String.format("Facture fermée - Sous-total: %.2f$, Taxes: %.2f$, Total: %.2f$", sousTotal, taxes, total);}

    @Override
    public void payer() throws Exception {
        throw new Exception("La facture est fermée, impossible de la payer.");
    }
}
