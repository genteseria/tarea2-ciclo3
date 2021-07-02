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

public class AlumnoBL {

    private static Estudiante estudiante;

    public static String escribirEstudiante(String codigo, String apellidos, String nombre, String direccion, String dni, boolean activo, String usuario, String contra) {
        String respuesta = "";
        if (nombre.trim().length() > 0 && codigo.trim().length() > 0
                && apellidos.trim().length() > 0 && direccion.trim().length() > 0 && dni.trim().length() > 0 && usuario.trim().length() > 0
                && contra.trim().length() > 0) {
            estudiante = new Estudiante(codigo, apellidos, nombre, direccion, dni, activo, usuario, contra);
            respuesta = AlumnoDAL.escribirEstudiante(estudiante);
        } else {
            respuesta = "Datos no válidos";
        }
        return respuesta;
    }

    public static int buscarPorNombre(String nombreBuscado) {
        int registro = -1;
        if (nombreBuscado.trim().length() > 1) {
            registro = AlumnoDAL.buscarPorNombre(nombreBuscado);
        }
        return registro;
    }

    public static Estudiante getEstudiante(int i) {
        Estudiante estudiante = null;
        if (i >= 0 && i < AlumnoDAL.getNumRegistros()) {
            estudiante = AlumnoDAL.getEstudiante(i);
        }
        return estudiante;
    }

    public static List<Estudiante> llenarColeccion() {
        return AlumnoDAL.llenarColeccion();
    }
}
