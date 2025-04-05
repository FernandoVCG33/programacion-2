package s;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner nuevo= new Scanner(System.in);
		Scanner nuev2= new Scanner(System.in);
		int n,nmO,nmP,nmB;
		String pais10;
		
		System.out.print("Ingrese un numero: ");
		n=nuevo.nextInt();
		int [] mem= new int[3];
		ArrayList<MedallasPais>paices2=new ArrayList<MedallasPais>();
		for(int i=0;i<n;i++) {
			System.out.print("Ingrese un pais: ");
			pais10=nuev2.nextLine();
			System.out.print("Ingrese el nro de medallas de oro : ");
			nmO=nuevo.nextInt();
			System.out.print("Ingrese el nro de medallas de plata : ");
			nmP=nuevo.nextInt();
			System.out.print("Ingrese el nro de medallas de bronce : ");
			nmB=nuevo.nextInt();
			MedallasPais prueba= new MedallasPais(pais10,nmO,nmP,nmB);
			paices2.add(prueba);
		}
		System.out.println("Pais con mas medallas: "+ MedallasPais.paisConMasMedallas(paices2) );
		System.out.println("\nMedallas en la posición 0:");
	    if (n > 0) {
	       System.out.println(paices2.get(0));
	    }

	    System.out.println("\nMedallas en la posición n/2:");
	    if (n > 1) {
	       int mitad = n / 2;
	       System.out.println(paices2.get(mitad));
	    }

	    System.out.println("\nMedallas en la posición n-1:");
	    if (n > 0) {
	       System.out.println(paices2.get(n - 1));
	    }
	    //Pais pocision 0 gano una medalla de bronce
	    paices2.get(0).ganoMedallaBronce();
	    paices2.get(n/2).ganoMedallaOro();
	    paices2.get(n-1).ganoMedallaPlata();
	    System.out.println("\tACTUALIZACION");
	    System.out.println("\nMedallas en la posición 0:");
	    if (n > 0) {
	       System.out.println(paices2.get(0));
	    }

	    System.out.println("\nMedallas en la posición n/2:");
	    if (n > 1) {
	       int mitad = n / 2;
	       System.out.println(paices2.get(mitad));
	    }

	    System.out.println("\nMedallas en la posición n-1:");
	    if (n > 0) {
	       System.out.println(paices2.get(n - 1));
	    }
	    System.out.println("Total de medallas otorgadas por los JJOO: "+ MedallasPais.totalDeMedallasOtorgadas(paices2));
	    System.out.println("Pais con menos medallas: "+ MedallasPais.paisConMemosMedallas(paices2));
	    System.out.println("Pais con mas medallas: "+ MedallasPais.paisConMasMedallas(paices2));
	    String paisConMasOro = MedallasPais.paisConMasMedallasOro(paices2);

	    // Buscar el objeto correspondiente en la lista
	    for (MedallasPais mp : paices2) {
	        if (mp.getPais().equals(paisConMasOro)) {
	            System.out.println("\nPaís con más medallas de oro:");
	            System.out.println(mp); // Mostrar todas las medallas obtenidas por ese país
	            break;
	        }
	    }
	    System.out.println("-----------------------------------------");
	    MedallasPais.total(paices2, mem);

	}

}
