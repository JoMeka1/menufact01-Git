package controleur.facture;

import modele.plats.PlatChoisi;

public abstract class FactureEtat {
    protected Facture facture;

    public FactureEtat(Facture facture) {
        this.facture = facture;
    }

    public abstract void ajouterPlat(PlatChoisi plat) throws Exception;
    public abstract void retirerPlat(PlatChoisi plat) throws Exception;
    public abstract void fermer() throws Exception;
    public abstract void ouvrir() throws Exception;
    public abstract void payer() throws Exception;
    public abstract void selectionnerPlat(PlatChoisi plat) throws Exception;
    public abstract String afficherMontants(Facture facture);
    public String afficher(Facture facture) {
        return afficherMontants(facture);
    }
}

