package modele.plats;

import modele.ingredients.Ingredient;
import modele.plats.Plat;

import java.util.Map;

/**
 * Représente un plat choisi par un client dans le système Menufact.
 * Cette classe encapsule un plat, sa quantité commandée, et son état actuel dans le cycle de vie (par exemple, commandé, en préparation, servi).
 */
public class PlatChoisi {
    /** Le plat sélectionné, qui peut être une instance de PlatAuMenu ou un décorateur. */
    private Plat plat;

    /** L'état actuel du plat, défini par l'interface EtatPlat. */
    private EtatPlat etatCourant;

    /** La quantité commandée du plat. */
    private double quantite;

    /**
     * Construit un plat choisi avec un plat et une quantité spécifiés.
     * L'état initial est défini à EtatCommande.
     *
     * @param plat Le plat sélectionné, qui doit être une instance de PlatAuMenu ou un décorateur.
     * @param quantite La quantité commandée du plat.
     * @throws IllegalArgumentException Si le plat n'est ni un PlatAuMenu ni un décorateur.
     */
    public PlatChoisi(Plat plat, double quantite) {
        if (plat instanceof PlatAuMenu || plat instanceof PlatDecorator) {
            this.plat = plat;
        } else {
            throw new IllegalArgumentException("Plat doit être un PlatAuMenu ou un décorateur");
        }
        this.quantite = quantite;
        this.etatCourant = new EtatCommande();
    }

    /**
     * Retourne une représentation textuelle du plat choisi, incluant la quantité, le plat, et les quantités d'ingrédients requises.
     *
     * @return Une chaîne décrivant le plat choisi.
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                ", ingredientQuantities=" + getIngredientQuantities() +
                '}';
    }

    /**
     * Retourne la quantité commandée du plat.
     *
     * @return La quantité du plat.
     */
    public double getQuantite() {
        return quantite;
    }

    /**
     * Définit une nouvelle quantité pour le plat choisi.
     *
     * @param quantite La nouvelle quantité commandée.
     */
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    /**
     * Retourne le plat sélectionné.
     *
     * @return Le plat associé.
     */
    public Plat getPlat() {
        return plat;
    }

    /**
     * Définit un nouvel état pour le plat choisi.
     *
     * @param etat Le nouvel état du plat, défini par EtatPlat.
     */
    public void setEtatCourant(EtatPlat etat) {
        this.etatCourant = etat;
    }

    /**
     * Retourne les quantités d'ingrédients requises pour le plat, en déléguant au plat sous-jacent.
     *
     * @return Une map associant chaque ingrédient à sa quantité requise.
     */
    public Map<Ingredient, Double> getIngredientQuantities() {
        return plat.getIngredientQuantities();
    }

    /**
     * Retourne l'état actuel du plat choisi.
     *
     * @return L'état courant, défini par EtatPlat.
     */
    public EtatPlat getEtatCourant() {
        return etatCourant;
    }
}