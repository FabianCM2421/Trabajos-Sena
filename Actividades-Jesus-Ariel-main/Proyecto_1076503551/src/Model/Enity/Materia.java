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

public class Materia implements Interface {

    private int id;
    private String codigo;
    private String MateriaNombre;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMateriaNombre() {
        return MateriaNombre;
    }

    public void setMateriaNombre(String MateriaNombre) {
        this.MateriaNombre = MateriaNombre;
    }

    @Override
    public void Agregar() {

        String sql;

        sql = "INSERT INTO  materia ("
                + "Codigo, "
                + "MateriaNmbre"
                + ") VALUES ("
                + "'" + this.getCodigo() + "', "
                + "'" + this.getMateriaNombre() + "'"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

    @Override
    public void Modificar() {

        String sql = "UPDATE materia SET "
                + "Codigo = '" + this.getCodigo()+ "', "
                + "MateriaNmbre = '" + this.getMateriaNombre()+ "' "
                + "WHERE id = " + this.getId();

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }



@Override
public void EliminarFisico() {
       
     String sql;

        sql = " DELETE FROM materia WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
    
    }

    @Override
public Object Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Materia> ListarContinentes() {

        List<Materia> ListaC = new ArrayList();
        String sql = "SELECT * FROM  materia";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Materia cl = new Materia();
                cl.setId(rs.getInt("id"));
                cl.setCodigo(rs.getString("Codigo"));
                cl.setMateriaNombre(rs.getString("MateriaNmbre"));

                ListaC.add(cl);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaC;
    }

}
