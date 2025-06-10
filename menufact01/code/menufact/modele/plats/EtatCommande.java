package modele.plats;

/**
 * Représente l'état initial d'un plat qui vient d'être commandé par le client.
 * Le plat peut être préparé ou rendu inservable, mais ne peut pas être terminé ou servi directement.
 */
public class EtatCommande implements EtatPlat {

    /**
     * Passe le plat à l'état EnPreparation pour commencer sa préparation.
     * @param plat Le plat choisi.
     */
    @Override
    public void preparer(PlatChoisi plat) {
        plat.setEtatCourant(new EtatEnPreparation());
    }

    /**
     * Tente de terminer un plat non préparé, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat commandé doit être préparé avant d'être terminé.
     */
    @Override
    public void terminer(PlatChoisi plat) {
        throw new IllegalStateException("Le plat doit être préparé avant d'être terminé.");
    }

    /**
     * Tente de servir un plat non préparé, ce qui est interdit.
     * @param plat Le plat choisi.
     * @throws IllegalStateException Toujours levée, car un plat commandé doit être préparé avant d'être servi.
     */
    @Override
    public void servir(PlatChoisi plat) {
        throw new IllegalStateException("Le plat doit être préparé avant d'être servi.");
    }

    /**
     * Rend le plat inservable, par exemple si les ingrédients manquent.
     * @param plat Le plat choisi.
     */
    @Override
    public void rendreInservable(PlatChoisi plat) {
        plat.setEtatCourant(new EtatPasServable());
    }

    /**
     * Retourne une description de l'état du plat.
     * @param plat Le plat choisi.
     * @return La chaîne "Plat commandé".
     */
    @Override
    public String afficher(PlatChoisi plat) {
        return "Plat commandé";
    }
}

