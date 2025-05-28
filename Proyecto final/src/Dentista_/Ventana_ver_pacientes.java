package Dentista_;


import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class Ventana_ver_pacientes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> lista_pacientes;
    private DefaultListModel<String> modeloLista;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ventana_ver_pacientes frame = new Ventana_ver_pacientes();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ventana_ver_pacientes() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 797, 465);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Registro de pacientes");
        lblNewLabel.setBounds(247, 10, 289, 32);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 65, 743, 321);
        contentPane.add(scrollPane);

        modeloLista = new DefaultListModel<>();
        lista_pacientes = new JList<>(modeloLista);
        scrollPane.setViewportView(lista_pacientes);

        JButton btn_ver_pa = new JButton("Mostrar");
        btn_ver_pa.setBounds(20, 397, 85, 21);
        contentPane.add(btn_ver_pa);

        JButton btn_limpiar_p = new JButton("Limpiar");
        btn_limpiar_p.setBounds(125, 397, 85, 21);
        contentPane.add(btn_limpiar_p);

        // Acción del botón Mostrar: cargar y mostrar pacientes
        btn_ver_pa.addActionListener(e -> mostrarPacientes());

        // Acción del botón Limpiar: limpiar lista
        btn_limpiar_p.addActionListener(e -> modeloLista.clear());
    }

    private void mostrarPacientes() {
        modeloLista.clear(); // Limpiar antes de cargar
        ArrayList<Paciente> pacientes = Paciente.leerDesdeArchivoTxt();
        if (pacientes.isEmpty()) {
            modeloLista.addElement("No hay pacientes registrados o el archivo no se encontró.");
        } else {
            for (Paciente p : pacientes) {
                // Puedes usar p.toString() o p.generarHistoriaClinica()
                modeloLista.addElement(p.generarHistoriaClinica());
                modeloLista.addElement("--------------------------------------------------");
            }
        }
    }
}
