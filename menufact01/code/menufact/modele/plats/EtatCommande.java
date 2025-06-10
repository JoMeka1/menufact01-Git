package menufact.modele.plats;

public class EtatCommande implements EtatPlat{
    @Override
    public void preparer(PlatChoisi plat) {
        plat.setEtatCourant(new EtatEnPrepararation());
    }

    @Override
    public void terminer(PlatChoisi plat) {
        plat.setEtatCourant(new EtatTermine());
    }

    @Override
    public void servir(PlatChoisi plat) {
        plat.setEtatCourant(new EtatServi());
    }

    @Override
    public void rendreInservable(PlatChoisi plat) {
        plat.setEtatCourant(new EtatPasServable());
    }

    @Override
    public String afficher(PlatChoisi plat) {
        return "";
    }
}
