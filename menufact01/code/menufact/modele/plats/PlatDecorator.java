package modele.plats;

public abstract class PlatDecorator implements Plat {
    protected Plat plat;

    public PlatDecorator(Plat plat) {
        if (plat == null) {
            throw new IllegalArgumentException("Plat ne peut pas être null");
        }
        this.plat = plat;
    }

    @Override
    public String getDescription() {
        return plat.getDescription();
    }

    @Override
    public double getPrix() {
        return plat.getPrix();
    }

    @Override
    public int getCode() {
        return plat.getCode();
    }

    @Override
    public String toString() {
        return plat.toString();
    }
}
