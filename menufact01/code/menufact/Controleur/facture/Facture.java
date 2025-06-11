package controleur.facture;

import modele.Chef;
import modele.Client;
import controleur.facture.exceptions.FactureException;
import modele.Observateur;
import modele.ingredients.Ingredient;
import modele.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Une facture du système Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    FactureEtat etat;
    ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    PlatChoisi platChoisi;
    Observateur observateur;
    private int courant;
    private Client client;

    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     * @param client le client de la facture
     */
    public void associerClient(Client client) {
        this.client = client;
    }

    /**
     * return le client de la facture
     */
    public Client getClient() {
        return client;
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal() {
        double soustotal = 0;
        for (PlatChoisi p : platchoisi)
            soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     * @return le total de la facture
     */
    public double total() {
        return sousTotal() + tps() + tvq();
    }

    /**
     * @return la valeur de la TPS
     */
    public double tps() {
        return TPS * sousTotal();
    }

    /**
     * @return la valeur de la TVQ
     */
    public double tvq() {
        return TVQ * (TPS + 1) * sousTotal();
    }

    /**
     * Permet de changer l'état de la facture à PAYEE
     */
    public void payer() throws Exception {
        etat.payer();
    }

    /**
     * Permet de changer l'état de la facture à FERMEE
     */
    public void fermer() throws Exception {
        etat.fermer();
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws Exception {
        etat.ouvrir();
    }

    /**
     * @return l'état de la facture
     */
    public FactureEtat getEtat() {
        return etat;
    }

    /**
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = new EtatOuverte(this);
        courant = -1;
        this.description = description;
        this.platchoisi = new ArrayList<>();
        observateur = new Chef();
    }

    /**
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws Exception {
        etat.ajouterPlat(p);
    }

    /**
     * @return le contenu de la facture en chaîne de caractères
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture() {
        StringBuilder factureGenere = new StringBuilder();
        factureGenere.append("Facture générée.\n")
                .append("Date: ").append(date).append("\n")
                .append("Description: ").append(description).append("\n")
                .append("Client: ").append(client != null ? client.getNom() : "Aucun").append("\n")
                .append("Les plats commandés:\n");
        factureGenere.append("Seq   Plat         Prix   Quantité   Ingrédients\n");
        int i = 1;
        for (PlatChoisi plat : platchoisi) {
            factureGenere.append(String.format("%d     %s  %.2f      %.1f    ", i++,
                    plat.getPlat().getDescription(), plat.getPlat().getPrix(), plat.getQuantite()));
            for (Map.Entry<Ingredient, Double> entry : plat.getIngredientQuantities().entrySet()) {
                factureGenere.append(entry.getKey().getNom() + " (" + entry.getValue() + " " + entry.getKey().getUnite().getUnite() + "), ");
            }
            factureGenere.append("\n");
        }
        factureGenere.append(String.format("          TPS:               %.2f\n", tps()))
                .append(String.format("          TVQ:               %.2f\n", tvq()))
                .append(String.format("          Le total est de:   %.2f\n", total()));
        return factureGenere.toString();
    }

    /**
     * @return une chaîne de caractères des montants de la facture
     */
    public String afficherMontants() {
        return etat.afficherMontants(this);
    }
}