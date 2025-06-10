package modele.plats;

public interface PlatFactory {
    public Plat creerPlat(TypePlat type, int code, String description, double prix,
                          double kcal, double chol, double gras, double proportion)
            throws IllegalArgumentException;
}