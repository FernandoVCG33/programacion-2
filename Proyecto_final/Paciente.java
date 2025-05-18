public class Paciente extends Persona{
    private  String sintomas;
    private String estado_de_dientes;

    public Paciente(String nombre, String ci, int edad, String sintomas, String estado_de_dientes) {
        super(nombre, ci, edad);
        this.sintomas = sintomas;
        this.estado_de_dientes = estado_de_dientes;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getEstado_de_dientes() {
        return estado_de_dientes;
    }

    public void setEstado_de_dientes(String estado_de_dientes) {
        this.estado_de_dientes = estado_de_dientes;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "sintomas='" + sintomas + '\'' +
                ", estado_de_dientes='" + estado_de_dientes + '\'' +
                '}';
    }
}
