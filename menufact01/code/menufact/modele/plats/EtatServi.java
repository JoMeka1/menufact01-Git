package menufact.modele.plats;

public class EtatServi implements EtatPlat {
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
        return "Plat servit";
    }
}
