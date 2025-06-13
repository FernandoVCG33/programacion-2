package Dentista_;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
public class Receta implements Archivos{
	 private String descripcion;
	    private String medicamentos;
	    private Date fecha;

	    // Constructor
	    public Receta(String descripcion, String medicamentos) {
	        this.descripcion = descripcion;
	        this.medicamentos = medicamentos;
	        this.fecha = new Date(); // fecha actual
	    }

	    // Getters y setters
	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public String getMedicamentos() {
	        return medicamentos;
	    }

	    public void setMedicamentos(String medicamentos) {
	        this.medicamentos = medicamentos;
	    }

	    public Date getFecha() {
	        return fecha;
	    }

	    public void setFecha(Date fecha) {
	        this.fecha = fecha;
	    }

	    public String obtenerFechaFormateada() {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        return sdf.format(fecha);
	    }

	    // Método para mostrar receta
	    public String mostrarReceta() {
	        return "Receta Médica\n " +
	               " Fecha: " + obtenerFechaFormateada() + "\n " +
	               " Descripción: " + descripcion + "\n " +
	               " Medicamentos: " + medicamentos;
	    }
	    // Método para registrar una receta en el archivo TXT
	    public boolean registrarRecetaTxt(String archivo) {
	        try {
	            PrintWriter escritor = new PrintWriter(new FileWriter(archivo, true));
	            String registro = this.descripcion + ";" + this.medicamentos + ";" + this.obtenerFechaFormateada();
	            escritor.println(registro);
	            escritor.close();
	        } catch (IOException e) {
	            return false;
	        }
	        return true;
	    }


	    // Método para leer todas las recetas desde el archivo TXT
	    public static ArrayList<Receta> leerRecetasDesdeTxt(String archivo) {
	        ArrayList<Receta> lista = new ArrayList<>();

	        try {
	            BufferedReader lector = new BufferedReader(new FileReader(archivo));
	            String linea;

	            while ((linea = lector.readLine()) != null) {
	                String[] partes = linea.split(";");
	                if (partes.length == 3) {
	                    String descripcion = partes[0];
	                    String medicamentos = partes[1];
	                    String fechaTexto = partes[2];

	                    Receta r = new Receta(descripcion, medicamentos);
	                    // Se puede ignorar setFecha si no es necesaria, o agregarla si quieres
	                    lista.add(r);
	                }
	            }

	            lector.close();
	        } catch (IOException e) {
	            // manejo básico, no mostrar mensaje si no se requiere
	        }

	        return lista;
	    }

}
