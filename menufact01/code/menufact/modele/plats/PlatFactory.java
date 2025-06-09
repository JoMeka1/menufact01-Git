package menufact.modele.plats;

public interface PlatFactory {
    public PlatAuMenu creerPlat(TypePlat type,int code,String description,double prix);
}
