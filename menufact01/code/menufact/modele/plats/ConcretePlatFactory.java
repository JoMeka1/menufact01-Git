package menufact.modele.plats;

public class ConcretePlatFactory implements PlatFactory {
    @Override
    public PlatAuMenu creerPlat(TypePlat type, int code, String description, double prix) {
        switch (type) {
            case NORMAL :
                return new PlatAuMenu(code, description, prix);

            case ENFANT:
                return new PlatAuMenu(code, description, prix);

            case SANTE:
                return new PlatAuMenu(code, description, prix);

            default:
                throw new IllegalArgumentException("Type inconnu : " + type);
        }

    }
}
