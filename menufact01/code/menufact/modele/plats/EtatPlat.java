package modele.plats;

public interface EtatPlat {

    public void preparer(PlatChoisi plat);
    public void terminer(PlatChoisi plat);
    public void servir(PlatChoisi plat);
    public void rendreInservable(PlatChoisi plat);
    public String afficher(PlatChoisi plat);
}
