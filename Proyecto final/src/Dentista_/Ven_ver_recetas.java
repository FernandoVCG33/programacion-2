package Dentista_;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ven_ver_recetas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<String> modeloLista;
    private JList<String> lista_recetas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ven_ver_recetas frame = new Ven_ver_recetas();
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
    public Ven_ver_recetas() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 773, 456);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Registro de recetas");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(247, 10, 259, 72);
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 73, 711, 266);
        contentPane.add(scrollPane);

        modeloLista = new DefaultListModel<>();
        lista_recetas = new JList<>(modeloLista);
        scrollPane.setViewportView(lista_recetas);

        JButton btnmos = new JButton("Mostrar");
        btnmos.setBounds(153, 353, 187, 42);
        contentPane.add(btnmos);

        JButton btnlimpiar = new JButton("Limpiar");
        btnlimpiar.setBounds(388, 353, 163, 42);
        contentPane.add(btnlimpiar);

        // Acción del botón "Mostrar"
        btnmos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloLista.clear();
                ArrayList<Receta> recetas = Receta.leerRecetasDesdeTxt(Archivos.registroReecetas);

                if (recetas.isEmpty()) {
                    modeloLista.addElement("No hay recetas registradas o no se pudo leer el archivo.");
                } else {
                    for (Receta r : recetas) {
                        modeloLista.addElement(r.mostrarReceta());
                        modeloLista.addElement("--------------------------------------------------");
                    }
                }
            }
        });

        // Acción del botón "Limpiar"
        btnlimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloLista.clear();
            }
        });
    }
}

