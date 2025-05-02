package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaModPartido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFieldSiglaSIGLA;
	private JTextField txtFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//VentanaModPartido frame = new VentanaModPartido();
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
	public VentanaModPartido(int indice) {
		ArrayList <PartidoPolitico> partidos = PartidoPolitico.leerPartidosTxt(Archivos.archivoPartidos) ;
		String sigla= partidos.get(indice).getSigla();
		String nombre=partidos.get(indice).getNombre();
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
		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					partidos.get(indice).setSigla(txtFieldSiglaSIGLA.getText());
					partidos.get(indice).setNombre(txtFieldNombre.getText());
					if(PartidoPolitico.reescribirPartido(partidos,Archivos.archivoPartidos)) {

						
					}
				
			}
			
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panBotones.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFieldNombre.setText("");
				txtFieldSiglaSIGLA.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panBotones.add(btnLimpiar);
		
		JLabel lblNewLabel = new JLabel("Modificar Partido Politico");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panPrincipal.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panFormulario = new JPanel();
		panFormulario.setBackground(new Color(128, 128, 255));
		panPrincipal.add(panFormulario, BorderLayout.CENTER);
		panFormulario.setLayout(null);
		
		txtFieldSiglaSIGLA = new JTextField();
		txtFieldSiglaSIGLA.setBounds(178, 31, 205, 31);
		txtFieldSiglaSIGLA.setBackground(new Color(255, 255, 255));
		panFormulario.add(txtFieldSiglaSIGLA);
		txtFieldSiglaSIGLA.setColumns(10);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setColumns(10);
		txtFieldNombre.setBackground(Color.WHITE);
		txtFieldNombre.setBounds(178, 97, 205, 31);
		panFormulario.add(txtFieldNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Sigla");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(61, 27, 107, 31);
		panFormulario.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(61, 101, 107, 23);
		panFormulario.add(lblNewLabel_1_1);
	}
}