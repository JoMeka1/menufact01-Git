package modele;

import modele.plats.EtatCommande;
import modele.plats.EtatEnPrepararation;
import modele.plats.PlatChoisi;

public class Chef implements Observateur {
    @Override
    public void actualiser(PlatChoisi plat) {
        plat.setEtatCourant(new EtatEnPrepararation());
        // mettre plat a l'etat en preparation
    }
}
