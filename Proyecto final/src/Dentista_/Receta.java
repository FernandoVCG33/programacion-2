package Dentista_;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Receta {
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
	        return "=== Receta Médica ===\n" +
	               "Fecha: " + obtenerFechaFormateada() + "\n" +
	               "Descripción: " + descripcion + "\n" +
	               "Medicamentos: " + medicamentos;
	    }
}
