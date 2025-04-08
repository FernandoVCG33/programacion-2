package y;

public class PartidoPolitico {
	private String sigla,nombre;
	private boolean habilitado;
	//constructor
	public PartidoPolitico(String sigla, String nombre, boolean habilitado) {
		super();
		this.sigla = sigla;
		this.nombre = nombre;
		this.habilitado = habilitado;
	}
	//setter and getters
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	//toString
	@Override
	public String toString() {
		return "Nombre" + nombre + ", habilitado=" + habilitado ;
	}
	
}
