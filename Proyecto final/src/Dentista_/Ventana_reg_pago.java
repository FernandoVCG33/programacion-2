package Dentista_;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_reg_pago extends JFrame implements Archivos {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;     // Monto
	private JTextField textField_1;   // Método
	private JTextField textField_2;   // Fecha (opcional visual, pero no usada)
	private JTextArea textArea;       // Concepto

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_reg_pago frame = new Ventana_reg_pago();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana_reg_pago() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 568, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registrar pago");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(185, 10, 237, 55);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Monto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(151, 95, 106, 20);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(151, 125, 227, 37);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Metodo de pago");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(151, 180, 131, 20);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(151, 211, 227, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(151, 258, 106, 20);
		contentPane.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
		textField_2.setBounds(151, 288, 227, 37);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Concepto");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(151, 327, 183, 29);
		contentPane.add(lblNewLabel_4);

		textArea = new JTextArea();
		textArea.setBounds(151, 366, 227, 111);
		contentPane.add(textArea);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(192, 192, 192));
		btnRegistrar.setBounds(151, 487, 100, 25);
		contentPane.add(btnRegistrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 128, 0));
		btnCancelar.setBounds(278, 487, 100, 25);
		contentPane.add(btnCancelar);

		// Acción del botón "Registrar"
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String montoTexto = textField.getText().trim();
				String metodo = textField_1.getText().trim();
				String concepto = textArea.getText().trim();

				if (montoTexto.isEmpty() || metodo.isEmpty() || concepto.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
					return;
				}

				try {
					double monto = Double.parseDouble(montoTexto);
					Pago p = new Pago(monto, metodo, concepto);
					boolean guardado = p.registrarPagoTxt(Archivos.registroPagos);

					if (guardado) {
						JOptionPane.showMessageDialog(null, "Pago registrado correctamente.");
						textField.setText("");
						textField_1.setText("");
						textArea.setText("");
						textField_2.setText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
					} else {
						JOptionPane.showMessageDialog(null, "Error al registrar el pago.");
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "El monto debe ser un número válido.");
				}
			}
		});

		// Acción del botón "Cancelar"
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // cierra la ventana
			}
		});
	}
}
