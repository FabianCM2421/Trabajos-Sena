/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Ciudad;

/**
 *
 * @author supap
 */
public class CiudadController {
    
      public void GuardarRegistro(int WIDTH, String codigo_postal, String descripcion, String valorSeleccionado) {

        Ciudad cont = new Ciudad();
        cont.setId(WIDTH);
        cont.setCodigo_postal(codigo_postal);
        cont.setDescripcion(descripcion);
        cont.setEstado_id(valorSeleccionado);
        System.out.println("controlador valor " + valorSeleccionado);
        cont.Agregar();
    }
      public void Modificar(int id, String codigo_postal, String descripcion, String Estado_id) {
       Ciudad cont = new Ciudad();
        cont.setId(id);
        cont.setCodigo_postal(codigo_postal);
        cont.setDescripcion(descripcion);
        cont.setEstado_id(Estado_id);

        cont.Modificar();

    }
      public void EliminarRegistroF(int id ,int esatdoid ) {
        Ciudad cont = new Ciudad();
        cont.setId(id);
        cont.setEsatdoid(esatdoid);
        cont.EliminarFisico();
    }
}


    

