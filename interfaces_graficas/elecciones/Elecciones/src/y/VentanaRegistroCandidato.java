package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class VentanaRegistroCandidato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroCandidato frame = new VentanaRegistroCandidato();
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
	public VentanaRegistroCandidato() {
		ArrayList<PartidoPolitico>partidos= PartidoPolitico.leerPartidosTxt(Archivos.archivoPartidos) ;
		setTitle("Nuevo Candidato");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panPrincipal = new JPanel();
		contentPane.add(panPrincipal);
		panPrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Nuevo Candidato");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panPrincipal.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panFormulario = new JPanel();
		panPrincipal.add(panFormulario);
		panFormulario.setLayout(null);
		
		JLabel lb_codigo = new JLabel("Codigo:");
		lb_codigo.setBounds(87, 10, 51, 13);
		panFormulario.add(lb_codigo);
		
		textField = new JTextField();
		textField.setBounds(167, 7, 119, 19);
		panFormulario.add(textField);
		textField.setColumns(10);
		
		JLabel lb_nombre = new JLabel("Nombre:");
		lb_nombre.setBounds(87, 39, 51, 13);
		panFormulario.add(lb_nombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 36, 119, 19);
		panFormulario.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lb_ci = new JLabel("Ci:");
		lb_ci.setBounds(87, 68, 45, 13);
		panFormulario.add(lb_ci);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 65, 119, 19);
		panFormulario.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lb_usuario = new JLabel("Usuario:");
		lb_usuario.setBounds(87, 101, 70, 13);
		panFormulario.add(lb_usuario);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 98, 119, 19);
		panFormulario.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(87, 133, 70, 13);
		panFormulario.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(167, 130, 119, 19);
		panFormulario.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Partido:");
		lblNewLabel_1.setBounds(87, 166, 51, 13);
		panFormulario.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(167, 163, 119, 19);
		panFormulario.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panbotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panbotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panbotones, BorderLayout.SOUTH);
		
		JButton btn_limpiar = new JButton("Limpiar");
		panbotones.add(btn_limpiar);
		btn_limpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				// TODO Auto-generated method stub
				 txtNombre.setText("");
			     txtUbicacion.setText("");
			     */
			}
		});
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		panbotones.add(btnNewButton_1);
		
		String partidosModelo[]= new String [partidos.size()];
		for (int i=0; i<partidos.size();i++) {
			partidosModelo[i]=partidos.get(i).toString();
		}
		
		
	}
}
