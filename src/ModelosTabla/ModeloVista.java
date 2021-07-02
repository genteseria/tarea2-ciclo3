/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTabla;

import entidades.Matricula;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jsmith
 */
public class ModeloVista extends AbstractTableModel {

    private ArrayList<Matricula> matriculas;
    private final String[] columnas = {"Apellidos", "Nombres"};

    public ModeloVista(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public int getRowCount() {
        return matriculas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return matriculas.get(rowIndex).getAlumno().getApellidos();
            case 1:
                return matriculas.get(rowIndex).getAlumno().getNombre();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
