package Controller;

import Model.Entity.Estado;

public class EstadoCrontroller {

    public void GuardarRegistro(int paisid, String codigo_postal, String descripcion) {
        Estado cont = new Estado();
        //cont.setId(paisid);
        cont.setCodigo_postal(codigo_postal);
        cont.setDescripcion(descripcion);
        cont.Agregar();
    }

    public void GuardarRegistro(int WIDTH, String codigo_postal, String descripcion, String valorSeleccionado) {

        Estado cont = new Estado();
        cont.setId(WIDTH);
        cont.setCodigo_postal(codigo_postal);
        cont.setDescripcion(descripcion);
        cont.setPais_id(valorSeleccionado);
        System.out.println("controlador valor " + valorSeleccionado);
        cont.Agregar();
    }

    public void Modificar(int id, String codigo_postal, String descripcion, String pais_id) {
        Estado estado = new Estado();
        estado.setId(id);
        estado.setCodigo_postal(codigo_postal);
        estado.setDescripcion(descripcion);
        estado.setPais_id(pais_id);
        estado.Modificar();

    }

    public void EliminarRegistroF(int id) {
        Estado cont = new Estado();
        cont.setId(id);
        cont.EliminarFisico();
    }

}
