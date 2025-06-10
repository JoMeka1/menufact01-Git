package modele;

import modele.exceptions.MenuException;
import modele.plats.PlatAuMenu;
import modele.plats.Plat;
import java.util.ArrayList;

/**
 * Représente un menu de restaurant géré comme un singleton, permettant de stocker et de naviguer une liste de plats.
 * Cette classe maintient une liste unique de plats et un index courant pour sélectionner un plat spécifique.
 */
public class Menu {
    /** Description textuelle du menu. */
    private String description;

    /** Index du plat courant dans la liste des plats. */
    private int courant;

    /** Liste des plats contenus dans le menu. */
    private ArrayList<Plat> plat = new ArrayList<>();

    /** Instance unique du menu pour le pattern Singleton. */
    private static Menu instance = null;

    /**
     * Construit un menu avec une description donnée.
     * Ce constructeur est privé pour garantir l'utilisation du pattern Singleton via {@link #getInstance(String)}.
     *
     * @param description La description textuelle du menu.
     */
    private Menu(String description) {
        this.description = description;
    }

    /**
     * Ajoute un plat à la liste des plats du menu.
     *
     * @param p Le plat à ajouter.
     */
    public void ajoute (Plat p)
    {
        plat.add(p);
    }

    /**
     * Définit l'index courant du plat sélectionné dans le menu.
     *
     * @param i L'index du plat à sélectionner.
     * @throws MenuException Si l'index est invalide (négatif ou supérieur à la taille de la liste des plats).
     */
    public void position(int i) throws MenuException {
        if (i >= 0 && i < plat.size()) {
            courant = i;
        } else {
            throw new MenuException("Position invalide : " + i);
        }
    }

    /**
     * Retourne le plat actuellement sélectionné dans le menu.
     *
     * @return Le plat à l'index courant.
     * @throws MenuException Si aucun plat courant n'est disponible (index invalide).
     */
    public Plat platCourant() throws MenuException {
        if (courant >= 0 && courant < plat.size()) {
            return plat.get(courant);
        } else {
            throw new MenuException("Aucun plat courant disponible.");
        }
    }

    /**
     * Passe au plat suivant dans la liste des plats.
     *
     * @throws MenuException Si l'index courant dépasse la taille maximale de la liste des plats.
     */
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /**
     * Passe au plat précédent dans la liste des plats.
     *
     * @throws MenuException Si l'index courant devient inférieur à zéro.
     */
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /**
     * Retourne l'instance unique du menu selon le pattern Singleton.
     * Si aucune instance n'existe, une nouvelle est créée avec la description donnée.
     *
     * @param description La description textuelle du menu.
     * @return L'instance unique du menu.
     */
    public static Menu getInstance(String description)
    {
        if (instance == null){
            instance = new Menu(description);
        }
        return instance;
    }

    /**
     * Retourne une représentation textuelle du menu, incluant sa description, l'index courant, et la liste des plats.
     *
     * @return Une chaîne décrivant le menu.
     */
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}