/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.ArrayList;
import javax.swing.*;
import entidades.*;
import java.awt.MouseInfo;
import java.awt.Point;
import logica.AlumnoBL;

public class FrmRegistrarEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form FrmMatricular
     */
    public FrmRegistrarEstudiante() {
        initComponents();
//        ArrayList<String> periodos = new ArrayList<>();

//        jComboBox1.removeAllItems();
//        for (int i = 0; i < periodos.size(); i++) {
//            jComboBox1.addItem(periodos.get(i));
//            
//        }
    }

    public FrmRegistrarEstudiante(ArrayList<Estudiante> alumnos, ArrayList<Matricula> matriculas) {
//        initComponents();
//        this.estudiantes = alumnos;
//        this.matriculas=matriculas;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDirecion = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setAlignmentX(20.0F);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setText("Codigo : ");
        jLabel1.setAlignmentX(4.0F);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 37, 102, -1));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel2.setText("Apellidos :");
        jLabel2.setAlignmentX(4.0F);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 111, 102, -1));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setText("Nombre :");
        jLabel3.setAlignmentX(4.0F);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 74, 102, -1));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel4.setText("Dni :");
        jLabel4.setAlignmentX(4.0F);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 148, 102, -1));

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 42, 170, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 79, 170, -1));

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 116, 170, -1));

        txtDni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 153, 170, -1));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel5.setText("Contraseña :");
        jLabel5.setAlignmentX(4.0F);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 102, -1));

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 270, 170, -1));

        jButton1.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 112, 30));

        jButton2.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        jButton3.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel9.setText("Direccion :");
        jLabel9.setAlignmentX(4.0F);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 102, -1));

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel10.setText("Usuario :");
        jLabel10.setAlignmentX(4.0F);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 102, -1));

        txtDirecion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDirecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirecionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDirecion, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 191, 170, -1));

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 230, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 380, 410));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-x_30.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(341, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(9, 9, 9))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 40));

        setSize(new java.awt.Dimension(375, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String mensaje = "";
        Estudiante alumno = new Estudiante(txtCodigo.getText(), txtApellidos.getText(), txtNombre.getText(),
                txtDirecion.getText(), txtDni.getText(), true, txtUsuario.getText(), txtContraseña.getText());
        mensaje = AlumnoBL.escribirEstudiante(txtCodigo.getText(), txtApellidos.getText(), txtNombre.getText(),
                txtDirecion.getText(), txtDni.getText(), true, txtUsuario.getText(), txtContraseña.getText());
        JOptionPane.showMessageDialog(null, mensaje);
        estudiantes = (ArrayList<Estudiante>) AlumnoBL.llenarColeccion();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        dispose();
        FrmAdministrador ventana = new FrmAdministrador();
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked
    int xx, xy;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        setLocation(p.x - xx, p.y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void txtDirecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirecionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirecionActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtApellidos.setText("");
        txtCodigo.setText("");
        txtContraseña.setText("");
        txtDirecion.setText("");
        txtDni.setText("");
        txtNombre.setText("");
        txtUsuario.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtDirecion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    public static ArrayList<Estudiante> estudiantes = new ArrayList<>();

}
