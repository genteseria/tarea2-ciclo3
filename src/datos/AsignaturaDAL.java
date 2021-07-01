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

public class AsignaturaDAL {

    private static RandomAccessFile flujo;
    private static final int TAMREG = 100;
    private static int numRegistros;

    public static String creaFileAsignatura() {
        try {
            flujo = new RandomAccessFile("asignatura.txt", "rw");
            numRegistros
                    = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return null;
    }

    public static String escribirAsignatura(Asignatura asignatura) {
        String mensaje = "";
        try {
            creaFileAsignatura();
            mensaje = setAsignatura(numRegistros, asignatura);
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

    public static String setAsignatura(int i, Asignatura asignatura) {
        String mensaje = "";
        try {
            if (i >= 0 && i <= numRegistros) {
                if (asignatura.getTamaño()> TAMREG) {
                    mensaje = "Tamaño de registro excedido";
                } else {
                    creaFileAsignatura();

                    flujo.seek(i * TAMREG);
                    flujo.writeUTF(asignatura.getCodigo());
                    flujo.writeUTF(asignatura.getNombre());
                    flujo.writeInt(asignatura.getCreditos());
                    flujo.writeInt(asignatura.getCiclo());
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

    public static Asignatura getAsignatura(int i) {
        String nombre,codigo;
        boolean estado;
        int creditos,ciclo;
        Asignatura asignatura = null;
        try {
            creaFileAsignatura();
            flujo.seek(i * TAMREG);
            codigo = flujo.readUTF();
            nombre = flujo.readUTF();
            creditos = flujo.readInt();
            ciclo = flujo.readInt();
            estado = flujo.readBoolean();
            asignatura = new Asignatura(codigo, nombre, creditos, ciclo, estado);
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

    public static int buscarPorNombre(String nombreBuscado) {
        String nombre;
        int pos = -1;
        try {
            creaFileAsignatura();
            for (int i = 0; i < numRegistros; i++) {
                nombre = getAsignatura(i).getNombre();
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

    public static List<Asignatura> llenarColeccion() {
        List<Asignatura> listaA = new ArrayList();
        try {
            creaFileAsignatura();
            for (int i = 0; i < getNumRegistros(); i++) {
                listaA.add(getAsignatura(i));
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
