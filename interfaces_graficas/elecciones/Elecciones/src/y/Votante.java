package y;

public class Votante extends Persona {
	private Recinto recinto;
	private boolean habilitado;
	public Votante(int codigo, String nombre, String ci, String usurio, String password, Recinto recinto,
			boolean habilitado) {
		super(codigo, nombre, ci, usurio, password);
		this.recinto = recinto;
		this.habilitado = habilitado;
	}
	public Recinto getRecinto() {
		return recinto;
	}
	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	@Override
	public String toString() {
		return  this.getNombre() +" "+this.getCi()  +"Votante [recinto=" + recinto + ", habilitado=" + habilitado + "]";
	}
	
}
