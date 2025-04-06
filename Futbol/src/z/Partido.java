package z;

import java.time.LocalDate;


public class Partido{
	LocalDate fecha1;
	private Equipo local;
    private Equipo visitante;
    private String lugar;
    private int golesLocal;
    private int golesVisitante;
    //Constructor
	public Partido(int d,int m , int y, Equipo local, Equipo visitante, String lugar) {	
		this.fecha1 = LocalDate.of(y, m, d);
		this.local = local;
		this.visitante = visitante;
		this.lugar = lugar;
		this.golesLocal = 0;
		this.golesVisitante =0;
	}
    //getter y setter
	public LocalDate getFecha1() {
		return fecha1;
	}
	public void setFecha1(LocalDate fecha1) {
		this.fecha1 = fecha1;
	}
	public Equipo getLocal() {
		return local;
	}
	public void setLocal(Equipo local) {
		this.local = local;
	}
	public Equipo getVisitante() {
		return visitante;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public int getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	//ToString
	@Override
	public String toString() {
		return "Partido [fecha1=" + fecha1 + ", local=" + local.getNombreEquipo() +" vs "+ ", visitante=" + visitante.getNombreEquipo()+ ", lugar=" + lugar
				+ ", golesLocal=" + golesLocal + ", golesVisitante=" + golesVisitante + "]";
	}
	void golLocal() {
		this.golesLocal++;
	}
	void golVisitante() {
		this.golesVisitante++;
	}
	void terminarPartido() {
		local.ingrementarGoles(golesLocal, golesVisitante);
		visitante.ingrementarGoles(golesVisitante, golesLocal);
		local.incrementarPartidosJUgados();
		visitante.incrementarPartidosJUgados();
		if (golesLocal>golesVisitante) {
			local.incrementarPartidosGanados();
			visitante.incrementarPartidosperdidos();
		}
		else if(golesLocal<golesVisitante) {
			visitante.incrementarPartidosGanados();
			local.incrementarPartidosperdidos();
		}
		else {
			local.incrementarPartidosEmpatados();
			visitante.incrementarPartidosEmpatados();
		}
	}
	public void mostrarMarcador() {
		System.out.println(local.getNombreEquipo()+ " "+ golesLocal+ " vs "+ visitante.getNombreEquipo()+" "+ golesVisitante);
	}
	
}

