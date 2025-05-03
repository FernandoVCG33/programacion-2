package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class VentanaModCandidato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textPassword;
	private JTextField textNombre;
	private JTextField textUsuario;
	private JTextField textCarnet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModCandidato frame = new VentanaModCandidato();
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
	public VentanaModCandidato() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panPrincipal = new JPanel();
		panPrincipal.setBackground(new Color(128, 128, 255));
		contentPane.add(panPrincipal);
		panPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panPrincipal.add(panBotones, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panBotones.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panBotones.add(btnLimpiar);
		
		JLabel lblTitulo = new JLabel("Modificar Candidato");
		lblTitulo.setBackground(new Color(128, 128, 192));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		panPrincipal.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panFormulario = new JPanel();
		panFormulario.setLayout(null);
		panFormulario.setBackground(new Color(128, 128, 192));
		panPrincipal.add(panFormulario, BorderLayout.CENTER);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBackground(Color.WHITE);
		textCodigo.setBounds(145, 10, 265, 31);
		panFormulario.add(textCodigo);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(40, 170, 100, 30);
		panFormulario.add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Carnet:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(40, 90, 100, 30);
		panFormulario.add(lblNewLabel_1_1);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBackground(Color.WHITE);
		textPassword.setBounds(145, 170, 265, 31);
		panFormulario.add(textPassword);
		
		JLabel lblNewLabel_1_2 = new JLabel("Codigo:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(40, 10, 100, 30);
		panFormulario.add(lblNewLabel_1_2);
		
		JComboBox comboBoxPartido = new JComboBox();
		comboBoxPartido.setToolTipText("");
		comboBoxPartido.setMaximumRowCount(10);
		comboBoxPartido.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxPartido.setBounds(145, 210, 265, 31);
		panFormulario.add(comboBoxPartido);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(40, 50, 100, 30);
		panFormulario.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Usuario:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(40, 130, 100, 30);
		panFormulario.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Partido:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_3.setBounds(40, 210, 100, 30);
		panFormulario.add(lblNewLabel_1_2_3);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBackground(Color.WHITE);
		textNombre.setBounds(145, 50, 265, 31);
		panFormulario.add(textNombre);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBackground(Color.WHITE);
		textUsuario.setBounds(145, 130, 265, 31);
		panFormulario.add(textUsuario);
		
		textCarnet = new JTextField();
		textCarnet.setColumns(10);
		textCarnet.setBackground(Color.WHITE);
		textCarnet.setBounds(145, 90, 265, 31);
		panFormulario.add(textCarnet);
	}
}
