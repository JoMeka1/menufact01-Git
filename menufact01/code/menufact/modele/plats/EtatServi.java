package modele.plats;

/**
 * Représente l'état d'un plat qui a été servi au client.
 * Aucun changement d'état n'est possible à partir de cet état.
 */
public class EtatServi implements EtatPlat {

    /**
     * Tente de préparer un plat déjà servi, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat servi ne peut pas être préparé.
     */
    @Override
    public void preparer(PlatChoisi plat) {
        throw new IllegalStateException("Impossible de préparer un plat déjà servi.");
    }

    /**
     * Tente de terminer un plat déjà servi, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat servi ne peut pas être terminé.
     */
    @Override
    public void terminer(PlatChoisi plat) {
        throw new IllegalStateException("Impossible de terminer un plat déjà servi.");
    }

    /**
     * Tente de servir un plat déjà servi, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat servi ne peut pas être resservi.
     */
    @Override
    public void servir(PlatChoisi plat) {
        throw new IllegalStateException("Le plat est déjà servi.");
    }

    /**
     * Tente de rendre inservable un plat déjà servi, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat servi ne peut pas devenir inservable.
     */
    @Override
    public void rendreInservable(PlatChoisi plat) {
        throw new IllegalStateException("Impossible de rendre inservable un plat déjà servi.");
    }

    /**
     * Retourne une description de l'état du plat.
     * @param plat Le plat choisi.
     * @return La chaîne "Plat servi".
     */
    @Override
    public String afficher(PlatChoisi plat) {
        return "Plat servi";
    }
}