package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
public class VentanaRegistroPartido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtSigla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroPartido frame = new VentanaRegistroPartido();
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
	public VentanaRegistroPartido() {
		setTitle("Nuevo Partido");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panPrincipal = new JPanel();
		contentPane.add(panPrincipal, BorderLayout.CENTER);
		panPrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Nuevo Partido");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panPrincipal.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panPrincipal.add(panBotones, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		panBotones.add(btnAceptar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		panBotones.add(btnLimpiar);
		/*limpiar*/
		btnLimpiar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        txtNombre.setText("");
		        txtSigla.setText("");
		    }
		});

		
		JPanel panFormulario = new JPanel();
		panPrincipal.add(panFormulario, BorderLayout.CENTER);
		panFormulario.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(60, 39, 75, 14);
		panFormulario.add(lblNombre);
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setBounds(60, 83, 75, 14);
		panFormulario.add(lblSigla);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(145, 36, 219, 20);
		panFormulario.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtSigla = new JTextField();
		txtSigla.setBounds(145, 80, 219, 20);
		panFormulario.add(txtSigla);
		txtSigla.setColumns(10);
	}

}
