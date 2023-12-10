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
import javax.swing.JOptionPane;

/**
 *
 * @author supap
 */
public class Pais implements CrudMetodos {

    private int id;
    private String codigo_postal;
    private String descripcion;
    private int contiente_id;
    private String idContinente;
   

    public String getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(String idContinente) {
        this.idContinente = idContinente;
    }
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    public Conexion conn = new Conexion();

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

    public int getContiente_id() {
        return contiente_id;
    }

    public void setContiente_id(int contiente_id) {
        this.contiente_id = contiente_id;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO pais ("
                + "codigo_postal, "
                + "descripcion, "
                + "contiente_id"
                + ") VALUES ("
                + "'" + this.getCodigo_postal() + "', "
                + "'" + this.getDescripcion() + "', "
                + this.getContiente_id()
                + ");";
        conn.ejecutarSQL(sql);
    }

    @Override
    public void Modificar() {
    
        
        String sqtl = "SELECT continente.id " +
        "FROM continente  " +
        "WHERE continente.descripcion = '" + this.idContinente.toString() + "'";

        ResultSet resultSet = conn.rejecutarSQL(sqtl);
        System.out.println("dato modelo  modificar "+this.idContinente);
        try {
            while (resultSet.next()) {
                this.setContiente_id(resultSet.getInt("id"));
                // this.setId(resultSet.getInt("id"));
             //  System.out.println("resultado  "+setContiente_id("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      

String sql = "UPDATE pais SET "
        + "codigo_postal = '" + this.getCodigo_postal() + "', "
        + "descripcion = '" + this.getDescripcion() + "', "
        
        + "contiente_id = " + this.getContiente_id()+ " "
        
        + "WHERE id = " + this.getId();
System.out.println("Model.Entity.Pais.Agregar()"+getContiente_id());
    
conn.ejecutarSQL(sql);


    }

    @Override
    public void EliminarFisico() {

//        String sql;
//
//        sql = " DELETE FROM pais WHERE id = " + this.getId() + ";";
//        conn.ejecutarSQL(sql);
  String sqll = "SELECT pais.id FROM pais WHERE pais.descripcion = '" + this.descripcion + "'";
        ResultSet resultSet1 = conn.rejecutarSQL(sqll);

        try {
            while (resultSet1.next()) {
                this.setId(resultSet1.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Eliminar registros en la tabla ciudad que hacen referencia al estado del país
        String sql1 = "DELETE FROM ciudad WHERE estado_id IN (SELECT id FROM estado WHERE pais_id = " + this.getId() + ")";
        conn.ejecutarSQL(sql1);

        // Eliminar registros en la tabla estado que hacen referencia al país
        String sql2 = "DELETE FROM estado WHERE pais_id = " + this.getId();
        conn.ejecutarSQL(sql2);

        // Finalmente, eliminar el registro del país
        String sql3 = "DELETE FROM pais WHERE id = " + this.getId();
        conn.ejecutarSQL(sql3);

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

    public List<Pais> ListarPaises() {

        List<Pais> ListaC = new ArrayList();
        String sql = "SELECT p.id, p.codigo_postal, p.descripcion,  c.descripcion AS continente_descripcion "
                + "FROM pais p "
                + "JOIN continente c ON p.contiente_id = c.id";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pais cl = new Pais();
                cl.setId(rs.getInt("id"));
                cl.setCodigo_postal(rs.getString("codigo_postal"));
                cl.setDescripcion(rs.getString("descripcion"));
                cl.setIdContinente(rs.getString("continente_descripcion"));
                //cl.setContinenteDescripcion(rs.getString("continente_descripcion"));

                System.out.println("resultado modelo" + cl.getIdContinente());

                ListaC.add(cl);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaC;
    }

}
