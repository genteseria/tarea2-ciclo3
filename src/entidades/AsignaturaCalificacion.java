/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jsmith
 */
public class AsignaturaCalificacion {

    private Asignatura asignatura;
    private int contador;
    private double calificacion;
    private boolean estado;

    public AsignaturaCalificacion(Asignatura asignatura, int contador, double calificacion, boolean estado) {
        this.asignatura = asignatura;
        this.contador = contador;
        this.calificacion = calificacion;
        this.estado = estado;

    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTamaño() {
        return (getAsignatura().getTamaño()
                + 8
                + 1);
    }

}
