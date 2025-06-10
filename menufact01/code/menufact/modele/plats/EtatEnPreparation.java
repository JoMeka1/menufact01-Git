package modele.plats;

/**
 * Représente l'état d'un plat en cours de préparation par le chef.
 * Le plat peut être terminé, servi directement, ou rendu inservable.
 */
public class EtatEnPreparation implements EtatPlat {

    /**
     * Tente de préparer un plat déjà en préparation, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car le plat est déjà en préparation.
     */
    @Override
    public void preparer(PlatChoisi plat) {
        throw new IllegalStateException("Le plat est déjà en préparation.");
    }

    /**
     * Termine la préparation du plat, le passant à l'état Terminé.
     * @param plat Le plat choisi.
     */
    @Override
    public void terminer(PlatChoisi plat) {
        plat.setEtatCourant(new EtatTermine());
    }

    /**
     * Sert le plat directement, le passant à l'état Servi.
     * @param plat Le plat choisi.
     */
    @Override
    public void servir(PlatChoisi plat) {
        plat.setEtatCourant(new EtatServi());
    }

    /**
     * Rend le plat inservable, par exemple en cas de problème pendant la préparation.
     * @param plat Le plat choisi.
     */
    @Override
    public void rendreInservable(PlatChoisi plat) {
        plat.setEtatCourant(new EtatPasServable());
    }

    /**
     * Retourne une description de l'état du plat.
     * @param plat Le plat choisi.
     * @return La chaîne "Plat en préparation".
     */
    @Override
    public String afficher(PlatChoisi plat) {
        return "Plat en préparation";
    }
}