package br.com.fiap.exceptions;

public class InsertException extends Exception {

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

}