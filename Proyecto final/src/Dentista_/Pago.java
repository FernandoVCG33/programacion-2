package Dentista_;
import java.util.Date;
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
}
