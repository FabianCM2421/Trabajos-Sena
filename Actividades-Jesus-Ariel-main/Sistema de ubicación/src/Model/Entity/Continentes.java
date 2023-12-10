package Model.Entity;

import Conexion.Conexion;
import Model.Interface.CrudMetodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Continentes implements CrudMetodos {

    private int id;
    private String codigo_postal;
    private String descripcion;
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

    public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }

    @Override
public void Agregar() {

    String sql;

    sql = "INSERT INTO continente ("
            + "codigo_postal, "
            + "descripcion"
            + ") VALUES ("
            + "'" + this.getCodigo_postal() + "', "
            + "'" + this.getDescripcion() + "'"
            + ");";
    conn.ejecutarSQL(sql);
}


    @Override
public void Modificar() {
    String sql = "UPDATE continente SET "
            + "codigo_postal = '" + this.getCodigo_postal() + "', "
            + "descripcion = '" + this.getDescripcion() + "' "
            + "WHERE id = " + this.getId();
    
    conn.ejecutarSQL(sql);
}

    @Override
    public void EliminarFisico() {
        String sql;

        sql = " DELETE FROM continente WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
    }

    @Override
    public void EliminarLogico() {
        String sqll;

//        sql = " UPDATE continente SET deleted_at = NOW() WHERE id = " + this.getId() + ";";
//        conn.ejecutarSQL(sql);
//        
//        
      String sql = "SELECT continente.id FROM continente WHERE continente.descripcion = '" + this.descripcion + "'";
        ResultSet resultSet1 = conn.rejecutarSQL(sql);

        try {
            while (resultSet1.next()) {
                this.setId(resultSet1.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

// Eliminar registros en la tabla "ciudad" que dependen de los estados
        String sql1 = "DELETE FROM ciudad WHERE estado_id IN (SELECT id FROM estado WHERE pais_id IN (SELECT id FROM pais WHERE contiente_id = " + getId() + "))";
        conn.ejecutarSQL(sql1);

// Eliminar registros en la tabla "estado" que dependen de los países
        String sql2 = "DELETE FROM estado WHERE pais_id IN (SELECT id FROM pais WHERE contiente_id = " + getId() + ")";
        conn.ejecutarSQL(sql2);

// Eliminar registros en la tabla "pais" que dependen del continente
        String sql3 = "DELETE FROM pais WHERE contiente_id = " + getId();
        conn.ejecutarSQL(sql3);

// Finalmente, puedes eliminar el registro del continente
        String sql4 = "DELETE FROM continente WHERE id = " + getId();
        conn.ejecutarSQL(sql4);

        conn.cerrarConexion();

    

        
    }

    @Override
    public Object Consultar() {
     
        Continentes continente = null;
    String sql = "SELECT * FROM continente WHERE id = ?";

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, this.getId());
        rs = ps.executeQuery();

        if (rs.next()) {
            continente = new Continentes();
            continente.setId(rs.getInt("id"));
            continente.setCodigo_postal(rs.getString("codigo_postal"));
            continente.setDescripcion(rs.getString("descripcion"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return continente;

    }

    @Override
    public String ConsultarWhereAnd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
     public List<Continentes> ListarContinentes() {

        List<Continentes> ListaC = new ArrayList();
        String sql = "SELECT * FROM  continente";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Continentes cl = new Continentes();
                cl.setId(rs.getInt("id"));
                cl.setCodigo_postal(rs.getString("codigo_postal"));
                cl.setDescripcion(rs.getString("descripcion"));
                

                ListaC.add(cl);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaC;
    }

}
