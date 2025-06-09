package menufact.modele.exceptions;

public class MenuException extends Exception{

    public MenuException(String message){
        super("MenuException: " + message);
    }
}

