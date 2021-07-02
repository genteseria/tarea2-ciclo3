/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import ModelosTabla.ModeloAsignatura;
import entidades.Asignatura;
import entidades.AsignaturaCalificacion;
import entidades.Estudiante;
import entidades.Matricula;
import entidades.PeriodoAcademico;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.MatriculaBL;

public class FrmAlumno extends javax.swing.JFrame {

    ModeloAsignatura tma;
    public static Estudiante alumno = null;

    /**
     * Creates new form FrmAlumno
     */
    public FrmAlumno() {
        initComponents();
    }

    public void cambiar() {

        ArrayList<Asignatura> muestreo = new ArrayList<>();
        ArrayList<Asignatura> asignatu = FrmRegistrarAsignatura.asignaturas;

        try {
            String sele = String.valueOf(jcBPeriodo.getSelectedItem());
            if (sele.equals("Nivelacion")) {

                JOptionPane.showMessageDialog(null, "Nivelacion");
            } else if (sele.equals("2021-I")) {

                for (int i = 0; i < asignatu.size(); i++) {

                    if (asignatu.get(i).getCiclo() == 1) {
                        if (asignatu.get(i).isEstado()) {
                            muestreo.add(asignatu.get(i));
                        }
                    }

                }

                tma = new ModeloAsignatura(muestreo);
                tablaCursosDisponibles.setModel(tma);

            } else if (sele.equals("2021-II")) {

                for (int i = 0; i < asignatu.size(); i++) {
                    if (asignatu.get(i).getCiclo() == 2) {
                        if (asignatu.get(i).isEstado()) {
                            muestreo.add(asignatu.get(i));
                        }

                    }
                }

                tma = new ModeloAsignatura(muestreo);
                tablaCursosDisponibles.setModel(tma);
            }
        } catch (Exception e) {
        }

    }

    public void elegirAsignatura() {
        try {
            int nVeces = 1;
            double nota = 21;
            boolean estado = true;
            int creditos = 0;
            int creditosAnterior = Integer.parseInt(txtTotalCreditos.getText());
            int row = tablaCursosDisponibles.getSelectedRow();
            if (jcBPeriodo.getSelectedItem().toString().equals("Seleccionar Periodo")) {
                JOptionPane.showMessageDialog(null, "Seleccione un Periodo", "Advertencia", 2);
            } else {
                String codigoAsignatura = String.valueOf(tablaCursosDisponibles.getValueAt(row, 0));
                if (verificadorMatricula(codigoAsignatura)) {
                    if (!(row == -1)) {
                        //recorro un ciclo para saber la asignatura por codigo
                        for (int j = 0; j < asignaturas.size(); j++) {
                            if (asignaturas.get(j).getCodigo().equals(codigoAsignatura)) {
                                //Añado la asignatura matriculada
                                AsignaturaCalificacion cali = new AsignaturaCalificacion(asignaturas.get(j), nVeces, nota, true);
                                asignaturasSeleccionadas.add(cali);
                                asignaturasVisualizar.add(asignaturas.get(j));
                                JOptionPane.showMessageDialog(null, "Asignatura Matriculada!", "Mensaje", 1);
                                //sumo los creditos
                                creditos = creditosAnterior + asignaturas.get(j).getCreditos();
                                txtTotalCreditos.setText(String.valueOf(creditos));
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla", "Mensaje", 2);
                    }
                }
            }
        } catch (Exception e) {
        }

    }

    public boolean verificadorMatricula(String codigo) {
        boolean verificador = true;
        try {
            for (int i = 0; i < asignaturasSeleccionadas.size(); i++) {
                if (asignaturasSeleccionadas.get(i).getAsignatura().getCodigo().equals(codigo)) {
                    JOptionPane.showMessageDialog(null, "Ya esta matriculado en esta asignatura", "Mensaje", 2);
                    verificador = false;
                }

            }
        } catch (Exception e) {
        }

        return verificador;
    }

    public void llenarTablaMatricula() {
        try {
            ModeloAsignatura tmaAsignatura = new ModeloAsignatura(asignaturasVisualizar);
            tablaMatriculados.setModel(tmaAsignatura);
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCursosDisponibles = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMatriculados = new javax.swing.JTable();
        jcBPeriodo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTotalCreditos = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Subheading", 1, 18))); // NOI18N

        tablaCursosDisponibles.setBackground(new java.awt.Color(102, 102, 255));
        tablaCursosDisponibles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tablaCursosDisponibles.setForeground(new java.awt.Color(0, 0, 0));
        tablaCursosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Asignaturas", "Creditos", "Ciclo"
            }
        ));
        jScrollPane1.setViewportView(tablaCursosDisponibles);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 500, 160));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos Matriculados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Subheading", 1, 18))); // NOI18N

        tablaMatriculados.setBackground(new java.awt.Color(102, 102, 255));
        tablaMatriculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Asignaturas", "Creditos", "Ciclo"
            }
        ));
        jScrollPane2.setViewportView(tablaMatriculados);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 500, -1));

        jcBPeriodo.setBackground(new java.awt.Color(0, 102, 255));
        jcBPeriodo.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jcBPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Periodo", "2021-I", "2021-II", "Nivelacion" }));
        jcBPeriodo.setBorder(new javax.swing.border.MatteBorder(null));
        jcBPeriodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcBPeriodoFocusGained(evt);
            }
        });
        jcBPeriodo.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jcBPeriodoMouseWheelMoved(evt);
            }
        });
        jcBPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcBPeriodoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcBPeriodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcBPeriodoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcBPeriodoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcBPeriodoMouseReleased(evt);
            }
        });
        jcBPeriodo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jcBPeriodoComponentHidden(evt);
            }
        });
        jcBPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBPeriodoActionPerformed(evt);
            }
        });
        jPanel1.add(jcBPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 180, 30));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setText("Matricular");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 120, 50));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel3.setText("Σ Creditos :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtTotalCreditos.setEditable(false);
        txtTotalCreditos.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        txtTotalCreditos.setText("0");
        jPanel1.add(txtTotalCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 12, 40, 30));

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setText("Agregar");
        jButton3.setBorder(new javax.swing.border.MatteBorder(null));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 120, 50));

        jButton4.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton4.setText("Atrás");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcBPeriodoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcBPeriodoFocusGained

    }//GEN-LAST:event_jcBPeriodoFocusGained

    private void jcBPeriodoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseWheelMoved

    }//GEN-LAST:event_jcBPeriodoMouseWheelMoved

    private void jcBPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseClicked

    }//GEN-LAST:event_jcBPeriodoMouseClicked

    private void jcBPeriodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseEntered

    }//GEN-LAST:event_jcBPeriodoMouseEntered

    private void jcBPeriodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseExited

    }//GEN-LAST:event_jcBPeriodoMouseExited

    private void jcBPeriodoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMousePressed

    }//GEN-LAST:event_jcBPeriodoMousePressed

    private void jcBPeriodoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcBPeriodoMouseReleased

    }//GEN-LAST:event_jcBPeriodoMouseReleased

    private void jcBPeriodoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcBPeriodoComponentHidden

    }//GEN-LAST:event_jcBPeriodoComponentHidden

    private void jcBPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBPeriodoActionPerformed

        try {
            cambiar();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jcBPeriodoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String sele = String.valueOf(jcBPeriodo.getSelectedItem());

        if (asignaturasSeleccionadas.size() < 5) {
            JOptionPane.showMessageDialog(null, "Matricularse en 5 asignaturas", "Advertencia", 2);
        } else if (asignaturasSeleccionadas.size() == 5) {
            String semestre = "";
            int Año = 0;
            if (sele.equals("Nivelacion")) {
                semestre = "Nivelacion";
                Año = 2021;
            } else if (sele.equals("2021-I")) {
                semestre = "I";
                Año = 2021;
            } else if (sele.equals("2021-II")) {
                semestre = "II";
                Año = 2021;
            }
            PeriodoAcademico pe = new PeriodoAcademico(Año, semestre);
            String fecha;
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            fecha = dateFormat.format(date);
//            Matricula matricula = new Matricula(pe, fecha, alumno,asignaturasSeleccionadas);
            String mensaje = "";
            mensaje = MatriculaBL.escribirMatricula(pe, fecha, alumno, asignaturasSeleccionadas);
            JOptionPane.showMessageDialog(null, mensaje);
            matriculas = (ArrayList<Matricula>) MatriculaBL.llenarColeccion();
////            matriculas.add(matricula);
            JOptionPane.showMessageDialog(null, "Matricula Realizada con exito", "Mensaje", 1);
            dispose();
            FrmLoginEstudiante c = new FrmLoginEstudiante();
            c.setVisible(true);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            elegirAsignatura();
            llenarTablaMatricula();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        FrmEstudiante c = new FrmEstudiante();
        c.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcBPeriodo;
    private javax.swing.JTable tablaCursosDisponibles;
    private javax.swing.JTable tablaMatriculados;
    private javax.swing.JTextField txtTotalCreditos;
    // End of variables declaration//GEN-END:variables
    private ArrayList<AsignaturaCalificacion> asignaturasSeleccionadas = new ArrayList<>();
    private ArrayList<Asignatura> asignaturas = FrmRegistrarAsignatura.asignaturas;
    public static ArrayList<Matricula> matriculas = new ArrayList();
    private ArrayList<Asignatura> asignaturasVisualizar = new ArrayList<>();
}
