package a;

import java.io.*;
import java.util.ArrayList;


public class ArchivoEstudiantes {

    public static void escribirTexto(Estudiantes e) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(Archivos.RUTA_TEXTO, true));
        bw.write(e.getRegistro());
        bw.newLine();
        bw.close();
    }

    public static ArrayList<Estudiantes> leerTexto() throws IOException {
        ArrayList<Estudiantes> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(Archivos.RUTA_TEXTO));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split("#");
            Estudiantes e = new Estudiantes(datos[0], datos[1], Double.parseDouble(datos[2]),
                                          Double.parseDouble(datos[3]), Double.parseDouble(datos[4]));
            lista.add(e);
        }
        br.close();
        return lista;
    }

    public static void escribirBinario(ArrayList<Estudiantes> lista) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Archivos.RUTA_BINARIO));
        oos.writeObject(lista);
        oos.close();
    }

    public static ArrayList<Estudiantes> leerBinario() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Archivos.RUTA_BINARIO));
        ArrayList<Estudiantes> lista = (ArrayList<Estudiantes>) ois.readObject();
        ois.close();
        return lista;
    }
}
