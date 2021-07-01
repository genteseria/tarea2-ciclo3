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

public class AsignaturaCalificadaBL {

    private static Asignatura asignatura;

    public static String escribirAsignatura(String codigo, String nombre, int creditos, int ciclo,boolean estado){
        String respuesta = "";
        if (nombre.trim().length() > 0 && codigo.trim().length() > 0) {
            asignatura = new Asignatura(codigo, nombre, creditos, ciclo, estado);
            respuesta = AsignaturaDAL.escribirAsignatura(asignatura);
        } else {
            respuesta = "Datos no válidos";
        }
        return respuesta;
    }

    public static int buscarPorNombre(String nombreBuscado) {
        int registro = -1;
        if (nombreBuscado.trim().length() > 1) {
            registro = AsignaturaDAL.buscarPorNombre(nombreBuscado);
        }
        return registro;
    }

    public static Asignatura getAsignatura(int i) {
        Asignatura asignatura = null;
        if (i >= 0 && i < AlumnoDAL.getNumRegistros()) {
            asignatura = AsignaturaDAL.getAsignatura(i);
        }
        return asignatura;
    }

    public static List<Asignatura> llenarColeccion() {
        return AsignaturaDAL.llenarColeccion();
    }
    
}
