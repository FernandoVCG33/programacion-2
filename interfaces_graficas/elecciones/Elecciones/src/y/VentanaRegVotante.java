package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class VentanaRegVotante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textUsuario;
	private JTextField textRecinto;
	private JTextField textNombre;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegVotante frame = new VentanaRegVotante();
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
	public VentanaRegVotante() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 325);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Registro de Votante");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_1.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int codigo = Integer.parseInt(textCodigo.getText());
				String usuario= textUsuario.getText();
				String recinto = textRecinto.getText();
				String nombre= textNombre.getText();
				String password = textPassword.getText();
				Votante pp = new Votante(codigo,usuario,recinto,nombre,password, null);
				if(pp.registrarVotanteTxt(Archivos.archivoVotante)) {
					JOptionPane.showMessageDialog(btnRegistrar, "Se registro correctamente");
					textCodigo.setText("");
					textUsuario.setText("");
					textRecinto.setText("");
					textNombre.setText("");
					textPassword.setText("");
					
				}
				else {
					JOptionPane.showMessageDialog(btnRegistrar, "Ocurrio un error (intentaste registrar a evo.. )");
				}
				
		}});
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_1.add(btnLimpiar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 192));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBackground(Color.WHITE);
		textCodigo.setBounds(149, 11, 265, 31);
		panel_2.add(textCodigo);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 171, 100, 30);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 131, 100, 30);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Recinto:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 91, 100, 30);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(10, 51, 100, 30);
		panel_2.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Codigo:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(10, 11, 100, 30);
		panel_2.add(lblNewLabel_1_2_2);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBackground(Color.WHITE);
		textUsuario.setBounds(149, 131, 265, 31);
		panel_2.add(textUsuario);
		
		textRecinto = new JTextField();
		textRecinto.setColumns(10);
		textRecinto.setBackground(Color.WHITE);
		textRecinto.setBounds(149, 91, 265, 31);
		panel_2.add(textRecinto);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBackground(Color.WHITE);
		textNombre.setBounds(149, 51, 265, 31);
		panel_2.add(textNombre);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBackground(Color.WHITE);
		textPassword.setBounds(149, 175, 265, 31);
		panel_2.add(textPassword);
	}
}
