package Dentista_;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Ventana_reg_paciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel content_pacientes;
	private JTextField text_nombre;
	private JTextField text_ci;
	private JTextField text_sexo;
	private JTextField text_edad;
	private JTextField text_sintomas;
	private JTextField text_estado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_reg_paciente frame = new Ventana_reg_paciente();
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
	public Ventana_reg_paciente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 579, 546);
		content_pacientes = new JPanel();
		content_pacientes.setBackground(new Color(0, 128, 192));
		content_pacientes.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(content_pacientes);
		content_pacientes.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de pacientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(179, 10, 223, 65);
		content_pacientes.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(190, 73, 118, 38);
		content_pacientes.add(lblNewLabel_1);
		
		text_nombre = new JTextField();
		text_nombre.setBounds(190, 107, 181, 26);
		content_pacientes.add(text_nombre);
		text_nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CI");
		lblNewLabel_2.setBounds(190, 143, 45, 13);
		content_pacientes.add(lblNewLabel_2);
		
		text_ci = new JTextField();
		text_ci.setBounds(190, 166, 181, 26);
		content_pacientes.add(text_ci);
		text_ci.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(190, 202, 45, 13);
		content_pacientes.add(lblNewLabel_3);
		
		text_sexo = new JTextField();
		text_sexo.setBounds(190, 225, 181, 26);
		content_pacientes.add(text_sexo);
		text_sexo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setBounds(190, 261, 45, 13);
		content_pacientes.add(lblNewLabel_4);
		
		text_edad = new JTextField();
		text_edad.setBounds(190, 284, 181, 26);
		content_pacientes.add(text_edad);
		text_edad.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sintomas");
		lblNewLabel_5.setBounds(190, 320, 118, 13);
		content_pacientes.add(lblNewLabel_5);
		
		text_sintomas = new JTextField();
		text_sintomas.setBounds(190, 343, 181, 26);
		content_pacientes.add(text_sintomas);
		text_sintomas.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Estado de dientes");
		lblNewLabel_6.setBounds(190, 379, 102, 13);
		content_pacientes.add(lblNewLabel_6);
		
		text_estado = new JTextField();
		text_estado.setBounds(190, 402, 181, 26);
		content_pacientes.add(text_estado);
		text_estado.setColumns(10);
		
		JButton btn_reg_paciente = new JButton("Registrar");
		btn_reg_paciente.setBackground(new Color(192, 192, 192));
		btn_reg_paciente.setBounds(179, 447, 101, 38);
		content_pacientes.add(btn_reg_paciente);
		btn_reg_paciente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				String nombre = text_nombre.getText();
				String ci = text_ci.getText();
				String sexo = text_sexo.getText();
				String edadStr = text_edad.getText();
				String sintomas = text_sintomas.getText();
				String estado = text_estado.getText();

				// Validación mínima (puedes expandirla si quieres)
				if (nombre.isEmpty() || ci.isEmpty() || sexo.isEmpty() || edadStr.isEmpty()) {
					System.out.println("Por favor completa todos los campos obligatorios.");
					return;
				}

				try {
					int edad = Integer.parseInt(edadStr);
					Paciente p = new Paciente(nombre, ci, sexo, edad, sintomas, estado);
					if (edad>18) {
						p.registrarEnArchivoTxt();
					}
					else {
						Paciente.registrarBinario(p);; 
					}
			
					System.out.println("Paciente registrado con éxito.");
					JOptionPane.showMessageDialog(null, "Paciente ya registrado");
					// También podrías mostrar un JOptionPane si prefieres algo visual
				} catch (NumberFormatException ex) {
					System.out.println("Edad inválida, debe ser un número.");
				}
			}
		});
		
		JButton btn_limpiar_paciente = new JButton("Limpiar");
		btn_limpiar_paciente.setBackground(new Color(192, 192, 192));
		btn_limpiar_paciente.setBounds(302, 447, 100, 38);
		btn_limpiar_paciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text_nombre.setText("");
				text_ci.setText("");
				text_sexo.setText("");
				text_edad.setText("");
				text_sintomas.setText("");
				text_estado.setText("");
			}
		});
		content_pacientes.add(btn_limpiar_paciente);
	}
}
