/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.ArrayList;


public class Matricula {
    
    private PeriodoAcademico perido;
    private String fecha;
    private Estudiante alumno;
    private ArrayList<AsignaturaCalificacion> asignaturas;
    
    //750

    public Matricula(PeriodoAcademico perido, String fecha, Estudiante alumno, ArrayList<AsignaturaCalificacion> asignaturas) {
        this.perido = perido;
        this.fecha = fecha;
        this.alumno = alumno;
        this.asignaturas = asignaturas;
    }

    public ArrayList<AsignaturaCalificacion> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<AsignaturaCalificacion> asignaturas) {
        this.asignaturas = asignaturas;
    }

    

    public PeriodoAcademico getPerido() {
        return perido;
    }

    public void setPerido(PeriodoAcademico perido) {
        this.perido = perido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Estudiante getAlumno() {
        return alumno;
    }

    public void setAlumno(Estudiante alumno) {
        this.alumno = alumno;
    }

    public String cursos() {
        String mensaje = "";
        for (int i = 0; i < asignaturas.size(); i++) {
              mensaje+=i+1+"- "+asignaturas.get(i).getAsignatura().getNombre()+"\n\n";
        }
        return mensaje;
    }
    
        public String notas() {
        String mensaje = "";
        for (int i = 0; i < asignaturas.size(); i++) {
            if(asignaturas.get(i).getCalificacion()==21){
                mensaje+="Sin calificar"+"\n\n";
            }else{
                mensaje+=asignaturas.get(i).getCalificacion()+"\n\n";
            }
              
        }
        return mensaje;
    }

    
    
    
     public int getTamaño() {
        return (getPerido().getTamaño()
                + getFecha().length()*2+ 2
                + getAlumno().getTamaño());

    }
}
