package modele.plats;

public class SanteDecorateur extends PlatDecorator {
    private double kcal;
    private double chol;
    private double gras;

    public SanteDecorateur(Plat plat, double kcal, double chol, double gras) {
        super(plat);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    @Override
    public String toString() {
        return super.toString() + ", kcal=" + kcal + ", chol=" + chol + ", gras=" + gras;
    }
}
