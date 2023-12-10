package Controller;

import Model.Entity.Pais;

public class Paiscontroller {

    public void GuardarRegistro(int contiente_id, String codigo_postal, String descripcion) {
        Pais cont = new Pais();
        cont.setContiente_id(contiente_id);
        cont.setCodigo_postal(codigo_postal);
        cont.setDescripcion(descripcion);
        cont.Agregar();
    }

    public void Modificar(int pais, String codigo_postal, String descripcion, int contiente_id) {

    }

    public void EliminarRegistroF(int id) {
        Pais cont = new Pais();
        cont.setId(id);
        cont.EliminarFisico();
    }

    public void Modificar(int id, String codigo_postal, String descripcion, String contiente_id) {
        Pais cont = new Pais();
        cont.setId(id);
        cont.setCodigo_postal(codigo_postal);
        cont.setDescripcion(descripcion);
        cont.setIdContinente(contiente_id);

        cont.Modificar();

    }
}
