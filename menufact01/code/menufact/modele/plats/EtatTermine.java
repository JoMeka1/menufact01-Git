package modele.plats;

/**
 * Représente l'état d'un plat dont la préparation est terminée.
 * Le plat peut être servi, rendu inservable, ou renvoyé en préparation si nécessaire.
 */
public class EtatTermine implements EtatPlat {

    /**
     * Renvoie le plat en préparation, par exemple pour une modification.
     * @param plat Le plat choisi.
     */
    @Override
    public void preparer(PlatChoisi plat) {
        plat.setEtatCourant(new EtatEnPrepararation());
    }

    /**
     * Tente de terminer un plat déjà terminé, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car le plat est déjà terminé.
     */
    @Override
    public void terminer(PlatChoisi plat) {
        throw new IllegalStateException("Le plat est déjà terminé.");
    }

    /**
     * Sert le plat au client, le passant à l'état Servi.
     * @param plat Le plat choisi.
     */
    @Override
    public void servir(PlatChoisi plat) {
        plat.setEtatCourant(new EtatServi());
    }

    /**
     * Rend le plat inservable, par exemple si un problème est détecté après la préparation.
     * @param plat Le plat choisi.
     */
    @Override
    public void rendreInservable(PlatChoisi plat) {
        plat.setEtatCourant(new EtatPasServable());
    }

    /**
     * Retourne une description de l'état du plat.
     * @param plat Le plat choisi.
     * @return La chaîne "Plat terminé".
     */
    @Override
    public String afficher(PlatChoisi plat) {
        return "Plat terminé";
    }
}