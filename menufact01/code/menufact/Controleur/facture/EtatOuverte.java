package menufact.controleur.facture;

import menufact.modele.plats.PlatChoisi;

public class EtatOuverte extends FactureEtat {

    public EtatOuverte(Facture facture) {
        super(facture);
    }

    @Override
    public void ajouterPlat(PlatChoisi plat) throws Exception {
        facture.platchoisi.add(plat);
        if (facture.observateur != null) {
            facture.observateur.actualiser(plat);
        }
    }

    @Override
    public void retirerPlat(PlatChoisi plat) throws Exception {
        if (facture.platchoisi.contains(plat)) {
            facture.platchoisi.remove(plat);
        } else {
            throw new Exception("Plat non trouvé dans la facture.");
        }
    }

    @Override
    public void fermer() throws Exception {
        throw new Exception("La facture doit être payée avant d'être fermée.");
    }

    @Override
    public void selectionnerPlat(PlatChoisi plat) throws Exception {
        facture.platChoisi = plat;
    }

    @Override
    public void ouvrir() throws Exception {
        throw new Exception("La facture est déjà ouverte.");
    }

    @Override
    public String afficherMontants(Facture facture) {
        return "Facture ouverte - Montants non calculés avant paiement.";
    }

    @Override
    public void payer() throws Exception {
        facture.etat = new EtatPayee(facture);
    }


}
