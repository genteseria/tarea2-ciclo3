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

public class MatriculaBL {

    private static Matricula matricula;

    public static String escribirMatricula(String ID,PeriodoAcademico perido, String fecha, Estudiante alumno, ArrayList<AsignaturaCalificacion> asignaturas) {
        String respuesta = "";
        if (fecha.trim().length() > 0 ) {
            matricula = new Matricula(ID,perido, fecha, alumno, asignaturas);
            respuesta = MatriculaDAL.escribirMatricula(matricula);
        } else {
            respuesta = "Datos no válidos";
        }
        return respuesta;
    }

    public static int buscarPorNombre(String nombreBuscado) {
        int registro = -1;
        if (nombreBuscado.trim().length() > 1) {
            registro = MatriculaDAL.buscarPorNombre(nombreBuscado);
        }
        return registro;
    }

    public static Matricula getMatricula(int i) {
        Matricula matricula = null;
        if (i >= 0 && i < AlumnoDAL.getNumRegistros()) {
            matricula =MatriculaDAL.getMatricula(i);
        }
        return matricula;
    }

    public static List<Matricula> llenarColeccion() {
            return MatriculaDAL.llenarColeccion();
    }
}
