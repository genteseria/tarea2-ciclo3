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

public class AsignaturaCalificadaDAL {

    private static RandomAccessFile flujo;
    private static final int TAMREG = 100;
    private static int numRegistros;

    public static String creaFileAsignaturaCalificacion() {
        try {
            flujo = new RandomAccessFile("asignaturaCalificada.txt", "rw");
            numRegistros
                    = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return null;
    }

    public static String escribirAsignaturaCalificacion(AsignaturaCalificacion asignatura) {
        String mensaje = "";
        try {
            creaFileAsignaturaCalificacion();
            mensaje = setAsignaturaCalificacion(numRegistros, asignatura);
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

    public static String setAsignaturaCalificacion(int i, AsignaturaCalificacion asignatura) {
        String mensaje = "";
        try {
            if (i >= 0 && i <= numRegistros) {
                if (asignatura.getTamaño()> TAMREG) {
                    mensaje = "Tamaño de registro excedido";
                } else {
                    creaFileAsignaturaCalificacion();

                    flujo.seek(i * TAMREG);
                    flujo.writeUTF(asignatura.getAsignatura().getCodigo());
                    flujo.writeUTF(asignatura.getAsignatura().getNombre());
                    flujo.writeInt(asignatura.getAsignatura().getCiclo());
                    flujo.writeInt(asignatura.getAsignatura().getCreditos());
                    flujo.writeBoolean(asignatura.getAsignatura().isEstado());
                    flujo.writeInt(asignatura.getContador());
                    flujo.writeDouble(asignatura.getContador());
                    flujo.writeBoolean(asignatura.isEstado());
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

    public static AsignaturaCalificacion getAsignaturaCalificacion(int i) {
        String nombre,codigo;
        boolean estado,estado2;
        int creditos,ciclo,lleva;
        double nota;
        AsignaturaCalificacion asignatura = null;
        Asignatura a = null;
        try {
            creaFileAsignaturaCalificacion();
            flujo.seek(i * TAMREG);
            codigo = flujo.readUTF();
            nombre = flujo.readUTF();
            creditos = flujo.readInt();
            ciclo = flujo.readInt();
            estado = flujo.readBoolean();
            lleva = flujo.readInt();
            nota = flujo.readDouble();
            estado2 = flujo.readBoolean();
            a = new Asignatura(codigo, nombre, creditos, ciclo, estado);
            asignatura = new AsignaturaCalificacion(a, lleva, nota, estado2);
        } catch (IOException ex) {
            System.out.println("\nProblema de E/S: " + ex.getMessage());
        } finally {
// Código de cierre del flujo
        }
        return asignatura;
    }

    public static int getNumRegistros() {
        return numRegistros;
    }

    public static void cerrar() throws IOException {
        flujo.close();
    }

    public static int buscarPorNombre(String codigo) {
        String nombre;
        int pos = -1;
        try {
            creaFileAsignaturaCalificacion();
            for (int i = 0; i < numRegistros; i++) {
                nombre = getAsignaturaCalificacion(i).getAsignatura().getCodigo();
                if (codigo.compareToIgnoreCase(nombre) == 0) {
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

    public static List<AsignaturaCalificacion> llenarColeccion() {
        List<AsignaturaCalificacion> listaA = new ArrayList();
        try {
            creaFileAsignaturaCalificacion();
            for (int i = 0; i < getNumRegistros(); i++) {
                listaA.add(getAsignaturaCalificacion(i));
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
