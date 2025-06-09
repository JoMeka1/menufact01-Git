package menufact.modele;

import menufact.modele.plats.PlatChoisi;

public interface Observateur {
    public abstract void actualiser(PlatChoisi plat);
}
