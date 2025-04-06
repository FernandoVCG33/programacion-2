package z;

import java.time.*;
import java.util.*;
public class Equipo {
	private String nombreEquipo;
	private ArrayList<Jugador> cantidadJugadores;
	private	int partidosganados;
	private	int partidosJugados;
	private	int partidosEmpatados;
	private	int partidosPerdidos;
	private	int golesFavor;
	private	int golesContra;
	
	//constructor
	public Equipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
		this.cantidadJugadores = new ArrayList<Jugador>();
		this.partidosganados = 0;
		this.partidosJugados = 0;
		this.partidosEmpatados = 0;
		this.partidosPerdidos = 0;
		this.golesFavor = 0;
		this.golesContra = 0;
	}
	
	
	//Getter y setters
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}


	public ArrayList<Jugador> getCantidadJugadores() {
		return cantidadJugadores;
	}


	public void setCantidadJugadores(ArrayList<Jugador> cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}


	public int getPartidosganados() {
		return partidosganados;
	}


	public void setPartidosganados(int partidosganados) {
		this.partidosganados = partidosganados;
	}


	public int getPartidosJugados() {
		return partidosJugados;
	}


	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}


	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}


	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}


	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}


	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	

	public int getGolesFavor() {
		return golesFavor;
	}


	public void setGolesFavor(int golesFavor) {
		this.golesFavor = golesFavor;
	}


	public int getGolesContra() {
		return golesContra;
	}


	public void setGolesContra(int golesContra) {
		this.golesContra = golesContra;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	//ToString
	@Override
	public String toString() {
		return "Equipo [nombreEquipo=" + nombreEquipo + ", cantidadJugadores=" + cantidadJugadores
				+ ", partidosganados=" + partidosganados + ", partidosJugados=" + partidosJugados
				+ ", partidosEmpatados=" + partidosEmpatados + ", partidosPerdidos=" + partidosPerdidos
				+ ", golesFavor=" + golesFavor + ", golesContra=" + golesContra + "]";
	}
	



	//Add jugador
	public void addjugador() {
		System.out.println("----------------------");
		int dorsal=0,d,m,y;
		Scanner nuevo = new Scanner(System.in);
		Scanner nuevo2 = new Scanner(System.in);
		String nombre;
		System.out.print("Ingrese el nombre del jugador: ");
		nombre=  nuevo.nextLine() ;
		System.out.print("Ingrese el dorsal del jugador: ");
		dorsal=  nuevo2.nextInt();
		System.out.print("Ingrese el dia de nacimiento: ");
		d=  nuevo2.nextInt();
		System.out.print("Ingrese el mes de nacimiento: ");
		m=  nuevo2.nextInt();
		System.out.print("Ingrese el año de nacimiento: ");
		y=  nuevo2.nextInt();
		
		cantidadJugadores.add(new Jugador(nombre,dorsal,d,m,y));
		
	}
	public void mostrarJugador() {
		for (Jugador jugador : cantidadJugadores) {
			System.out.println(jugador);
		}
	}
	public void incrementarPartidosGanados() {
		this.partidosganados++;
	}
	public void incrementarPartidosperdidos() {
		this.partidosPerdidos++;
	}
	public void incrementarPartidosEmpatados() {
		this.partidosEmpatados++;
	}
	public void incrementarPartidosJUgados() {
		this.partidosJugados++;
	}
	public void ingrementarGoles(int golesFavor,int golesContra) {
		this.golesFavor+= golesFavor;
		this.golesContra+= golesContra ;
	}
}