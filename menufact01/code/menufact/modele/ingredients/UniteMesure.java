package modele.ingredients;

/**
 * Interface définissant le contrat pour les unités de mesure des ingrédients dans le système Menufact.
 * Cette interface permet de spécifier une unité de mesure et de vérifier sa compatibilité avec d'autres unités,
 * suivant le pattern Stratégie pour une gestion flexible des unités.
 */
public interface UniteMesure {

    /**
     * Retourne la représentation textuelle de l'unité de mesure.
     * Par exemple, "mL" pour les liquides ou "g" pour les solides.
     *
     * @return La chaîne représentant l'unité de mesure.
     */
    String getUnite();

    /**
     * Vérifie si cette unité de mesure est compatible avec une autre unité.
     * La compatibilité dépend de l'implémentation spécifique (par exemple, une unité liquide peut être incompatible avec une unité solide).
     *
     * @param autre L'autre unité de mesure à comparer.
     * @return {@code true} si les unités sont compatibles, {@code false} sinon.
     */
    boolean estCompatibleAvec(UniteMesure autre);
}