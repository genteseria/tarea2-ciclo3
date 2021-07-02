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

public class MatriculaDAL {

    private static RandomAccessFile flujo;
    private static final int TAMREG = 600;
    private static int numRegistros;

    public static String creaFileMatricula() {
        try {
            flujo = new RandomAccessFile("matricula.txt", "rw");
            numRegistros
                    = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return null;
    }

    public static String escribirMatricula(Matricula matricula) {
        String mensaje = "";
        try {
            creaFileMatricula();
            mensaje = setMatricula(numRegistros, matricula);
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

    public static String setMatricula(int i, Matricula matricula) {
        String mensaje = "";
        try {
            if (i >= 0 && i <= numRegistros) {
                if (matricula.getTamaño() > TAMREG) {
                    mensaje = "Tamaño de registro excedido";
                } else {
                    creaFileMatricula();

                    flujo.seek(i * TAMREG);
                    //SEMESTRE
                    flujo.writeInt(matricula.getPerido().getAño());
                    flujo.writeUTF(matricula.getPerido().getSemestre());
                    //FECHA
                    flujo.writeUTF(matricula.getFecha());
                    //ESTUDIANTE
                    flujo.writeUTF(matricula.getAlumno().getCodigo());
                    flujo.writeUTF(matricula.getAlumno().getApellidos());
                    flujo.writeUTF(matricula.getAlumno().getNombre());
                    flujo.writeUTF(matricula.getAlumno().getDireccion());
                    flujo.writeUTF(matricula.getAlumno().getDni());
                    flujo.writeBoolean(matricula.getAlumno().isActivo());
                    flujo.writeUTF(matricula.getAlumno().getUsuario());
                    flujo.writeUTF(matricula.getAlumno().getContra());

                    flujo.writeInt(matricula.getAsignaturas().size());

                    //ASIGNATURAS
                    for (int j = 0; j < matricula.getAsignaturas().size(); j++) {
                        flujo.writeUTF(matricula.getAsignaturas().get(j).getAsignatura().getCodigo());
                        flujo.writeUTF(matricula.getAsignaturas().get(j).getAsignatura().getNombre());
                        flujo.writeInt(matricula.getAsignaturas().get(j).getAsignatura().getCreditos());
                        flujo.writeInt(matricula.getAsignaturas().get(j).getAsignatura().getCiclo());
                        flujo.writeBoolean(matricula.getAsignaturas().get(j).getAsignatura().isEstado());
                        flujo.writeInt(matricula.getAsignaturas().get(j).getContador());
                        flujo.writeDouble(matricula.getAsignaturas().get(j).getCalificacion());
                        flujo.writeBoolean(matricula.getAsignaturas().get(j).isEstado());
                    }

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

    public static Matricula getMatricula(int i) {
        String semestre;
        int anio;

        String fecha;

        int cantidad;
        String nombre, apellido, direccion, dni, usuario, contra, codigo;
        boolean estado;

        String nomA, codigoAsi;
        boolean estadoasig, estado1;
        int creditos, ciclo, lleva;
        double nota;

        ArrayList<AsignaturaCalificacion> asignas = new ArrayList<>();
        Matricula matricula = null;
        Estudiante alumno = null;
        PeriodoAcademico peri = null;
        AsignaturaCalificacion asignatura = null;
        Asignatura a = null;
        try {
            creaFileMatricula();
            flujo.seek(i * TAMREG);

            anio = flujo.readInt();
            semestre = flujo.readUTF();
            peri = new PeriodoAcademico(anio, semestre);

            fecha = flujo.readUTF();

            codigo = flujo.readUTF();
            apellido = flujo.readUTF();
            nombre = flujo.readUTF();
            direccion = flujo.readUTF();
            dni = flujo.readUTF();
            estado = flujo.readBoolean();
            usuario = flujo.readUTF();
            contra = flujo.readUTF();
            alumno = new Estudiante(codigo, apellido, nombre, direccion, dni, estado, usuario, contra);
            cantidad = flujo.readInt();

            for (int j = 0; j < cantidad; j++) {
                codigoAsi = flujo.readUTF();
                nomA = flujo.readUTF();
                creditos = flujo.readInt();
                ciclo = flujo.readInt();
                estadoasig = flujo.readBoolean();
                lleva = flujo.readInt();
                nota = flujo.readDouble();
                estado1 = flujo.readBoolean();
                a = new Asignatura(codigoAsi, nomA, creditos, ciclo, estadoasig);
                asignatura = new AsignaturaCalificacion(a, lleva, nota, estado1);
                asignas.add(asignatura);
            }
            matricula = new Matricula(peri, fecha, alumno, asignas);

        } catch (IOException ex) {
            System.out.println("\nProblema de E/S: " + ex.getMessage());
        } finally {

        }
        return matricula;
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
            creaFileMatricula();
            for (int i = 0; i < numRegistros; i++) {
                nombre = getMatricula(i).getAlumno().getCodigo();
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

    public static List<Matricula> llenarColeccion() {
        List<Matricula> listaA = new ArrayList();
        try {
            creaFileMatricula();
            for (int i = 0; i < getNumRegistros(); i++) {
                listaA.add(getMatricula(i));
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
