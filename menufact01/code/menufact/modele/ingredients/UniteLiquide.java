package modele.ingredients;

public class UniteLiquide implements UniteMesure {
    @Override
    public String getUnite() { return "mL"; }

    @Override
    public boolean estCompatibleAvec(UniteMesure autre) {
        return autre instanceof UniteLiquide;
    }
}

