package menufact.modele.plats;

public class EtatTermine implements EtatPlat{
    @Override
    public void preparer(PlatChoisi plat) {
        plat.setEtatCourant(new EtatEnPrepararation());
    }

    @Override
    public void terminer(PlatChoisi plat) {
        System.out.println("Etat terminer");
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
