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
	public Votante(int codigo, String nombre, String ci, String usurio, String password) {
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
	    return this.getNombre() + " " + this.getCi() + " Votante [recinto=" + recinto + ", habilitado=" + habilitado + "]";
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
	static ArrayList<Votante> leerVotanteTxt(String archivo) {
	    ArrayList<Votante> votantes = new ArrayList<Votante>();
	    try {
	        BufferedReader lector = new BufferedReader(new FileReader(archivo));
	        String linea;
	        
	        // Leer cada línea del archivo
	        while ((linea = lector.readLine()) != null) {
	            String[] datos = linea.split(";");

	            // Asegurarse de que hay la cantidad correcta de datos
	            if (datos.length == 7) {
	                try {
	                    int codigo = Integer.parseInt(datos[0]); // código debe ser un número
	                    String nombre = datos[1];
	                    String ci = datos[2];
	                    String usuario = datos[3];
	                    String password = datos[4];
	                    Recinto recinto = new Recinto(datos[5], datos[5], datos[5]); // Crear el objeto Recinto
	                    boolean habilitado = Boolean.parseBoolean(datos[6]);

	                    // Crear el objeto Votante y agregarlo a la lista
	                    votantes.add(new Votante(codigo, nombre, ci, usuario, password));

	                } catch (NumberFormatException e) {
	                    System.out.println("Error al convertir datos numéricos: " + linea);
	                } catch (Exception e) {
	                    System.out.println("Error al leer la línea: " + linea);
	                    e.printStackTrace();
	                }
	            } else {
	                System.out.println("Línea mal formateada: " + linea);
	            }
	        }

	        lector.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Error al leer el archivo");
	    }
	    return votantes;
	}

}
