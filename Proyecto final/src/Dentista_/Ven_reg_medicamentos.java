package Dentista_;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ven_reg_medicamentos extends JFrame implements Archivos {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDescripcion;
    private JTextField txtMedicamento;
    private JTextField txtFecha;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ven_reg_medicamentos frame = new Ven_reg_medicamentos();
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
    public Ven_reg_medicamentos() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 560, 405);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Registro de medicamentos ");
        lblTitulo.setBounds(113, 10, 315, 32);
        lblTitulo.setBackground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitulo.setForeground(Color.WHITE);
        contentPane.add(lblTitulo);

        JLabel lblDescripcion = new JLabel("Descripcion ");
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDescripcion.setForeground(Color.WHITE);
        lblDescripcion.setBounds(160, 52, 137, 26);
        contentPane.add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(160, 88, 214, 39);
        contentPane.add(txtDescripcion);
        txtDescripcion.setColumns(10);

        JLabel lblNombreMed = new JLabel("Nombre del medicamento");
        lblNombreMed.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombreMed.setForeground(Color.WHITE);
        lblNombreMed.setBounds(160, 137, 198, 13);
        contentPane.add(lblNombreMed);

        txtMedicamento = new JTextField();
        txtMedicamento.setBounds(160, 160, 214, 39);
        contentPane.add(txtMedicamento);
        txtMedicamento.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha de caducidad");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setBounds(160, 209, 198, 13);
        contentPane.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(160, 232, 214, 39);
        txtFecha.setEditable(false); // Ya que usamos la fecha actual
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);
        txtFecha.setText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date())); // Mostrar fecha actual

        JButton btn_reg_med = new JButton("Registrar");
        btn_reg_med.setBackground(new Color(192, 192, 192));
        btn_reg_med.setBounds(160, 305, 101, 21);
        contentPane.add(btn_reg_med);

        JButton btn_cancelar = new JButton("Cancelar");
        btn_cancelar.setBackground(new Color(192, 192, 192));
        btn_cancelar.setBounds(290, 305, 85, 21);
        contentPane.add(btn_cancelar);

        // Acción del botón Registrar
        btn_reg_med.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String descripcion = txtDescripcion.getText().trim();
                String medicamento = txtMedicamento.getText().trim();

                if (descripcion.isEmpty() || medicamento.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                    return;
                }

                Receta receta = new Receta(descripcion, medicamento);
                receta.registrarRecetaTxt(Archivos.registroReecetas  );
                	
                JOptionPane.showMessageDialog(null, "Receta registrada exitosamente.");
                txtDescripcion.setText("");
                txtMedicamento.setText("");
                txtFecha.setText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
            }
        });

        // Acción del botón Cancelar
        btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}

