package modele.plats;

/**
 * Représente l'état d'un plat qui ne peut pas être servi, par exemple en raison d'un problème de qualité.
 * Aucun changement d'état n'est possible à partir de cet état.
 */
public class EtatPasServable implements EtatPlat {

    /**
     * Tente de préparer un plat inservable, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat inservable ne peut pas être préparé.
     */
    @Override
    public void preparer(PlatChoisi plat) {
        throw new IllegalStateException("Impossible de préparer un plat inservable.");
    }

    /**
     * Tente de terminer un plat inservable, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat inservable ne peut pas être terminé.
     */
    @Override
    public void terminer(PlatChoisi plat) {
        throw new IllegalStateException("Impossible de terminer un plat inservable.");
    }

    /**
     * Tente de servir un plat inservable, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat inservable ne peut pas être servi.
     */
    @Override
    public void servir(PlatChoisi plat) {
        throw new IllegalStateException("Impossible de servir un plat inservable.");
    }

    /**
     * Tente de rendre inservable un plat déjà inservable, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car le plat est déjà inservable.
     */
    @Override
    public void rendreInservable(PlatChoisi plat) {
        throw new IllegalStateException("Le plat est déjà inservable.");
    }

    /**
     * Retourne une description de l'état du plat.
     * @param plat Le plat choisi.
     * @return La chaîne "Impossible de servir ce plat".
     */
    @Override
    public String afficher(PlatChoisi plat) {
        return "Impossible de servir ce plat";
    }
}