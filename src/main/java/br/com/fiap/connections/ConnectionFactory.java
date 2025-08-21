package br.com.fiap.connections;

import br.com.fiap.exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws ConnectionException {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/codando_ideias",
                    "postgres",
                    "1234"
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e);
        }

    }

}
