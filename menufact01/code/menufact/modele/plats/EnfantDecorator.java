package modele.plats;

public class EnfantDecorator extends PlatDecorator {
    private double proportion;

    public EnfantDecorator(Plat plat, double proportion) {
        super(plat);
        this.proportion = proportion;
    }

    @Override
    public double getPrix() {
        return super.getPrix() * proportion;
    }

    @Override
    public String toString() {
        return super.toString() + ", proportion=" + proportion;
    }


}
