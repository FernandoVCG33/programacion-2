package d;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;





public class AlquilarCancha implements Parametros {
	private double cantidadHoras;
	private int horaInicio;
	private String nombre;
	private String cancha;
	
	
	
	public AlquilarCancha(double cantidadHoras, int horaInicio, String nombre, String cancha) {
		super();
		this.cantidadHoras = cantidadHoras;
		this.horaInicio = horaInicio;
		this.nombre = nombre;
		this.cancha = cancha;
	}
	

	public double getCantidadHoras() {
		return cantidadHoras;
	}


	public void setCantidadHoras(double cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}


	public int getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCancha() {
		return cancha;
	}


	public void setCancha(String cancha) {
		this.cancha = cancha;
	}
	

	@Override
	public String toString() {
		return "Cantidad de horas=" + cantidadHoras + ", hora de inicio=" + horaInicio + ", nombre: " + nombre+ ", canch: " + cancha ;
	}


	public boolean determinarDiaNoche() {
		if(this.horaInicio > Parametros.horalimite) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public double calcularCosto() {
		if (this.determinarDiaNoche()) {
			return  this.cantidadHoras * Parametros.costoHoraDia;
		}
		else {
			return this.cantidadHoras* Parametros.costoHoraNoche ;
		}
		
	}
	public boolean registrarTxt(String archivo) {
		try {
			PrintWriter escritor = new PrintWriter(new FileWriter(archivo,true));// true incluye, si no esta lo sobreescribe
			String registro=this.getCantidadHoras()+"#"+ this.getHoraInicio() +"#"+ this.getNombre() + "#" + this.getCancha() + "#" + this.calcularCosto()+"#"+ this.determinarDiaNoche() ;
			escritor.println(registro);
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	static ArrayList<AlquilarCancha> leerTxt(String archivo) {
	    ArrayList<AlquilarCancha> canchas = new ArrayList<AlquilarCancha>();
	    try {
	        BufferedReader lector = new BufferedReader(new FileReader(archivo));
	        String linea;
	        
	        // Leer cada línea del archivo
	        while ((linea = lector.readLine()) != null) {
	            String[] datos = linea.split("#");

	            // Asegurarse de que hay la cantidad correcta de datos
	            if (datos.length == 6) {
	                try {
	                    double cantidadH = Double.parseDouble(datos[0]); // código debe ser un número
	                    int horaI = Integer.parseInt(datos[1]);
	                    String name = datos[2];
	                    String cancha = datos[3];
	                    double costo = Double.parseDouble(datos[4]);
	                    boolean dia = Boolean.parseBoolean(datos[5]);
	                    // Crear el objeto Votante y agregarlo a la lista
	                    canchas.add(new AlquilarCancha(cantidadH, horaI, name, cancha)); //debe ser el nombre del array

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
	    return canchas;
	}
	
	public  double totalGanado(String archivo) {
	    double total = 0.0;

	    try {
	        BufferedReader lector = new BufferedReader(new FileReader(archivo));
	        String linea;

	        while ((linea = lector.readLine()) != null) {
	            String[] datos = linea.split("#");

	            if (datos.length == 6) {
	                try {
	                    double costo = Double.parseDouble(datos[4]); // El costo está en la posición 4
	                    total += costo;
	                } catch (NumberFormatException e) {
	                    System.out.println("Error al convertir el costo: " + datos[4]);
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
	    return total;
	}
	//escribe binario
	public void escribe(String archivo) throws IOException {
	    // TODO Auto-generated method stub
	    DataOutputStream fileout = new DataOutputStream(new FileOutputStream(archivo,true));
	  
	    fileout.writeDouble( this.cantidadHoras);
	    fileout.writeInt(this.horaInicio );
	    fileout.writeUTF(this.nombre);
	    fileout.writeUTF(this.cancha);
	    fileout.writeInt((int) this.calcularCosto());
	    fileout.writeBoolean((boolean) this.determinarDiaNoche());
	    fileout.close();
	}
	
	//lee binario
	public void leebin(String archivo) throws IOException {
	    // TODO Auto-generated method stub
	    DataInputStream filein = new DataInputStream(new FileInputStream(archivo));
	    
	    while(filein.available()!=0){
	    	double cant= filein.readDouble();
	    	int horai=  filein.readInt();
	    	String names= filein.readUTF();
	    	String canchas= filein.readUTF();
	    	int costos=  filein.readInt();
	    	boolean diaDN= filein.readBoolean();
	    	//que mas ??
	    	
	        
	    }
	    JTextArea jta = new JTextArea();
	    JOptionPane.showMessageDialog(null, jta);
	    filein.close();
	}
	
}
