package Controller;

import Model.Entity.Continentes;

public class ContinentesController {

    public void GuardarRegistro(String codigo_postal, String descripcion) {
        Continentes cont = new Continentes();
        cont.setCodigo_postal(codigo_postal);
        cont.setDescripcion(descripcion);
        cont.Agregar();
    }

    public void Modificar(int id, String codigo_postal, String descripcion) {
        Continentes cont = new Continentes();
        cont.setId(id);
        cont.setCodigo_postal(codigo_postal);
        cont.setDescripcion(descripcion);
        cont.Modificar();
    }

    public void EliminarRegistroF(int id) {
        Continentes cont = new Continentes();
        cont.setId(id);
        cont.EliminarFisico();
    }

    public void EliminarRegistroLo(int id) {
        Continentes cont = new Continentes();
        cont.setId(id);
        cont.EliminarLogico();

    }
    public Continentes Consultar(int id) {
    Continentes cont = new Continentes();
    cont.setId(id);
    return (Continentes) cont.Consultar();
}

}
