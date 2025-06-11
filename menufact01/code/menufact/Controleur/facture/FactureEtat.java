package controleur.facture;

import modele.plats.PlatChoisi;

/**
 * Représente l'état abstrait d'une facture dans le système Menufact, suivant le pattern État.
 * Cette classe définit les comportements possibles d'une facture (ajouter ou retirer des plats, payer, fermer, ouvrir, sélectionner un plat, et afficher les montants) selon son état actuel.
 */
public abstract class FactureEtat {
    /** Référence à la facture associée à cet état. */
    protected Facture facture;

    /**
     * Construit un état de facture avec une référence à la facture associée.
     *
     * @param facture La facture à associer à cet état.
     */
    public FactureEtat(Facture facture) {
        this.facture = facture;
    }

    /**
     * Ajoute un plat à la facture.
     * Le comportement dépend de l'état spécifique de la facture (par exemple, ouvert, payé, fermé).
     *
     * @param plat Le plat choisi à ajouter.
     * @throws Exception Si l'opération n'est pas autorisée dans l'état actuel.
     */
    public abstract void ajouterPlat(PlatChoisi plat) throws Exception;

    /**
     * Retire un plat de la facture.
     * Le comportement dépend de l'état spécifique de la facture.
     *
     * @param plat Le plat choisi à retirer.
     * @throws Exception Si l'opération n'est pas autorisée dans l'état actuel ou si le plat n'est pas trouvé.
     */
    public abstract void retirerPlat(PlatChoisi plat) throws Exception;

    /**
     * Passe la facture à l'état fermé.
     * Le comportement dépend de l'état spécifique de la facture.
     *
     * @throws Exception Si l'opération n'est pas autorisée dans l'état actuel.
     */
    public abstract void fermer() throws Exception;

    /**
     * Passe la facture à l'état ouvert.
     * Le comportement dépend de l'état spécifique de la facture.
     *
     * @throws Exception Si l'opération n'est pas autorisée dans l'état actuel.
     */
    public abstract void ouvrir() throws Exception;

    /**
     * Effectue le paiement de la facture, passant à l'état payé.
     * Le comportement dépend de l'état spécifique de la facture.
     *
     * @throws Exception Si l'opération n'est pas autorisée dans l'état actuel.
     */
    public abstract void payer() throws Exception;

    /**
     * Sélectionne un plat dans la facture pour une opération spécifique.
     * Le comportement dépend de l'état spécifique de la facture.
     *
     * @param plat Le plat choisi à sélectionner.
     * @throws Exception Si l'opération n'est pas autorisée dans l'état actuel.
     */
    public abstract void selectionnerPlat(PlatChoisi plat) throws Exception;

    /**
     * Affiche les montants associés à la facture (sous-total, taxes, total).
     * Le format et le contenu dépendent de l'état spécifique de la facture.
     *
     * @param facture La facture dont les montants doivent être affichés.
     * @return Une chaîne représentant les montants de la facture.
     */
    public abstract String afficherMontants(Facture facture);

    /**
     * Affiche les informations de la facture en déléguant à {@link #afficherMontants(Facture)}.
     * Cette méthode fournit une interface commune pour l'affichage des montants.
     *
     * @param facture La facture à afficher.
     * @return Une chaîne représentant les informations affichées.
     */
    public String afficher(Facture facture) {
        return afficherMontants(facture);
    }
}