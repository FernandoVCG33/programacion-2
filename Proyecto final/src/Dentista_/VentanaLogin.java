package Dentista_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_usuario;
	private JPasswordField text_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(500, 200, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Iniciar sesión ");
		lblNewLabel.setBounds(248, 27, 146, 25);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(208, 96, 106, 13);
		contentPane.add(lblNewLabel_1);
		
		text_usuario = new JTextField();
		text_usuario.setBounds(208, 132, 204, 32);
		contentPane.add(text_usuario);
		text_usuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(208, 188, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_iniciar_secion = new JButton("Iniciar sesión");
		btn_iniciar_secion.setBackground(new Color(192, 192, 192));
		btn_iniciar_secion.setBounds(208, 291, 204, 25);
		btn_iniciar_secion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = text_usuario.getText();
				String pass= text_password.getText() ;
				if (name.equals("Juan") && pass.equals("12345")) {
					JOptionPane.showMessageDialog(null, "Bienvenido");
					Ventana_principal frame = new Ventana_principal();
					frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecta");
				}
			}
		});
		contentPane.add(btn_iniciar_secion);
		
		text_password = new JPasswordField();
		text_password.setBounds(208, 224, 204, 35);
		contentPane.add(text_password);
	}
}
