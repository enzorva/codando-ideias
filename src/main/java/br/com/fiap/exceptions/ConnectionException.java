package br.com.fiap.exceptions;

import java.sql.SQLException;

public class ConnectionException extends Exception {

    public ConnectionException() {
        super();
    }

    public ConnectionException(Exception e) {
        super(e);

        if (e instanceof ClassNotFoundException) {
            System.err.println("Driver error: no communication with the database");
        } else if (e instanceof SQLException) {
            System.err.println("SQL error: incorrect access information or connection failed");
        } else {
            System.err.println("Unknown error while attempting to connect");
        }

        e.printStackTrace();
    }

}