/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interface.CrudMetodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estado implements CrudMetodos {

    private int id;

    private String codigo_postal;
    private String descripcion;
    private String descipcionPais;
    private String pais_id;

    private String paiNombre;
    private int idPais;
    PreparedStatement ps;
    ResultSet rs;

    public String getDescipcionPais() {
        return descipcionPais;
    }

    public void setDescipcionPais(String descipcionPais) {
        this.descipcionPais = descipcionPais;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    Connection con;
    Conexion cn = new Conexion();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaiNombre() {
        return paiNombre;
    }

    public String getPais_id() {
        return pais_id;
    }

    public void setPais_id(String pais_id) {
        this.pais_id = pais_id;
    }

    public void setPaiNombre(String paiNombre) {
        this.paiNombre = paiNombre;
    }
    public Conexion conn = new Conexion();

    public void setConn(Conexion conn) {
        this.conn = conn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }

    @Override
    public void Agregar() {

        String sqtl = "SELECT pais.id "
                + "FROM pais  "
                + "WHERE pais.descripcion = '" + this.pais_id.toString() + "'";

        ResultSet resultSet = conn.rejecutarSQL(sqtl);
        System.out.println("dato modelo  modificar " + this.pais_id);
        try {
            while (resultSet.next()) {
                this.setIdPais(resultSet.getInt("id"));
                // this.setId(resultSet.getInt("id"));
                //  System.out.println("resultado  "+setContiente_id("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql;

        sql = "INSERT INTO estado ("
                + "codigo_postal, "
                + "descripcion, " // Agrega una coma aquí
                + "pais_id " // Agrega el campo pais_id
                + ") VALUES ("
                + "'" + this.getCodigo_postal() + "', "
                + "'" + this.getDescripcion() + "', " // Agrega una coma aquí
                + this.getIdPais() + " " // Agrega el valor para pais_id
                + ");";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

  
    @Override
    public void EliminarFisico() {
        String sql;

//        sql = " DELETE FROM estado WHERE id = " + this.getId() + ";";
//        conn.ejecutarSQL(sql);


 // Obtener el ID del estado
        String sqll = "SELECT estado.id FROM estado WHERE estado.descripcion = '" + this.descripcion + "'";
        ResultSet resultSet1 = conn.rejecutarSQL(sqll);

        try {
            while (resultSet1.next()) {
                this.setId(resultSet1.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Eliminar registros en la tabla ciudad que hacen referencia al estado
        String sql1 = "DELETE FROM ciudad WHERE estado_id = " + this.getId();
        conn.ejecutarSQL(sql1);

        // Finalmente, eliminar el registro del estado
        String sql2 = "DELETE FROM estado WHERE id = " + this.getId();
        conn.ejecutarSQL(sql2);

        // Cerrar la conexión
        conn.cerrarConexion();
    
        
    }

    @Override
    public void EliminarLogico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String ConsultarWhereAnd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Estado> ListarPaises() {

        List<Estado> ListaC = new ArrayList();
        String sql = "SELECT p.id, p.codigo_postal, p.descripcion,  c.descripcion AS pais_descripcion "
                + "FROM estado p "
                + "JOIN pais c ON p.pais_id = c.id";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estado cl = new Estado();
                cl.setId(rs.getInt("id"));
                cl.setCodigo_postal(rs.getString("codigo_postal"));
                cl.setDescripcion(rs.getString("descripcion"));
                cl.setDescipcionPais(rs.getString("pais_descripcion"));
                //cl.setContinenteDescripcion(rs.getString("continente_descripcion"));

                System.out.println("resultado modelo" + cl.getDescipcionPais());

                ListaC.add(cl);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaC;
        
      

    }

   

    @Override
    public void Modificar() {
       String paisId = this.pais_id.toString();
        paisId = paisId.replaceAll("'", "''"); // Escapar comillas simples

        String sqtl = "SELECT pais.id "
                + "FROM pais  "
                + "WHERE pais.descripcion = '" + paisId + "'";

        ResultSet resultSet = conn.rejecutarSQL(sqtl);
        
        System.out.println(" modelo "+paisId);
        try {
            while (resultSet.next()) {
                this.setIdPais(resultSet.getInt("id"));
                
                System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz" + this.getPais_id());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz" +getPais_id());
        
        String sql = "UPDATE estado SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "pais_id = " + this.getIdPais()+ " "
                + "WHERE id = " + this.getId();
        System.out.println("Model.Entity.Pais.Agregar()" + getIdPais());

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

}
