/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enity;

import Conexion.Conexion;
import Model.Inrerface.Interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Alumnos implements Interface {

    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void Agregar() {

        String sql;

        sql = "INSERT INTO estudiantes ("
                + "nombre, "
                + "apellidos, "
                + "correo, "
                + "telefono"
                + ") VALUES ("
                + "'" + this.getNombre() + "', "
                + "'" + this.getApellidos() + "', "
                + "'" + this.getCorreo() + "', "
                + "'" + this.getTelefono() + "'"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

    @Override
    public void Modificar() {

        String sql = "UPDATE estudiantes SET "
                + "nombre = '" + this.getNombre() + "', "
                + "apellidos = '" + this.getApellidos() + "', "
                + "correo = '" + this.getCorreo() + "', "
                + "telefono = '" + this.getTelefono() + "' "
                + "WHERE id = " + this.getId();

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
      
         String sql;

        sql = " DELETE FROM estudiantes WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
    }

    @Override
    public Object Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Alumnos> ListarContinentes() {

        List<Alumnos> ListaC = new ArrayList();
        String sql = "SELECT * FROM estudiantes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumnos cl = new Alumnos();
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellidos(rs.getString("apellidos"));
                cl.setCorreo(rs.getString("correo"));
                cl.setTelefono(rs.getString("telefono"));

                ListaC.add(cl);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaC;
    }

}


