package y;

public class Recinto {
	private String nombre,ciudad,ubicacion;

	public Recinto(String nombre, String ciudad, String ubicacion) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", ciudad=" + ciudad + ", ubicacion=" + ubicacion;
	}
	
}
