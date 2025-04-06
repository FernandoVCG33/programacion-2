package z;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner nuevo= new Scanner(System.in);
		String team1,team2,est;
		System.out.print("Ingrese el equipo local: ");
		team1=nuevo.nextLine();
		System.out.print("Ingrese el equipo visitente: ");
		team2=nuevo.nextLine();
		System.out.print("Ingrese el estadio: ");
		est=nuevo.nextLine();
		Equipo team= new Equipo(team1);
		Equipo team_two= new Equipo(team2);
		Partido partidos= new Partido(12,03,2025,team,team_two,est);
		System.out.println(team.getNombreEquipo()+" VS "+ team_two.getNombreEquipo()+" "+ partidos.getLugar());
		team.addjugador();
		partidos.golLocal();
		partidos.golVisitante();
		partidos.golVisitante();
		partidos.golLocal();
		partidos.terminarPartido();
		partidos.mostrarMarcador();

	}

}
