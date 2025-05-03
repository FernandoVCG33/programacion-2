package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaModRecinto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//VentanaModRecinto frame = new VentanaModRecinto();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaModRecinto(int indice) {
		ArrayList <Recinto> recintos = Recinto.leerRecintosTxt(Archivos.archivoRecintos) ;
		String nombre= recintos.get(indice).getNombre();
		String ciudad=recintos.get(indice).getCiudad();
		String ubicacion=recintos.get(indice).getUbicacion();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panPrincipal = new JPanel();
		panPrincipal.setBackground(new Color(128, 128, 192));
		contentPane.add(panPrincipal, BorderLayout.CENTER);
		panPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panPrincipal.add(panBotones, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panBotones.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				recintos.get(indice).setNombre(txtNombre.getText());
				//recintos.get(indice).setCiudad(comboBoxCiudad.getText());
				recintos.get(indice).setUbicacion(txtDireccion.getText());
				if(Recinto.reescribirRecinto(recintos,Archivos.archivoRecintos)) {
					JOptionPane.showMessageDialog(btnRegistrar, "Se modifico con exito");	
				}
				else {
					JOptionPane.showMessageDialog(btnRegistrar, "Ha ocurrido un error");
				}
				txtNombre.setText("");
				txtDireccion.setText("");
				
			}
		});
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtDireccion.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panBotones.add(btnLimpiar);
		
		JLabel lblTitulo = new JLabel("Modificar Recinto");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panPrincipal.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panFormulario = new JPanel();
		panFormulario.setBackground(new Color(128, 128, 255));
		panPrincipal.add(panFormulario, BorderLayout.CENTER);
		panFormulario.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(133, 11, 264, 31);
		panFormulario.add(txtNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Dirección:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 121, 107, 31);
		panFormulario.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ciudad:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(30, 69, 107, 30);
		panFormulario.add(lblNewLabel_1_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setBounds(134, 120, 265, 31);
		panFormulario.add(txtDireccion);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(32, 11, 107, 31);
		panFormulario.add(lblNewLabel_1_2);
		
		JComboBox comboBoxCiudad = new JComboBox();
		comboBoxCiudad.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxCiudad.setModel(new DefaultComboBoxModel(new String[] {"La Paz", "Santa Cruz", "El Alto", "Chuquisaca", "Beni", "Pando", "Oruro", "Cochabamba", "Tarija", "Potosi"}));
		comboBoxCiudad.setToolTipText("");
		comboBoxCiudad.setMaximumRowCount(10);
		comboBoxCiudad.setBounds(133, 67, 261, 31);
		panFormulario.add(comboBoxCiudad);
	}
}
