/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTabla;

import entidades.AsignaturaCalificacion;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jsmith
 */
public class ModeloCalificacion extends AbstractTableModel {

    private ArrayList<AsignaturaCalificacion> asignaturas;
    private final String[] columnas = {"Codigo", "Asignatura", "Creditos"};

    public ModeloCalificacion(ArrayList<AsignaturaCalificacion> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public int getRowCount() {
        return asignaturas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            switch (columnIndex) {
                case 0:
                    return asignaturas.get(rowIndex).getAsignatura().getCodigo();
                case 1:
                    return asignaturas.get(rowIndex).getAsignatura().getNombre();
                case 2:
                    return asignaturas.get(rowIndex).getAsignatura().getCreditos();
            }
        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
