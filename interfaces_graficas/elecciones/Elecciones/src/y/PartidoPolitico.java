package y;
import java.io.*;
import java.util.ArrayList;
public class PartidoPolitico {
	private String sigla,nombre;
	private boolean habilitado;
	//constructores
	public PartidoPolitico(String sigla, String nombre, boolean habilitado) {
		super();
		this.sigla = sigla;
		this.nombre = nombre;
		this.habilitado = habilitado;
	}
	public PartidoPolitico(String sigla, String nombre) {
		super();
		this.sigla = sigla;
		this.nombre = nombre;
		this.habilitado = true;
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
	
	public boolean registrarPartidoTxt(String archivo) {
		try {
			PrintWriter escritor = new PrintWriter(new FileWriter(archivo,true));// true incluye, si no esta lo sobreescribe
			String registro=this.sigla+";"+this.nombre+";"+this.habilitado;
			escritor.println(registro);
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	//leer partidos txt
	static ArrayList<PartidoPolitico> leerPartidosTxt(String archivo){
		ArrayList<PartidoPolitico> partidos =new ArrayList<PartidoPolitico>();
		try {
			BufferedReader lector= new BufferedReader(new FileReader(archivo));
			String linea;
			while((linea = lector.readLine())!=null) {
				String [] datos= linea.split(";");
				String sigla=datos[0];
				String nombre=datos[1];
				boolean habilitado= Boolean.parseBoolean(datos[2]);
				partidos.add(new PartidoPolitico(sigla,nombre,habilitado));
			}
			lector.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partidos;
	}
	static boolean reescribirPartido(ArrayList<PartidoPolitico> partidos, String archivo) {
		try {
			PrintWriter escritor = new PrintWriter(new FileWriter(archivo,true));
			for (PartidoPolitico pp : partidos) {
				String registro=pp.getSigla()+";"+pp.getNombre()+";"+pp.isHabilitado();
				escritor.println(registro);	
			}
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	/*ventana mod partido*/
	
}
