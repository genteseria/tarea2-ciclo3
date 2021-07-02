/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Jsmith
 */
import entidades.*;
import datos.*;
import java.util.*;

public class PeriodoAcademicoBL {

    private static PeriodoAcademico periodo;

    public static String escribirPeriodoAcademico(String semestre, int ciclo) {
        String respuesta = "";
        if (semestre.trim().length() > 0) {
            periodo = new PeriodoAcademico(ciclo, semestre);
            respuesta = PeriodoAcademicoDAL.escribirPeriodoAcademico(periodo);
        } else {
            respuesta = "Datos no válidos";
        }
        return respuesta;
    }

    public static int buscarPorNombre(String nombreBuscado) {
        int registro = -1;
        if (nombreBuscado.trim().length() > 1) {
            registro = PeriodoAcademicoDAL.buscarPorNombre(nombreBuscado);
        }
        return registro;
    }

    public static PeriodoAcademico getPeriodoAcademico(int i) {
        PeriodoAcademico periodo = null;
        if (i >= 0 && i < AlumnoDAL.getNumRegistros()) {
            periodo = PeriodoAcademicoDAL.getPeriodoAcademico(i);
        }
        return periodo;
    }

    public static List<PeriodoAcademico> llenarColeccion() {
        return PeriodoAcademicoDAL.llenarColeccion();
    }

}
