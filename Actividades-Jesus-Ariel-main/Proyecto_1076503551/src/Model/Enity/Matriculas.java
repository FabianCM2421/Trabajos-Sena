package Model.Enity;

import Conexion.Conexion;
import Model.Inrerface.Interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Matriculas implements Interface {

    private int id;
    private String estudiante_Nombre;
    private int estudiante_id;
    private String materia_Nombre;
    private int materia_id;
    private String periodo;
    private String Nota;
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    public Conexion conn = new Conexion();
    private Alumnos estudiante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstudiante_Nombre() {
        return estudiante_Nombre;
    }

    public void setEstudiante_Nombre(String estudiante_Nombre) {
        this.estudiante_Nombre = estudiante_Nombre;
    }

    public int getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(int estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public String getMateria_Nombre() {
        return materia_Nombre;
    }

    public void setMateria_Nombre(String materia_Nombre) {
        this.materia_Nombre = materia_Nombre;
    }

    public int getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(int materia_id) {
        this.materia_id = materia_id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    @Override
    public void Agregar() {

        String sqtl = "SELECT estudiantes.id "
                + "FROM estudiantes  "
                + "WHERE estudiantes.nombre = '" + this.estudiante_Nombre.toString() + "'";

        String sql = "SELECT materia.id "
                + "FROM materia  "
                + "WHERE materia.MateriaNmbre = '" + this.materia_Nombre.toString() + "'";

        ResultSet resultSetEstudiante = conn.rejecutarSQL(sqtl);
        ResultSet resultSetMateria = conn.rejecutarSQL(sql);

        System.out.println("dato modelo modificar " + this.materia_Nombre);
        try {
            while (resultSetEstudiante.next()) {
                this.setEstudiante_id(resultSetEstudiante.getInt("id"));
            }

            while (resultSetMateria.next()) {
                this.setMateria_id(resultSetMateria.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "INSERT INTO matricula ("
                + "estudiante_id , "
                + "materia_id , "
                + "Periodo , "
                + "Nota "
                + ") VALUES ("
                + "'" + this.getEstudiante_id() + "', "
                + "'" + this.getMateria_id() + "', "
                + "'" + this.getPeriodo() + "', "
                + this.getNota() + " "
                + ");";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EliminarFisico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Matriculas> ListarMatriculas() {
        List<Matriculas> listaMatriculas = new ArrayList<>();
        String sql = "SELECT m.id AS MatriculaID, e.id AS EstudianteID, ma.id AS MateriaID, "
                + "e.Nombre AS EstudianteNombre, ma.MateriaNmbre AS MateriaNombre, "
                + "m.Periodo, m.Nota "
                + "FROM matricula m "
                + "JOIN estudiantes e ON m.estudiante_id = e.id "
                + "JOIN materia ma ON m.materia_id = ma.id";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Matriculas matricula = new Matriculas();
                matricula.setId(rs.getInt("MatriculaID"));
                matricula.setEstudiante_id(rs.getInt("EstudianteID"));
                matricula.setMateria_id(rs.getInt("MateriaID"));
                matricula.setEstudiante_Nombre(rs.getString("EstudianteNombre"));
                matricula.setMateria_Nombre(rs.getString("MateriaNombre"));
                matricula.setPeriodo(rs.getString("Periodo"));
                matricula.setNota(rs.getString("Nota"));

                listaMatriculas.add(matricula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMatriculas;
    }
}
