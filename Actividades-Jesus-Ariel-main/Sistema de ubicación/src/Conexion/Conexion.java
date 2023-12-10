package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion {
    private Connection connection;

    public Conexion() {
        Configuracion dataConfiguration = new Configuracion();
        try {
            connection = DriverManager.getConnection(dataConfiguration.getDbURL(), dataConfiguration.getUsername(), dataConfiguration.getPassword());
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos MySQL");
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada exitosamente");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public boolean ejecutarSQL(String sql) {
        try {
            Statement statement = connection.createStatement();
            return statement.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            return false;
        }
    }

    public ResultSet consultarSQL(String sql) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Error al consultar la base de datos: " + e.getMessage());
            return null;
        }
    }

    public ResultSet rejecutarSQL(String sql) {
            try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Error al consultar la base de datos: " + e.getMessage());
            return null;
        }

    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
