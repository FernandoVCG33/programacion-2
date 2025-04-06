package z;
import java.time.LocalDate;

public class Jugador{
	private String nombre;
	private int dorsal;
	LocalDate fechaNacimiento; /*aprende a usar esta cosa*/
	private boolean habilitado;
	//Constructor
	public Jugador(String nombre, int dorsal,int dia, int mes,int year) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.habilitado = true;
		this.fechaNacimiento=LocalDate.of(year, mes, dia);
	}
	//getters an settters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	//ToString
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", dorsal=" + dorsal + ", habilitado=" + habilitado + "]";
	}
	
}

