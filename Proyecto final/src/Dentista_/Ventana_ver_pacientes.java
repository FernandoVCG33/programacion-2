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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_ver_pacientes extends JFrame implements Archivos {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> lista_pacientes;
    private JList<String> listaBIN;  // Corregido: declarado aquí como JList<String>
    private DefaultListModel<String> modeloLista;
    private DefaultListModel<String> modeloListaBin;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana_ver_pacientes frame = new Ventana_ver_pacientes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
        scrollPane.setBounds(10, 65, 387, 321);
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

        JScrollPane scrollBin = new JScrollPane();
        scrollBin.setBounds(424, 65, 349, 321);
        contentPane.add(scrollBin);

        modeloListaBin = new DefaultListModel<>();

        // CORREGIDO: asociar el modelo al JList
        listaBIN = new JList<>(modeloListaBin);
        scrollBin.setViewportView(listaBIN);

        JButton Mostrar_bin = new JButton("Mostrar");
        Mostrar_bin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloListaBin.clear();
                ArrayList<Paciente> pacientesBin = Paciente.leerBinario();

                if (pacientesBin.isEmpty()) {
                    modeloListaBin.addElement("No hay pacientes en binario o el archivo está vacío.");
                } else {
                    for (Paciente p : pacientesBin) {
                        modeloListaBin.addElement(p.generarHistoriaClinica());
                        modeloListaBin.addElement("--------------------------------------------------");
                    }
                }
            }
        });

        Mostrar_bin.setBounds(434, 397, 85, 21);
        contentPane.add(Mostrar_bin);

        // Botón Mostrar para archivo TXT
        btn_ver_pa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloLista.clear();
                ArrayList<Paciente> pacientes = Paciente.leerDesdeArchivoTxt();

                if (pacientes.isEmpty()) {
                    modeloLista.addElement("No hay pacientes registrados o el archivo no se encontró.");
                } else {
                    for (Paciente p : pacientes) {
                        modeloLista.addElement(p.generarHistoriaClinica());
                        modeloLista.addElement("--------------------------------------------------");
                    }
                }
            }
        });

        // Botón Limpiar
        btn_limpiar_p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloLista.clear();
            }
        });
    }
}