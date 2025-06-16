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
    private JList<String> listaBIN;
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
        setBounds(400, 100, 926, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Registro de pacientes");
        lblNewLabel.setBounds(247, 10, 289, 32);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 105, 422, 352);
        contentPane.add(scrollPane);

        modeloLista = new DefaultListModel<>();
        lista_pacientes = new JList<>(modeloLista);
        scrollPane.setViewportView(lista_pacientes);

        JScrollPane scrollBin = new JScrollPane();
        scrollBin.setBounds(453, 105, 434, 352);
        contentPane.add(scrollBin);

        modeloListaBin = new DefaultListModel<>();  // Inicializado correctamente
        listaBIN = new JList<>(modeloListaBin);
        scrollBin.setViewportView(listaBIN);

        JButton btn_ver_pa = new JButton("Mostrar");
        btn_ver_pa.setBackground(new Color(192, 192, 192));
        btn_ver_pa.setBounds(10, 467, 123, 36);
        contentPane.add(btn_ver_pa);

        JButton btn_limpiar_p = new JButton("Limpiar");
        btn_limpiar_p.setBackground(new Color(255, 128, 64));
        btn_limpiar_p.setBounds(160, 467, 103, 36);
        contentPane.add(btn_limpiar_p);

        JButton Mostrar_bin = new JButton("Mostrar");
        Mostrar_bin.setBackground(new Color(192, 192, 192));
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
        Mostrar_bin.setBounds(451, 467, 111, 36);
        contentPane.add(Mostrar_bin);

        JButton btn_limpiar_binario = new JButton("Limpiar");
        btn_limpiar_binario.setBackground(new Color(255, 128, 64));
        btn_limpiar_binario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloListaBin.clear();
            }
        });
        btn_limpiar_binario.setBounds(598, 467, 103, 36);
        contentPane.add(btn_limpiar_binario);

        JLabel lblNewLabel_1 = new JLabel("Mayores de edad");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(10, 74, 185, 21);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Menores de edad");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2.setBounds(453, 74, 137, 21);
        contentPane.add(lblNewLabel_2);

        // Acción para botón Mostrar pacientes (TXT)
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

        // Acción para botón Limpiar pacientes (TXT)
        btn_limpiar_p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloLista.clear();
            }
        });
    }
}
