/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Conexion.Conexion;
import Model.Interface.CrudMetodos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ciudad implements CrudMetodos {

    private int id;
    private String codigo_postal;
    private String descripcion;
    private int esatdoid;
    private String estado_id;
    private String descipcionPais;

    public String getDescipcionPais() {
        return descipcionPais;
    }

    public void setDescipcionPais(String descipcionPais) {
        this.descipcionPais = descipcionPais;
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

    public int getEsatdoid() {
        return esatdoid;
    }

    public void setEsatdoid(int esatdoid) {
        this.esatdoid = esatdoid;
    }

    public String getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(String estado_id) {
        this.estado_id = estado_id;
    }

    @Override
    public void Agregar() {

        String sqtl = "SELECT estado.id "
                + "FROM estado  "
                + "WHERE estado.descripcion = '" + this.estado_id.toString() + "'";

        ResultSet resultSet = conn.rejecutarSQL(sqtl);
        System.out.println("dato modelo  modificar " + this.estado_id);
        try {
            while (resultSet.next()) {
                this.setEsatdoid(resultSet.getInt("id"));
                // this.setId(resultSet.getInt("id"));
                //  System.out.println("resultado  "+setContiente_id("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql;

        sql = "INSERT INTO ciudad ("
                + "codigo_postal, "
                + "descripcion, " // Agrega una coma aquí
                + "estado_id " // Agrega el campo pais_id
                + ") VALUES ("
                + "'" + this.getCodigo_postal() + "', "
                + "'" + this.getDescripcion() + "', "
                + this.getEsatdoid() + " "
                + ");";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

     @Override
    public void Modificar() {
       String paisId = this.estado_id.toString();
        paisId = paisId.replaceAll("'", "''"); // Escapar comillas simples

        String sqtl = "SELECT estado.id "
                + "FROM estado  "
                + "WHERE estado.descripcion = '" + paisId + "'";

        ResultSet resultSet = conn.rejecutarSQL(sqtl);
        
        System.out.println(" modelo "+paisId);
        try {
            while (resultSet.next()) {
                this.setEsatdoid(resultSet.getInt("id"));
                
//                System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz" + this.getEstado_id());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz" +getPais_id());
        
        String sql = "UPDATE ciudad SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "estado_id  = " + this.getEsatdoid()+ " "
                + "WHERE id = " + this.getId();
//        System.out.println("Model.Entity.Pais.Agregar()" + getEstado_id());

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }




    @Override
    public void EliminarFisico() {
        String sql;

        sql = " DELETE FROM estado WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
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

    public List<Ciudad> ListarPaises() {

        List<Ciudad> ListaC = new ArrayList();
        String sql = "SELECT p.id, p.codigo_postal, p.descripcion,  c.descripcion AS estado_descripcion "
                + "FROM ciudad  p "
                + "JOIN estado c ON p.estado_id = c.id";
        

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ciudad cl = new Ciudad();
                cl.setId(rs.getInt("id"));
                cl.setCodigo_postal(rs.getString("codigo_postal"));
                cl.setDescripcion(rs.getString("descripcion"));
                cl.setDescipcionPais(rs.getString("estado_descripcion"));
                //cl.setContinenteDescripcion(rs.getString("continente_descripcion"));

                System.out.println("resultado modelo" + cl.getDescipcionPais());

                ListaC.add(cl);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaC;

    }
}