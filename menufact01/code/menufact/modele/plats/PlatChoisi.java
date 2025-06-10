package modele.plats;

import modele.plats.PlatAuMenu;

public class PlatChoisi {
    private PlatAuMenu plat;
    private EtatPlat etatCourant;
    private double quantite;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etatCourant = new EtatCommande();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public void setEtatCourant(EtatPlat etat) {
        this.etatCourant = etat;
    }
}
