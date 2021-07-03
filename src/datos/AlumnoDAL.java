/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Jsmith
 */
import entidades.*;
import java.io.*;
import java.util.*;

public class AlumnoDAL {

    private static RandomAccessFile flujo;
    private static final int TAMREG = 250;
    private static int numRegistros;

    public static String creaFileEstudiante() {
        try {
            flujo = new RandomAccessFile("alumnos.txt", "rw");
            numRegistros
                    = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return null;
    }

    public static String escribirEstudiante(Estudiante alumno) {
        String mensaje = "";
        try {
            creaFileEstudiante();
            mensaje = setEstudiante(numRegistros, alumno);
            if (mensaje.compareTo("ok") == 0) {
                numRegistros++;
            }
        } finally {
            try {
                cerrar();
            } catch (IOException ex) {
                mensaje = "El flujo ya estaba cerrado: " + ex.getMessage();
            }
        }
        return mensaje;
    }

    public static String setEstudiante(int i, Estudiante alumno) {
        String mensaje = "";
        try {
            if (i >= 0 && i <= numRegistros) {
                if (alumno.getTamaño()> TAMREG) {
                    mensaje = "Tamaño de registro excedido";
                } else {
                    creaFileEstudiante();

                    flujo.seek(i * TAMREG);
                    flujo.writeUTF(alumno.getCodigo());
                    flujo.writeUTF(alumno.getApellidos());
                    flujo.writeUTF(alumno.getNombre());
                    flujo.writeUTF(alumno.getDireccion());
                    flujo.writeUTF(alumno.getDni());
                    flujo.writeBoolean(alumno.isActivo());
                    flujo.writeUTF(alumno.getUsuario());
                    flujo.writeUTF(alumno.getContra());
                    mensaje = "ok";
                }
            } else {
                mensaje = "Número de registro no válido";
            }
        } catch (IOException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                cerrar();
            } catch (IOException ex) {
                mensaje = "El flujo ya estaba cerrado: " + ex.getMessage();
            }
        }
        return mensaje;
    }

    public static Estudiante getEstudiante(int i) {
        String nombre, apellido,direccion,dni,usuario,contra,codigo;
        boolean estado;
        Estudiante alumno = null;
        try {
            creaFileEstudiante();
            flujo.seek(i * TAMREG);
           codigo = flujo.readUTF();
            apellido = flujo.readUTF();
            nombre = flujo.readUTF();
            direccion = flujo.readUTF();
            dni = flujo.readUTF();
            estado = flujo.readBoolean();
            usuario = flujo.readUTF();
            contra = flujo.readUTF();
            alumno = new Estudiante(codigo, apellido, nombre, direccion, dni, true, usuario, contra);
        } catch (IOException ex) {
            System.out.println("\nProblema de E/S: " + ex.getMessage());
        } finally {
// Código de cierre del flujo
        }
        return alumno;
    }

    public static int getNumRegistros() {
        return numRegistros;
    }

    public static void cerrar() throws IOException {
        flujo.close();
    }

    public static int buscarPorNombre(String nombreBuscado) {
        String nombre;
        int pos = -1;
        try {
            creaFileEstudiante();
            for (int i = 0; i < numRegistros; i++) {
                nombre = getEstudiante(i).getNombre();
                if (nombreBuscado.compareToIgnoreCase(nombre) == 0) {
                    pos = i;
                }
            }
        } finally {
            try {
                cerrar();
            } catch (IOException ex) {
                System.out.println("\nEl flujo ya estaba cerrado: " + ex.getMessage());
            }
        }
        return pos;
    }

    public static List<Estudiante> llenarColeccion() {
        List<Estudiante> listaA = new ArrayList();
        try {
            creaFileEstudiante();
            for (int i = 0; i < getNumRegistros(); i++) {
                listaA.add(getEstudiante(i));
            }
        } finally {
            try {
                cerrar();
            } catch (IOException ex) {
                System.out.println("\nEl flujo ya estaba cerrado: " + ex.getMessage());
            }
        }
        return listaA;
    }
}
