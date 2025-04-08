package y;

public class Persona {
	private int codigo;
	private String nombre,ci,usurio,password;
	public Persona(int codigo, String nombre, String ci, String usurio, String password) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ci = ci;
		this.usurio = usurio;
		this.password = password;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public String getUsurio() {
		return usurio;
	}
	public void setUsurio(String usurio) {
		this.usurio = usurio;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombre=" + nombre + ", ci=" + ci + ", usurio=" + usurio + ", password="
				+ password + "]";
	}
	
}
