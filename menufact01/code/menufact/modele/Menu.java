package modele;

import menufact.modele.exceptions.MenuException;
import menufact.modele.plats.PlatAuMenu;
import menufact.modele.plats.Plat;
import java.util.ArrayList;

public class Menu {
    private String description;
    private int courant;
    private ArrayList<Plat> plat = new ArrayList<>();
    private static Menu instance = null;

    private Menu(String description) {
        this.description = description;
    }

    public void ajoute (Plat p)
    {
        plat.add(p);
    }

    public void position(int i)
    {
        courant = i;
    }

    public Plat platCourant()
    {
        return plat.get(courant);
    }

    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    public static Menu getInstance(String description)
    {
        if (instance == null){
            instance = new Menu(description);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
