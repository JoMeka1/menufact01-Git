package modele;

import modele.plats.EtatCommande;
import modele.plats.EtatEnPreparation;
import modele.plats.PlatChoisi;

public class Chef implements Observateur {
    @Override
    public void actualiser(PlatChoisi plat) {
        plat.setEtatCourant(new EtatEnPreparation());

    }
}
