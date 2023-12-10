/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Enity.Matriculas;


public class ControlMatriculas {
    public void GuardarRegistro(int WIDTH, String valorSeleccionadoE,String valorSeleccionadoM,String periodo ,String Nota ) {

        Matriculas cont = new Matriculas();
        cont.setId(WIDTH);
        cont.setEstudiante_Nombre(valorSeleccionadoE);
        cont.setMateria_Nombre(valorSeleccionadoM);
        cont.setPeriodo(periodo);
        cont.setNota(Nota);
       
        cont.Agregar();
    }
}