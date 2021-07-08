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

public class PeriodoAcademicoDAL {

    private static RandomAccessFile flujo;
    private static final int TAMREG = 15;
    private static int numRegistros;

    public static String creaFilePeriodoAcademico() {
        try {
            flujo = new RandomAccessFile("periodoAcademico.txt", "rw");
            numRegistros
                    = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return null;
    }

    public static String escribirPeriodoAcademico(PeriodoAcademico periodo) {
        String mensaje = "";
        try {
            creaFilePeriodoAcademico();
            mensaje = setPeriodoAcademico(numRegistros, periodo);
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

    public static String setPeriodoAcademico(int i, PeriodoAcademico periodo) {
        String mensaje = "";
        try {
            if (i >= 0 && i <= numRegistros) {
                if (periodo.getTamaño() > TAMREG) {
                    mensaje = "Tamaño de registro excedido";
                } else {
                    creaFilePeriodoAcademico();

                    flujo.seek(i * TAMREG);
                    flujo.writeInt(periodo.getAño());
                    flujo.writeUTF(periodo.getSemestre());
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

    public static PeriodoAcademico getPeriodoAcademico(int i) {
        String semestre;
        int n;
        PeriodoAcademico periodo = null;
        try {
            creaFilePeriodoAcademico();
            flujo.seek(i * TAMREG);
            semestre = flujo.readUTF();
            n = flujo.readInt();
            periodo = new PeriodoAcademico(n, semestre);
        } catch (IOException ex) {
            System.out.println("\nProblema de E/S: " + ex.getMessage());
        } finally {
// Código de cierre del flujo
        }
        return periodo;
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
            creaFilePeriodoAcademico();
            for (int i = 0; i < numRegistros; i++) {
                nombre = getPeriodoAcademico(i).getSemestre();
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

    public static List<PeriodoAcademico> llenarColeccion() {
        List<PeriodoAcademico> listaA = new ArrayList();
        try {
            creaFilePeriodoAcademico();
            for (int i = 0; i < getNumRegistros(); i++) {
                listaA.add(getPeriodoAcademico(i));
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
