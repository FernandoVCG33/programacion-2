package Dentista_;
import java.io.Serializable;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Paciente extends Persona  implements Archivos, Serializable{
	 private static final long serialVersionUID = 1L;
	private String sintomas ;
	private String estado_dientes ;
	
	public Paciente(String nombre, String ci, String sexo, int edad, String sintomas, String estado_dientes) {
		super(nombre, ci, sexo, edad);
		this.sintomas = sintomas;
		this.estado_dientes = estado_dientes;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getEstado_dientes() {
		return estado_dientes;
	}
	public void setEstado_dientes(String estado_dientes) {
		this.estado_dientes = estado_dientes;
	}
	@Override
	public String toString() {
		return "Paciente [sintomas: " + sintomas + ", estado_dientes: " + estado_dientes + "]";
	}
    public void actualizarEstadoDientes(String nuevoEstado) {
        this.estado_dientes = nuevoEstado;
    }

    public void agregarSintoma(String sintoma) {
        if (this.sintomas == null || this.sintomas.isEmpty()) {
            this.sintomas = sintoma;
        } else {
            this.sintomas += ", " + sintoma;
        }
    }

    public String generarHistoriaClinica() {
        return "Historia Clínica:\n" +
               "Paciente: " + getNombre() + "\n" +
               "CI: " + getCi() + "\n" +
               "Edad: " + getEdad() + "\n" +
               "Sexo: " + getSexo() + "\n" +
               "Síntomas: " + sintomas + "\n" +
               "Estado Dental: " + estado_dientes;
    }
    public void registrarEnArchivoTxt() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Archivos.registroPacientes, true))) {
            String linea = getNombre() + ";" +
                           getCi() + ";" +
                           getSexo() + ";" +
                           getEdad() + ";" +
                           sintomas + ";" +
                           estado_dientes;
            writer.write(linea);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar paciente en archivo TXT: " + e.getMessage());
        }
    }
    public static ArrayList<Paciente> leerDesdeArchivoTxt() {
        ArrayList<Paciente> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("registropacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length == 6) {
                    String nombre = partes[0];
                    String ci = partes[1];
                    String sexo = partes[2];
                    int edad = Integer.parseInt(partes[3]);
                    String sintomas = partes[4];
                    String estado = partes[5];

                    Paciente p = new Paciente(nombre, ci, sexo, edad, sintomas, estado);
                    lista.add(p);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo de pacientes: " + e.getMessage());
        }

        return lista;
    }   
    //
    public static void registrarBinario(Paciente paciente) {
        ArrayList<Paciente> lista = leerBinario(); // Leemos los pacientes actuales
        lista.add(paciente); // Añadimos el nuevo

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Archivos.registroPacienteBins))) {
            oos.writeObject(lista); // Guardamos la lista completa
        } catch (IOException e) {
            System.out.println("Error al registrar en binario: " + e.getMessage());
        }
    }
    
    public static ArrayList<Paciente> leerBinario() {
        ArrayList<Paciente> lista = new ArrayList<>();

        File archivo = new File(Archivos.registroPacienteBins);
        if (!archivo.exists()) return lista; // Si no existe, retornamos lista vacía

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (ArrayList<Paciente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer archivo binario: " + e.getMessage());
        }

        return lista;
    }
}
