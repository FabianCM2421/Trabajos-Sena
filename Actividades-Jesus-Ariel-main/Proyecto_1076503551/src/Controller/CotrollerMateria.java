
package Controller;

import Model.Enity.Materia;


public class CotrollerMateria {
    public void  Registar (String codigo ,String nombremateria){
        Materia mrt = new Materia();
        mrt.setCodigo(codigo);
        mrt.setMateriaNombre(nombremateria);
        mrt.Agregar();
    }
    
    public void Modificar (int id ,String codigo ,String nombremateria){
        Materia mrt = new Materia();
        mrt.setId(id);
        mrt.setCodigo(codigo);
        mrt.setMateriaNombre(nombremateria);
        mrt.Modificar();
        
    }
    public void Eliminar (int id){
          Materia mrt = new Materia();
        mrt.setId(id);
        mrt.EliminarFisico();
    }
    
}
