
package Conexion;


public class Config {
    
    private String dbURL;
    private String username;
    private String password;

    public Config() {
        this.dbURL = "jdbc:mysql://localhost:3306/proyecto_eva";
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
    

