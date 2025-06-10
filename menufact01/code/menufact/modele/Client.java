package modele;

/**
 * Représente un client du restaurant dans le système Menufact.
 * Contient les informations d'identification et de paiement du client, telles que son identifiant, son nom et son numéro de carte de crédit.
 */
public class Client {
    /** Identifiant unique du client. */
    private int idClient;

    /** Nom du client. */
    private String nom;

    /** Numéro de carte de crédit du client. */
    private String numeroCarteCredit;

    /**
     * Construit un client avec un identifiant, un nom et un numéro de carte de crédit.
     *
     * @param idClient L'identifiant unique du client.
     * @param nom Le nom du client.
     * @param numeroCarteCredit Le numéro de carte de crédit du client.
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Retourne l'identifiant unique du client.
     *
     * @return L'identifiant du client.
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Définit un nouvel identifiant pour le client.
     *
     * @param idClient Le nouvel identifiant du client.
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Retourne le nom du client.
     *
     * @return Le nom du client.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit un nouveau nom pour le client.
     *
     * @param nom Le nouveau nom du client.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le numéro de carte de crédit du client.
     *
     * @return Le numéro de carte de crédit du client.
     */
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    /**
     * Définit un nouveau numéro de carte de crédit pour le client.
     *
     * @param numeroCarteCredit Le nouveau numéro de carte de crédit du client.
     */
    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Retourne une représentation textuelle du client, incluant son identifiant, son nom et son numéro de carte de crédit.
     *
     * @return Une chaîne décrivant le client.
     */
    @Override
    public String toString() {
        return "menufact.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class menufact.Client{}
* */