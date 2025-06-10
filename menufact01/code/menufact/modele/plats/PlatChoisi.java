package menufact.modele.plats;

import menufact.modele.plats.Plat;

public class PlatChoisi {
    private Plat plat;
    private EtatPlat etatCourant;
    private double quantite;

    public PlatChoisi(Plat plat, double quantite) {
        if (plat instanceof PlatAuMenu || plat instanceof PlatDecorator) {
            this.plat = plat;
        } else {
            throw new IllegalArgumentException("Plat doit être un PlatAuMenu ou un décorateur");
        }
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

    public Plat getPlat() {
        return plat;
    }

    public void setEtatCourant(EtatPlat etat) {
        this.etatCourant = etat;
    }
}
