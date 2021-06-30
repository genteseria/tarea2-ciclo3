/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelosTabla;

import entidades.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jsmith
 */
public class ModeloMatricula extends AbstractTableModel{
    
    private ArrayList<Matricula> matriculas;
    private final String[] columnas = {"Periodo","Apellidos","Nombres","Fecha"};

    public ModeloMatricula(ArrayList<Matricula> matriculas) {
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
        switch(columnIndex){
            case 0:
                return matriculas.get(rowIndex).getPerido().toString();
            case 1:
                return matriculas.get(rowIndex).getAlumno().getApellidos();
            case 2:
                return matriculas.get(rowIndex).getAlumno().getNombre();
            case 3:
                return matriculas.get(rowIndex).getFecha();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
