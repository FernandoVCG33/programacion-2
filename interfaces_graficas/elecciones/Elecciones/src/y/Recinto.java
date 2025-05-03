package y;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	public boolean registrarRecintoTxt(String archivo) {
		try {
			PrintWriter escritor = new PrintWriter(new FileWriter(archivo,true));// true incluye, si no esta lo sobreescribe
			String registro=this.nombre+";"+this.ciudad+";"+this.ubicacion;
			escritor.println(registro);
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	//leer recintos txt
	static ArrayList<Recinto> leerRecintosTxt(String archivo){
		ArrayList<Recinto> recintos =new ArrayList<Recinto>();
		try {
			BufferedReader lector= new BufferedReader(new FileReader(archivo));
			String linea;
			while((linea = lector.readLine())!=null) {
				String [] datos= linea.split(";");
				String nombre=datos[0];
				String ciudad=datos[1];
				String ubicacion= datos[2];
				recintos.add(new Recinto(nombre,ciudad,ubicacion));
			}
			lector.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recintos;
	}
	
	static boolean reescribirRecinto(ArrayList<Recinto> recintos, String archivo) {
		try {
			PrintWriter escritor = new PrintWriter(new FileWriter(archivo,true));
			for (Recinto rr : recintos) {
				String registro=rr.getNombre()+";"+rr.getCiudad()+";"+rr.getUbicacion();
				escritor.println(registro);	
			}
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}
