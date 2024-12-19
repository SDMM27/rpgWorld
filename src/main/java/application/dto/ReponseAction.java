package application.dto;

public class ReponseAction {
    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private boolean succes;
    private String message;

    public ReponseAction(boolean succes, String message) {
        this.succes = succes;
        this.message = message;
    }

    // Getters, Setters et autres méthodes
}
