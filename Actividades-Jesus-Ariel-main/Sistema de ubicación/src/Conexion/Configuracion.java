
package Conexion;

public class Configuracion {
    private String dbURL;
    private String username;
    private String password;

    public Configuracion() {
        this.dbURL = "jdbc:mysql://localhost:3306/ejm_location";
        this.username = "root";
        this.password = "";
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }   
    
}
