package y;

public class Candidato extends Persona {
	private PartidoPolitico partido;

	public Candidato(int codigo, String nombre, String ci, String usurio, String password, PartidoPolitico partido) {
		super(codigo, nombre, ci, usurio, password);
		this.partido = partido;
	}

	public PartidoPolitico getPartido() {
		return partido;
	}

	public void setPartido(PartidoPolitico partido) {
		this.partido = partido;
	}

	@Override
	public String toString() {
		return this.getNombre() +"Candidato [partido=" + partido + "]";
	}
	
}
