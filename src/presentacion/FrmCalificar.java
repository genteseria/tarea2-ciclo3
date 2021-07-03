/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import ModelosTabla.ModeloCalificacion;
import ModelosTabla.ModeloVista;
import datos.MatriculaDAL;
import entidades.AsignaturaCalificacion;
import entidades.Matricula;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.MatriculaBL;

/**
 *
 * @author HP
 */
public class FrmCalificar extends javax.swing.JFrame {
    ModeloCalificacion tma;
    ArrayList<AsignaturaCalificacion> asignaturaCalis;
    String apellido;
    ArrayList<Matricula> matriculas = (ArrayList<Matricula>) MatriculaBL.llenarColeccion();
    int asignaturaSeleccionada;
    
    /**
     * Creates new form FrmCalificar
     */
    public FrmCalificar() {
        initComponents();
        jTable1.setModel( new ModeloVista(matriculas));
    }
    
    public void elegirAsignatura(){
        
        try {
        int row = jTable1.getSelectedRow();
            String periodo = String.valueOf(jTable1.getValueAt(row, 0));  
             apellido = String.valueOf(jTable1.getValueAt(row, 1));  
            if (!(row == -1)) {
                //recorro un ciclo para saber la asignatura por codigo
                for (int j = 0; j < matriculas.size(); j++) {
                    if (matriculas.get(j).getAlumno().getApellidos().equals(apellido) && 
                            matriculas.get(j).getPerido().toString().equals(periodo)) {

                        txtApellido.setText(matriculas.get(j).getAlumno().getApellidos());
                        JOptionPane.showMessageDialog(null, "Asignatura Seleccionada!", "Mensaje", 1);
                        
                        asignaturaCalis = matriculas.get(j).getAsignaturas();
                        
                        tma = new ModeloCalificacion(asignaturaCalis);
                        jTable2.setModel(tma);
                        //sumo los creditos
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla", "Mensaje", 2);
            }
        } catch (Exception e) {
        }
    }
    
    public void elegir(){
        try {
        int row = jTable2.getSelectedRow();
            String codigo = String.valueOf(jTable2.getValueAt(row, 0));
            
            if (!(row == -1)) {
                //recorro un ciclo para saber la asignatura por codigo
                for (int j = 0; j < asignaturaCalis.size(); j++) {
                    if (asignaturaCalis.get(j).getAsignatura().getCodigo().equals(codigo)) {

                        txtCurso.setText(asignaturaCalis.get(j).getAsignatura().getNombre());
                        if(asignaturaCalis.get(j).getCalificacion()==21.0){
                            txtCalificacion.setForeground(Color.red);
                            txtCalificacion.setText("Sin calificar");
                        }else{
                            txtCalificacion.setText(String.valueOf(asignaturaCalis.get(j).getCalificacion()));
                            txtCalificacion.setForeground(Color.BLACK);
                        }
                        asignaturaSeleccionada = j;
                        txtNveces.setText(String.valueOf(asignaturaCalis.get(j).getContador()));
                        JOptionPane.showMessageDialog(null, "Asignatura Seleccionada!", "Mensaje", 1);
                        //sumo los creditos
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla", "Mensaje", 2);
            }
        } catch (Exception e) {
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtCurso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNveces = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 206, 426, 119));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 48)); // NOI18N
        jLabel1.setText("CALIFICACIÓN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 45, -1, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setText("Buscar Alumno :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 152, 150, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel3.setText("Buscar Asignatura :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 409, 426, 119));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel4.setText("Curso :  ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 230, 80, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 152, 44, 407));

        txtCurso.setEditable(false);
        txtCurso.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jPanel1.add(txtCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 221, 135, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel5.setText("Calificación :  ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 268, 130, -1));

        txtCalificacion.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        txtCalificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCalificacionMouseClicked(evt);
            }
        });
        txtCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalificacionActionPerformed(evt);
            }
        });
        jPanel1.add(txtCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 263, 135, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel6.setText("N Vez :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        txtNveces.setEditable(false);
        txtNveces.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jPanel1.add(txtNveces, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 305, 130, -1));

        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton1.setText("Calificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 140, 50));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel7.setText("Apellidos:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 110, -1));

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 179, 135, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/click.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 50, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/click.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 50, 40));

        jButton4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-x_30.png"))); // NOI18N
        jButton4.setText("Atrás");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       elegirAsignatura();
       txtCalificacion.setText(null);
       txtCurso.setText(null);
       txtNveces.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       elegir();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalificacionActionPerformed
        
    }//GEN-LAST:event_txtCalificacionActionPerformed

    private void txtCalificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCalificacionMouseClicked
        txtCalificacion.setText("");
    }//GEN-LAST:event_txtCalificacionMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        FrmAlumno.matriculas.get(1).getAsignaturas().
      if(Integer.parseInt( txtCalificacion.getText())>=0 && Integer.parseInt( txtCalificacion.getText())<=20){
          int veces;
      int ver = -1;
        for (int i = 0; i < matriculas.size(); i++) {
            if(apellido.equals(txtApellido.getText()) && txtCurso.getText().equals(matriculas.get(i).getAsignaturas().get(asignaturaSeleccionada).getAsignatura().getNombre()) ){
                ver = i;       
            }
           
        }
        
        if(ver!=-1){
            Matricula m =null;
            m = matriculas.get(ver);
            m.getAsignaturas().get(asignaturaSeleccionada).setCalificacion(Double.parseDouble(txtCalificacion.getText()));
                    veces =m.getAsignaturas().get(asignaturaSeleccionada).getContador();
                    m.getAsignaturas().get(asignaturaSeleccionada).setContador(veces);
                           MatriculaDAL.setMatricula(ver, m);
                    if(veces==4){
                        
                    }else{
                        if(Double.parseDouble(txtCalificacion.getText()) <= 10.4){
                         veces++;
                          
                           m.getAsignaturas().get(asignaturaSeleccionada).setContador(veces);
                           MatriculaDAL.setMatricula(ver, m);
                    }
                    }
                    
                    
                    if(veces<4){

                        JOptionPane.showMessageDialog(null,"Calificacion Realizada");
                    }else{
                        JOptionPane.showMessageDialog(null,"Este Alumno se retirará de la Universidad Nacional De Trujillo","Menjaje",2);
                    }
        }
         txtCalificacion.setText("");
          txtCurso.setText("");
          txtNveces.setText("");
      }else{
          JOptionPane.showMessageDialog(null,"Ingrese una nota válida","Advertencia",2);
            txtCalificacion.setText("");
          txtCurso.setText("");
          txtNveces.setText("");
      }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        FrmAdministrador v = new FrmAdministrador();
        v.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtNveces;
    // End of variables declaration//GEN-END:variables
}
