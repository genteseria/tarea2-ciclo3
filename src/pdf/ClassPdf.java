/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import entidades.Matricula;
import java.io.File;
//import entidades.Persona;
//import entidades.Natural;

import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Jsmith
 */
public class ClassPdf {

    private String ruta;
    private Matricula matricula;

    public ClassPdf(Matricula matricula) {
        ruta = "matricula.pdf";
        this.matricula = matricula;
    }

    public void crearPdf() {
        try {
            if (new File("matricula.pdf").exists()) {
                new File("matricula.pdf").delete();
            }
            Document documento = new Document();

            PdfWriter.getInstance(documento, new FileOutputStream(getRuta()));

            Image header = Image.getInstance("src/imageness/header.png");
            header.scaleToFit(600, 900);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 16, Font.BOLD, BaseColor.RED));
            parrafo.add("Reporte De Notas \n\n");
            parrafo.add(matricula.getAlumno().getApellidos() + " ," + matricula.getAlumno().getNombre() + " \n\n");
            parrafo.add("\n");
            documento.open();
            documento.add(header);

            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            //Datos del ancho de cada columna.
            tabla.setWidths(new float[]{25, 20, 12, 15});
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(new Paragraph("Curso", FontFactory.getFont("Sitka Text", 14, Font.BOLD, BaseColor.BLACK)));
            tabla.addCell(new Paragraph("Creditos", FontFactory.getFont("Sitka Text", 14, Font.BOLD, BaseColor.BLACK)));
            tabla.addCell(new Paragraph("Nota", FontFactory.getFont("Sitka Text", 14, Font.BOLD, BaseColor.BLACK)));
            tabla.addCell(new Paragraph("N° Vez", FontFactory.getFont("Sitka Text", 14, Font.BOLD, BaseColor.BLACK)));

            for (int i = 0; i < matricula.getAsignaturas().size(); i++) {

                tabla.addCell(matricula.getAsignaturas().get(i).getAsignatura().getNombre());
                tabla.addCell(String.valueOf(matricula.getAsignaturas().get(i).getAsignatura().getCreditos()));
                if (matricula.getAsignaturas().get(i).getCalificacion() == 21.0) {
                    tabla.addCell("Sin calificar");
                } else {
                    tabla.addCell(String.valueOf(matricula.getAsignaturas().get(i).getCalificacion()));
                }
                tabla.addCell(String.valueOf(matricula.getAsignaturas().get(i).getContador()));

            }
            documento.add(tabla);
            documento.close();
            JOptionPane.showMessageDialog(null, "Abriendo pdf...");
            String url = getRuta();
            ProcessBuilder p = new ProcessBuilder();
            if (System.getProperty("os.name").contains("Windows")) {
                p.command("cmd.exe", "/c", url);
            } else if (System.getProperty("os.name").contains("Linux")) {
                p.command("xdg-open", url);
            } else {
                p.command("open", url);
            }

            p.start();

        } catch (Exception e) {
            System.out.println("" + e);
        }

    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;

    }

}
