package Dentista_;

import java.io.Serializable;

public abstract class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
    private String nombre, ci, sexo;
    private int edad;

    public Persona(String nombre, String ci, String sexo, int edad) {
        this.nombre = nombre;
        this.ci = ci;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método obligatorio para las subclases
    public abstract String mostrarInformacion();

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", ci=" + ci + ", sexo=" + sexo + ", edad=" + edad + "]";
    }
}
