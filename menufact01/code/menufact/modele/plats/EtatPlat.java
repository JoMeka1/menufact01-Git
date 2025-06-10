package modele.plats;

/**
 * Interface définissant les états possibles d'un plat choisi dans le système Menufact, suivant le pattern État.
 * Cette interface permet de gérer les transitions du cycle de vie d'un plat (préparation, terminaison, service, inservabilité)
 * et de fournir une description de l'état actuel.
 */
public interface EtatPlat {

    /**
     * Prépare le plat choisi, effectuant une transition vers l'état de préparation.
     * Le comportement spécifique dépend de l'implémentation de l'état actuel.
     *
     * @param plat Le plat choisi à préparer.
     */
    public void preparer(PlatChoisi plat);

    /**
     * Marque le plat choisi comme terminé, effectuant une transition vers l'état terminé.
     * Le comportement spécifique dépend de l'implémentation de l'état actuel.
     *
     * @param plat Le plat choisi à terminer.
     */
    public void terminer(PlatChoisi plat);

    /**
     * Sert le plat choisi, effectuant une transition vers l'état servi.
     * Le comportement spécifique dépend de l'implémentation de l'état actuel.
     *
     * @param plat Le plat choisi à servir.
     */
    public void servir(PlatChoisi plat);

    /**
     * Rend le plat choisi inservable, effectuant une transition vers l'état inservable.
     * Le comportement spécifique dépend de l'implémentation de l'état actuel.
     *
     * @param plat Le plat choisi à rendre inservable.
     */
    public void rendreInservable(PlatChoisi plat);

    /**
     * Retourne une description textuelle de l'état actuel du plat choisi.
     * Le format et le contenu dépendent de l'implémentation de l'état.
     *
     * @param plat Le plat choisi dont l'état doit être affiché.
     * @return Une chaîne décrivant l'état actuel du plat.
     */
    public String afficher(PlatChoisi plat);
}