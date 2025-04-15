package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaRegistroRecinto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtUbicacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroRecinto frame = new VentanaRegistroRecinto();
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
	public VentanaRegistroRecinto() {
		setTitle("Registro de Recinto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panPrincipal = new JPanel();
		contentPane.add(panPrincipal, BorderLayout.CENTER);
		panPrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Nuevo Recinto");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panPrincipal.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panFormulario = new JPanel();
		panPrincipal.add(panFormulario);
		panFormulario.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(57, 52, 81, 14);
		panFormulario.add(lblNombre);
		
		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(57, 88, 81, 14);
		panFormulario.add(lblCiudad);
		
		JLabel lblUbicacion = new JLabel("Ubicación: ");
		lblUbicacion.setBounds(57, 123, 81, 14);
		panFormulario.add(lblUbicacion);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(148, 49, 205, 20);
		panFormulario.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(148, 120, 205, 20);
		panFormulario.add(txtUbicacion);
		
		JComboBox cbCiudad = new JComboBox();
		cbCiudad.setModel(new DefaultComboBoxModel(new String[] {"La Paz", "El Alto", "Cochabamba", "Sucre", "Santa Cruz de la Sierra", "Trinidad", "Cobija", "Tarija", "Oruro", "Potosí"}));
		cbCiudad.setBounds(147, 84, 206, 22);
		panFormulario.add(cbCiudad);
		
		JPanel panBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panPrincipal.add(panBotones, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		panBotones.add(btnAceptar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		panBotones.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 txtNombre.setText("");
			     txtUbicacion.setText("");
			}
		});
	}
}