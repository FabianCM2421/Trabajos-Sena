/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.CiudadController;
import Model.Entity.Ciudad;
import Model.Entity.Estado;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author supap
 */
public class Ventana7 extends javax.swing.JInternalFrame {

    Ciudad ciudad = new Ciudad();
    CiudadController cuidadControl = new CiudadController();
    DefaultTableModel modelo;

    public Ventana7() {
        initComponents();
        this.ComboBoxPais();
        ListarContinentes();

    }

    private void ComboBoxPais() {
        Estado control = new Estado();
        ComboxEstados.removeAllItems();
        for (int i = 0; i < control.ListarPaises().size(); i++) {
            ComboxEstados.addItem(control.ListarPaises().set(i, control).getDescripcion());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        ComboxEstados = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaesatdos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtpaisid = new javax.swing.JTextField();
        TxtBucar = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("ID");

        jLabel2.setText("CODIGO");

        jLabel3.setText("DESCRIPCION");

        jLabel4.setText("ESTADOS");

        ComboxEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tablaesatdos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "DESCIPCION", "ESTADOS"
            }
        ));
        tablaesatdos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaesatdosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaesatdos);

        btnGuardar.setText("Agregar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TxtBucar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtBucarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 615, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(txtpaisid, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBucar, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpaisid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(TxtBucar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String codigo_postal;
        String descripcion;
        String valorSeleccionado = (String) ComboxEstados.getSelectedItem();

        if (!"".equals(txtid.getText()) || !"".equals(txtCodigo.getText()) || !"".equals(txtdescripcion.getText()) || !"".equals(ComboxEstados.getSelectedItem())) {

            codigo_postal = txtCodigo.getText();
            descripcion = txtdescripcion.getText();

            valorSeleccionado = (String) ComboxEstados.getSelectedItem();
            System.out.println("view valor que manda" + valorSeleccionado);
            cuidadControl.GuardarRegistro(WIDTH, codigo_postal, descripcion, valorSeleccionado);
            ListarContinentes();

            LimpiarTable();
            Limpiar();
            ListarContinentes();

            JOptionPane.showMessageDialog(null, "Cliente Registrado", "title", JOptionPane.ERROR_MESSAGE);

            btnGuardar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id;
        String codigo_postal;
        String descripcion;
        String Estado_id;

        if ("".equals(txtid.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            id = Integer.parseInt(txtid.getText());
            codigo_postal = txtCodigo.getText();
            descripcion = txtdescripcion.getText();
            Estado_id = txtpaisid.getText();

            if (!"".equals(codigo_postal) || !"".equals(descripcion) || !"".equals(Estado_id)) {
                cuidadControl.Modificar(id, codigo_postal, descripcion, Estado_id);
                System.out.println("view dato vista " + descripcion);
                JOptionPane.showMessageDialog(null, "Modificado");
                LimpiarTable();
                Limpiar();
                ListarContinentes();

                // btnmodifica.setEnabled(false); // Este botón no está presente en el código proporcionado
                btnGuardar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo hacer el cambio");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaesatdosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaesatdosMouseClicked
        btnGuardar.setEnabled(false);
        int fila = tablaesatdos.rowAtPoint(evt.getPoint());
        txtid.setText(tablaesatdos.getValueAt(fila, 0).toString());
        txtCodigo.setText(tablaesatdos.getValueAt(fila, 1).toString());
        txtdescripcion.setText(tablaesatdos.getValueAt(fila, 2).toString());
        txtpaisid.setText(tablaesatdos.getValueAt(fila, 3).toString());
                        ComboxEstados.setSelectedItem(tablaesatdos.getValueAt(fila, 4).toString());

    }//GEN-LAST:event_tablaesatdosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int Id;

        if (!txtid.getText().isEmpty()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?", "title", JOptionPane.YES_NO_OPTION);
            if (pregunta == 0) {
                Id = Integer.parseInt(txtid.getText());
                
                cuidadControl.EliminarRegistroF(Id, Id);
                cuidadControl.EliminarRegistroF(Id, Id);
            LimpiarTable();
            Limpiar();
            ListarContinentes();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.", "", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed
TableRowSorter trs;

    private void TxtBucarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBucarKeyTyped
           trs = new TableRowSorter(modelo);
        tablaesatdos.setRowSorter(trs);

        TxtBucar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter(TxtBucar.getText(), 2));
            }
        });


    }//GEN-LAST:event_TxtBucarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboxEstados;
    private javax.swing.JTextField TxtBucar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaesatdos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtpaisid;
    // End of variables declaration//GEN-END:variables

    public void ListarContinentes() {
        List<Ciudad> listarEstado = ciudad.ListarPaises();
        modelo = (DefaultTableModel) tablaesatdos.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < listarEstado.size(); i++) {
            ob[0] = listarEstado.get(i).getId();
            ob[1] = listarEstado.get(i).getCodigo_postal();
            ob[2] = listarEstado.get(i).getDescripcion();
            ob[3] = listarEstado.get(i).getDescipcionPais();

            modelo.addRow(ob);
        }
        tablaesatdos.setModel(modelo);
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
        txtdescripcion.setText("");

    }

}
