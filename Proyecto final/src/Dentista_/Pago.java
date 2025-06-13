package Dentista_;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class Pago {
    private double monto;
    private String metodo; // Ej: Efectivo, Tarjeta, Transferencia
    private Date fecha;
    private String concepto;

    // Constructor
    public Pago(double monto, String metodo, String concepto) {
        this.monto = monto;
        this.metodo = metodo;
        this.concepto = concepto;
        this.fecha = new Date(); // fecha actual
    }

    // Getters y setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto >= 0) {
            this.monto = monto;
        }
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String obtenerFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    // Método para mostrar recibo de pago
    public String mostrarPago() {
        return "=== Comprobante de Pago ===\n" +
               "Fecha: " + obtenerFechaFormateada() + "\n" +
               "Concepto: " + concepto + "\n" +
               "Método: " + metodo + "\n" +
               "Monto: $" + monto;
    }
    public boolean registrarPagoTxt(String archivo) {
        try {
            PrintWriter escritor = new PrintWriter(new FileWriter(archivo, true));
            String linea = this.monto + ";" + this.metodo + ";" + this.concepto + ";" + this.obtenerFechaFormateada();
            escritor.println(linea);
            escritor.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    
    public static ArrayList<Pago> leerPagosDesdeTxt(String archivo) {
        ArrayList<Pago> lista = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    double monto = Double.parseDouble(partes[0]);
                    String metodo = partes[1];
                    String concepto = partes[2];
                    // La fecha no se guarda realmente porque usamos la actual
                    Pago p = new Pago(monto, metodo, concepto);
                    lista.add(p);
                }
            }

            lector.close();
        } catch (IOException e) {
            // manejo simple, como lo pide la universidad
        }

        return lista;
    }

}
