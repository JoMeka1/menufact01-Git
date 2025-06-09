package menufact.modele;

import menufact.modele.plats.PlatChoisi;

public class Chef implements Observateur {
    @Override
    public void actualiser(PlatChoisi plat) {
        // mettre plat a l'etat en preparation
    }
}
