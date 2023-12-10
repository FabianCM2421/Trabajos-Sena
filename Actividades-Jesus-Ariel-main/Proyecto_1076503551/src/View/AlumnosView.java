/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.CrontrolAlumnos;
import Model.Enity.Alumnos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author supap
 */
public class AlumnosView extends javax.swing.JInternalFrame {

    CrontrolAlumnos contAlumnos = new CrontrolAlumnos();
    Alumnos alum = new Alumnos();
    DefaultTableModel modelo;

    public AlumnosView() {
        initComponents();
        ListarContinentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtid = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaalumnos = new javax.swing.JTable();
        Btnguardar = new javax.swing.JButton();
        Btnmodificar = new javax.swing.JButton();
        btnelimnar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tablaalumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "CORREO", "TELEFONO"
            }
        ));
        tablaalumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaalumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaalumnos);

        Btnguardar.setText("Guardar");
        Btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnguardarActionPerformed(evt);
            }
        });

        Btnmodificar.setText("Modificar");
        Btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnmodificarActionPerformed(evt);
            }
        });

        btnelimnar.setText("Eliminar");
        btnelimnar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimnarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addComponent(txttelefono)
                        .addComponent(txtapellido)
                        .addComponent(txtCodigo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btnguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btnmodificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnelimnar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btnguardar)
                    .addComponent(Btnmodificar)
                    .addComponent(btnelimnar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnguardarActionPerformed

        String nombre;
        String apellidos;
        String correo;
        String telefono;

        if (!"".equals(txtid.getText()) || !"".equals(txtCodigo.getText()) || !"".equals(txtapellido.getText()) || !"".equals(txtCodigo.getText()) || !"".equals(txttelefono.getText())) {
            nombre = txtCodigo.getText();
            apellidos = txtapellido.getText();
            correo = txtcorreo.getText();
            telefono = txttelefono.getText();

            contAlumnos.GuardarRegistro(nombre, apellidos, correo, telefono);
            LimpiarTable();
            Limpiar();
            ListarContinentes();

            JOptionPane.showMessageDialog(null, "Cliente Registrado");

            Btnguardar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");

        }


    }//GEN-LAST:event_BtnguardarActionPerformed

    private void BtnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnmodificarActionPerformed
        int id;
        String nombre;
        String apellidos;
        String correo;
        String telefono;

        if ("".equals(txtid.getText())) {
            JOptionPane.showMessageDialog(null, "Seleecione una fila");
        } else {
            if (!"".equals(txtCodigo.getText()) || !"".equals(txtapellido.getText()) || !"".equals(txtcorreo.getText()) || !"".equals(txttelefono.getText())) {
                alum.setNombre(txtCodigo.getText());

                id = Integer.parseInt(txtid.getText());
                nombre = txtCodigo.getText();
                apellidos = txtapellido.getText();
                correo = txtcorreo.getText();
                telefono = txttelefono.getText();
                contAlumnos.Modificar(id, nombre, apellidos, correo, telefono);

                JOptionPane.showMessageDialog(null, " Modificado");
                LimpiarTable();
                Limpiar();
                ListarContinentes();
                Btnmodificar.setEnabled(false);
                Btnguardar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, " No se pudeo Hcaer el Cambio");

            }}


    }//GEN-LAST:event_BtnmodificarActionPerformed

    private void tablaalumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaalumnosMouseClicked


  Btnguardar.setEnabled(false);
        int fila = tablaalumnos.rowAtPoint(evt.getPoint());
        txtid.setText(tablaalumnos.getValueAt(fila, 0).toString());
        txtCodigo.setText(tablaalumnos.getValueAt(fila, 1).toString());
        txtapellido.setText(tablaalumnos.getValueAt(fila, 2).toString()); 
         txtcorreo.setText(tablaalumnos.getValueAt(fila, 3).toString()); 
          txttelefono.setText(tablaalumnos.getValueAt(fila, 4).toString()); 


    }//GEN-LAST:event_tablaalumnosMouseClicked

    private void btnelimnarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimnarActionPerformed
       
        
      
        
        int Id;

        if (!txtid.getText().isEmpty()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
            if (pregunta == 0) {
                Id = Integer.parseInt(txtid.getText());
                contAlumnos.EliminarRegistroF(Id);
                LimpiarTable();
                Limpiar();
                ListarContinentes();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.");
        }


    }//GEN-LAST:event_btnelimnarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnguardar;
    private javax.swing.JButton Btnmodificar;
    private javax.swing.JButton btnelimnar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaalumnos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    public void ListarContinentes() {
        List<Alumnos> listarContinentes = alum.ListarContinentes();
        modelo = (DefaultTableModel) tablaalumnos.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < listarContinentes.size(); i++) {
            ob[0] = listarContinentes.get(i).getId();
            ob[1] = listarContinentes.get(i).getNombre();
            ob[2] = listarContinentes.get(i).getApellidos();
            ob[3] = listarContinentes.get(i).getCorreo();
            ob[4] = listarContinentes.get(i).getTelefono();

            modelo.addRow(ob);
        }
        tablaalumnos.setModel(modelo);
    }
    
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void Limpiar() {
        txtid.setText("");
        txtCodigo.setText("");
        txtapellido.setText("");
        txtcorreo.setText("");
        txttelefono.setText("");
                

    }

}


