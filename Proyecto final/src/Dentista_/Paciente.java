package Dentista_;

public class Paciente extends Persona {
	private String sintomas ;
	private String estado_dientes ;
	
	public Paciente(String nombre, String ci, String sexo, int edad, String sintomas, String estado_dientes) {
		super(nombre, ci, sexo, edad);
		this.sintomas = sintomas;
		this.estado_dientes = estado_dientes;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getEstado_dientes() {
		return estado_dientes;
	}
	public void setEstado_dientes(String estado_dientes) {
		this.estado_dientes = estado_dientes;
	}
	@Override
	public String toString() {
		return "Paciente [sintomas=" + sintomas + ", estado_dientes=" + estado_dientes + "]";
	}
    public void actualizarEstadoDientes(String nuevoEstado) {
        this.estado_dientes = nuevoEstado;
    }

    public void agregarSintoma(String sintoma) {
        if (this.sintomas == null || this.sintomas.isEmpty()) {
            this.sintomas = sintoma;
        } else {
            this.sintomas += ", " + sintoma;
        }
    }

    public String generarHistoriaClinica() {
        return "Historia Clínica:\n" +
               "Paciente: " + getNombre() + "\n" +
               "CI: " + getCi() + "\n" +
               "Edad: " + getSexo() + "\n" +
               "Sexo: " + getSexo() + "\n" +
               "Síntomas: " + sintomas + "\n" +
               "Estado Dental: " + estado_dientes;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
               "\nEstado de Dientes: " + estado_dientes +
               "\nSíntomas: " + sintomas;
    }
}
