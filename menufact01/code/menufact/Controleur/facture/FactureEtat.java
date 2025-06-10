package menufact.controleur.facture;

import menufact.modele.plats.PlatChoisi;

public abstract class FactureEtat {
    protected Facture facture;

    public FactureEtat(Facture facture) {
        this.facture = facture;
    }

    public abstract void ajouterPlat(PlatChoisi plat);
    public abstract void retirerPlat(PlatChoisi plat);
    public abstract void fermer();
    public abstract void ouvrir();
    public abstract void payer();
    public abstract void selectionnerPlat(PlatChoisi plat);
    public abstract String afficher();
}

