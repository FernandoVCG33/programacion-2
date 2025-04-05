package s;

import java.util.ArrayList;


public class MedallasPais {
	private String pais; //private solo para ver los atributos en la clase
	private int medallasOro,medallasPlata,medallasBronce;
	//1 Constructores
	public MedallasPais(String pais, int medallasOro, int medallasPlata, int medallasBronce) {
		super();
		this.pais = pais;
		this.medallasOro = medallasOro;
		this.medallasPlata = medallasPlata;
		this.medallasBronce = medallasBronce;
	}
	public MedallasPais(String nombre) {
        this(nombre, 0, 0, 0);
    }
	//2 getters
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getMedallasOro() {
		return medallasOro;
	}
	public void setMedallasOro(int medallasOro) {
		this.medallasOro = medallasOro;
	}
	public int getMedallasPlata() {
		return medallasPlata;
	}
	public void setMedallasPlata(int medallasPlata) {
		this.medallasPlata = medallasPlata;
	}
	public int getMedallasBronce() {
		return medallasBronce;
	}
	public void setMedallasBronce(int medallasBronce) {
		this.medallasBronce = medallasBronce;
	}
	//3 ToString
	@Override
	public String toString() {
		return " pais= " + pais + ", medallas de oro= " + medallasOro + ", medallas de plata= " + medallasPlata+ ", medallas de bronce= " + medallasBronce;
	}
	//4 Incrementar medallas de oro
	public void ganoMedallaOro() {
		medallasOro++;
	}
	//5 Ingrementar medallas de plata y bronce
	public void ganoMedallaPlata() {
		medallasPlata++;
	}
	public void ganoMedallaBronce() {
		medallasBronce++;
	}
	//6 Retornar el total de medallas ganadas
	public  int totalMedallasGanadas() {
		return medallasOro + medallasPlata + medallasBronce;
	}
	//7  Total de  medallas otorgadas en en los JJOO
	static int totalDeMedallasOtorgadas( ArrayList<MedallasPais> paices ) {
		int total=0;
		for (MedallasPais mp : paices) {
			total+= mp.totalMedallasGanadas()  ;
		}
		return total;
	}
	//8 nombre del país con más medallas en los JJOO
	static String paisConMasMedallas( ArrayList<MedallasPais> paices ) {
		MedallasPais maxPais = paices.get(0);
		for (MedallasPais mp : paices) {
			if( mp.totalMedallasGanadas() > maxPais.totalMedallasGanadas()) {
				maxPais=mp;
			}
		}
		return maxPais.getPais();
	}
	//9 nombre del país con menos medallas en los JJOO
	public static String paisConMemosMedallas( ArrayList<MedallasPais> paices ) {
		MedallasPais minPais = paices.get(0);
		for (MedallasPais mp : paices) {
			if( mp.totalMedallasGanadas() < minPais.totalMedallasGanadas()) {
				minPais=mp;
			}
		}
		return minPais.getPais();
	}
	//10 nombre del país con más medallas de ORO en los JJOO
	static String paisConMasMedallasOro( ArrayList<MedallasPais> paices ) {
		MedallasPais maxPaisO = paices.get(0);
		for (MedallasPais mp : paices) {
			if( mp.medallasOro>maxPaisO.medallasOro ) {
				maxPaisO=mp;
			}
		}
		return  maxPaisO.getPais() ;
	}
	//11 El metodo realizara el conteo de medallas de oro otorgadas en los JJOO y lo colocará en la primero posición
	static void total( ArrayList<MedallasPais> paices, int[] mem ) {
		int contO=0,contP=0,contB=0;
		for (MedallasPais mp : paices) {
			contO+=mp.medallasOro;
			contP+=mp.medallasPlata;
			contB+=mp.medallasBronce;
		}
		mem[0]=contO;
		mem[1]=contP;
		mem[2]=contB;
		System.out.println("Oro: "+ contO+ " plata: " + contP + " bronce: "+contB);
	}
	
}
