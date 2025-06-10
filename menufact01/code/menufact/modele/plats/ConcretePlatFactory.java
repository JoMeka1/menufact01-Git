package modele.plats;

public class ConcretePlatFactory implements PlatFactory {
    @Override
    public Plat creerPlat(TypePlat type, int code, String description, double prix,
                          double kcal, double chol, double gras, double proportion)
            throws IllegalArgumentException {
        Plat basePlat = new PlatAuMenu(code, description, prix);
        switch (type) {
            case NORMAL:
                if (kcal != 0.0 || chol != 0.0 || gras != 0.0 || proportion != 0.0) {
                    throw new IllegalArgumentException("Plat normal ne nécessite pas d'extras");
                }
                return basePlat;
            case SANTE:
                if (kcal <= 0.0 || chol < 0.0 || gras < 0.0) {
                    throw new IllegalArgumentException("Valeurs invalides pour kcal, chol, ou gras");
                }
                if (proportion != 0.0) {
                    throw new IllegalArgumentException("Proportion non applicable pour un plat santé");
                }
                return new SanteDecorateur(basePlat, kcal, chol, gras);
            case ENFANT:
                if (proportion <= 0.0 || proportion > 1.0) {
                    throw new IllegalArgumentException("Proportion doit être entre 0 et 1");
                }
                if (kcal != 0.0 || chol != 0.0 || gras != 0.0) {
                    throw new IllegalArgumentException("Métriques santé non applicables pour un plat enfant");
                }
                return new EnfantDecorator(basePlat, proportion);
            default:
                throw new IllegalArgumentException("Type inconnu : " + type);
        }
    }
}