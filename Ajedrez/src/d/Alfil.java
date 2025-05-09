package d;

import java.util.ArrayList;



public class Alfil extends Pieza implements Movimientos {
    public Alfil(String nombrePieza, String colorPieza, int pocision) {
        super(nombrePieza, colorPieza, pocision);
    }

    @Override
    public String obtenerPosicion() {
        this.getColumna();
        this.getFila();
        String a;
        if(this.getFila()==8){
            a = "0";
        }
        else if (this.getFila()==7) {
            a ="1";
        }
        else if (this.getFila()==6) {
            a ="2";
        }
        else if (this.getFila()==5) {
            a ="3";
        }
        else if (this.getFila()==4) {
            a ="4";
        }
        else if (this.getFila()==3) {
            a ="5";
        }
        else if (this.getFila()==2) {
            a ="6";
        }
        else{
            a= "7";
        }
        String ax2="";
        if(this.getColumna() == 0 ){
            ax2= "a";
        }
        else if (this.getColumna() ==1) {
            ax2= "b";
        }
        else if (this.getColumna() ==2) {
            ax2= "c";
        }
        else if (this.getColumna() ==3) {
            ax2= "d";
        }
        else if (this.getColumna() ==4) {
            ax2= "e";
        }
        else if (this.getColumna() ==5) {
            ax2= "f";
        }
        else if (this.getColumna() ==6) {
            ax2= "g";
        }
        else{
            ax2= "h";
        }
        String nota= ax2+a;
        return nota;
    }

    @Override
    public void mostrarPosiblesMovimientos(ArrayList<Pieza> piezas) {
        System.out.println("Movimientos posibles del Alfil:");
        moverEnDireccion(piezas, 1, 1);
        moverEnDireccion(piezas, -1, -1);
        moverEnDireccion(piezas, 1, -1);
        moverEnDireccion(piezas, -1, 1);
    }

    @Override
    public boolean jaque(ArrayList<Pieza> piezas) {
        for (Pieza pieza : piezas) {
            if (pieza instanceof Rey && !pieza.getColorPieza().equals(this.getColorPieza())) {
                int difFila = Math.abs(this.getFila() - pieza.getFila());
                int difColumna = Math.abs(this.getColumna() - pieza.getColumna());

                if (difFila == difColumna) {
                    return true;  // El alfil puede capturar en diagonal
                }
            }
        }
        return false;
    }
}
