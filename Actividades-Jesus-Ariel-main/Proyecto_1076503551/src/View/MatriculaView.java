/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.ControlMatriculas;
import Model.Enity.Alumnos;
import Model.Enity.Materia;
import Model.Enity.Matriculas;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author supap
 */
public class MatriculaView extends javax.swing.JInternalFrame {

    ControlMatriculas conto = new ControlMatriculas();
    Matriculas mat = new Matriculas();
    DefaultTableModel modelo;

    public MatriculaView() {
        initComponents();
        ComboBoxPais();
        ComboBoxEstudianre();

        ListarMatriculas();

    }

    private void ComboBoxEstudianre() {
        Alumnos control = new Alumnos();
        comboxestudianets.removeAllItems();
        for (int i = 0; i < control.ListarContinentes().size(); i++) {
            comboxestudianets.addItem(control.ListarContinentes().set(i, control).getNombre());
        }
    }

    private void ComboBoxPais() {
        Materia control = new Materia();
        combixmatriculas1.removeAllItems();
        for (int i = 0; i < control.ListarContinentes().size(); i++) {
            combixmatriculas1.addItem(control.ListarContinentes().set(i, control).getMateriaNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablasmatricuasl = new javax.swing.JTable();
        combixmatriculas1 = new javax.swing.JComboBox<>();
        comboxestudianets = new javax.swing.JComboBox<>();
        txtperiod = new javax.swing.JTextField();
        txtnota = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        Btnguardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablasmatricuasl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MATERIA", "ESTUDIANTE", "PERIODO", "NOTA"
            }
        ));
        tablasmatricuasl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablasmatricuaslMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablasmatricuasl);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 35, -1, 192));

        combixmatriculas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(combixmatriculas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 86, 320, -1));

        comboxestudianets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboxestudianets, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 38, 320, -1));
        getContentPane().add(txtperiod, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 124, -1, -1));
        getContentPane().add(txtnota, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 156, -1, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 6, -1, -1));

        Btnguardar.setText("Guardar");
        Btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(Btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(906, 53, -1, -1));

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnguardarActionPerformed

        String estudiante_id = (String) comboxestudianets.getSelectedItem();
        String materia_id = (String) combixmatriculas1.getSelectedItem();
        String periodo = txtperiod.getText();
        String nota = txtnota.getText();

        if (!"".equals(txtid.getText()) || !"".equals(comboxestudianets.getSelectedItem()) || !"".equals(combixmatriculas1.getSelectedItem()) || !"".equals(txtperiod.getText()) || !"".equals(txtnota.getText())) {

            estudiante_id = (String) comboxestudianets.getSelectedItem();
            materia_id = (String) combixmatriculas1.getSelectedItem();
            periodo = txtperiod.getText();
            nota = txtnota.getText();
            ListarMatriculas();

            conto.GuardarRegistro(WIDTH, estudiante_id, materia_id, periodo, nota);

            JOptionPane.showMessageDialog(null, "Cliente Registrado", "title", JOptionPane.ERROR_MESSAGE);

            Btnguardar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");

        }

    }//GEN-LAST:event_BtnguardarActionPerformed

    private void tablasmatricuaslMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasmatricuaslMouseClicked

        Btnguardar.setEnabled(false);
        int fila = tablasmatricuasl.rowAtPoint(evt.getPoint());
        txtid.setText(tablasmatricuasl.getValueAt(fila, 0).toString());
        txtperiod.setText(tablasmatricuasl.getValueAt(fila, 1).toString());
        combixmatriculas1.setSelectedItem(tablasmatricuasl.getValueAt(fila, 2).toString());
        comboxestudianets.setSelectedItem(tablasmatricuasl.getValueAt(fila, 3).toString());

        txtnota.setText(tablasmatricuasl.getValueAt(fila, 4).toString());


    }//GEN-LAST:event_tablasmatricuaslMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtid.setText("");
        txtperiod.setText("");
        txtnota.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnguardar;
    private javax.swing.JComboBox<String> combixmatriculas1;
    private javax.swing.JComboBox<String> comboxestudianets;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablasmatricuasl;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnota;
    private javax.swing.JTextField txtperiod;
    // End of variables declaration//GEN-END:variables

    public void ListarMatriculas() {
        List<Matriculas> listarMatriculas = mat.ListarMatriculas();
        modelo = (DefaultTableModel) tablasmatricuasl.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < listarMatriculas.size(); i++) {
            ob[0] = listarMatriculas.get(i).getId();
            ob[1] = listarMatriculas.get(i).getEstudiante_Nombre();  
            ob[2] = listarMatriculas.get(i).getMateria_Nombre();    
            ob[3] = listarMatriculas.get(i).getPeriodo();
            ob[4] = listarMatriculas.get(i).getNota();
            modelo.addRow(ob);
        }
        tablasmatricuasl.setModel(modelo);
    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void Limpiar() {
        txtid.setText("");
        txtperiod.setText("");
        txtnota.setText("");

    }

}
