package it.evolvere.progetto.exceptions;

public class ProjectException extends Exception {

    protected String message;

    public ProjectException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
