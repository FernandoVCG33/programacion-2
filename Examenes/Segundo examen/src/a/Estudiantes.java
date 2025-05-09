package a;

public class Estudiantes {
    private String codigo, nombre;
    private double nota1, nota2, nota3, promedio;
    private String estado;

    public Estudiantes(String codigo, String nombre, double nota1, double nota2, double nota3) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        calcularPromedio();
        calcularEstado();
    }

    private void calcularPromedio() {
        promedio = (nota1 + nota2 + nota3) / 3;
    }

    private void calcularEstado() {
        estado = (promedio >= 51) ? "Aprobado" : "Reprobado";
    }

    public String getRegistro() {
        return codigo + "#" + nombre + "#" + nota1 + "#" + nota2 + "#" + nota3 + "#" + promedio + "#" + estado;
    }

    public double getPromedio() {
        return promedio;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return getRegistro();
    }
}
