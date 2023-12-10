package Controller;

import Model.Enity.Alumnos;

public class CrontrolAlumnos {

    public void GuardarRegistro(String nombre, String apellidos, String correo, String telefono) {
        Alumnos cont = new Alumnos();
        cont.setNombre(nombre);
        cont.setApellidos(apellidos);
        cont.setCorreo(correo);
        cont.setTelefono(telefono);
        cont.Agregar();
    }

    public void Modificar(int id, String nombre, String apellidos, String correo, String telefono) {
        Alumnos cont = new Alumnos();

        cont.setId(id);
        cont.setNombre(nombre);
        cont.setApellidos(apellidos);
        cont.setCorreo(correo);
        cont.setTelefono(telefono);

        cont.Modificar();

    }

    public void EliminarRegistroF(int id) {
        Alumnos cont = new Alumnos();

        cont.setId(id);

        cont.EliminarFisico();
    }
}


