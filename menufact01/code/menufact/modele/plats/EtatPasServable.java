package modele.plats;

public class EtatPasServable implements EtatPlat {
    @Override
    public void preparer(PlatChoisi plat) {

    }

    @Override
    public void terminer(PlatChoisi plat) {

    }

    @Override
    public void servir(PlatChoisi plat) {

    }

    @Override
    public void rendreInservable(PlatChoisi plat) {

    }

    @Override
    public String afficher(PlatChoisi plat) {
        return "Impossible de servir ce plat";
    }
}
