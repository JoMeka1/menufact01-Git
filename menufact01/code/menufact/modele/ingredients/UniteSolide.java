package modele.ingredients;

public class UniteSolide implements UniteMesure {
    @Override
    public String getUnite() { return "g"; }

    @Override
    public boolean estCompatibleAvec(UniteMesure autre) {
        return autre instanceof UniteSolide;
    }
}

