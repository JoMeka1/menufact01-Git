package modele;

import modele.plats.PlatChoisi;

public interface Observateur {
    public abstract void actualiser(PlatChoisi plat);
}
