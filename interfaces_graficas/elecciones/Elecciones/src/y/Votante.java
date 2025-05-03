package y;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Votante extends Persona {
	private Recinto recinto;
	private boolean habilitado;
	public Votante(int codigo, String nombre, String ci, String usurio, String password, Recinto recinto) {
		super(codigo, nombre, ci, usurio, password);
		this.recinto = recinto;
		this.habilitado = true;
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
	
	public boolean registrarVotanteTxt(String archivo) {
		try {
			PrintWriter escritor = new PrintWriter(new FileWriter(archivo,true));// true incluye, si no esta lo sobreescribe
			String registro=this.getCodigo()+";"+ this.getUsurio() +";"+ this.getCi() + ";" + this.getNombre() + ";" + this.getPassword()+";"+ this.recinto ;
			escritor.println(registro);
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	//leer recintos txt
	static ArrayList<Votante> leerRecintosTxt(String archivo){
		ArrayList<Votante> votantes = new ArrayList<Votante>();
		try {
			BufferedReader lector= new BufferedReader(new FileReader(archivo));
			String linea;
			while((linea = lector.readLine())!=null) {
				String [] datos= linea.split(";");
				int codigo = Integer.parseInt(datos[0]);
				String nombre = datos[1];
				String ci = datos[2];
				String usuario = datos[3];
				String password = datos[4];
				Recinto recinto = new Recinto(datos[5],datos[5],datos[5]); // suponiendo un constructor válido
				boolean habilitado = Boolean.parseBoolean(datos[6]);
				votantes.add(new Votante(codigo, nombre, ci, usuario, password, recinto));

			}
			lector.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return votantes;
	}
}
