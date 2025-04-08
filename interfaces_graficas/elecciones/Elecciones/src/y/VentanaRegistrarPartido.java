package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistrarPartido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSigla;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarPartido frame = new VentanaRegistrarPartido();
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
	public VentanaRegistrarPartido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panePrincipal = new JPanel();
		contentPane.add(panePrincipal);
		panePrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panBotones = new JPanel();
		panePrincipal.add(panBotones, BorderLayout.SOUTH);
		panBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("limpiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSigla.setText("");
				txtNombre.setText("");
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panBotones.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("aceptar");
		panBotones.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Registrar partido");
		panePrincipal.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelFormulario = new JPanel();
		panePrincipal.add(panelFormulario);
		panelFormulario.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(109, 123, 46, 14);
		panelFormulario.add(lblNewLabel_1);
		
		txtSigla = new JTextField();
		txtSigla.setBounds(195, 73, 86, 20);
		panelFormulario.add(txtSigla);
		txtSigla.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sigla");
		lblNewLabel_2.setBounds(109, 69, 46, 43);
		panelFormulario.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(195, 116, 86, 20);
		panelFormulario.add(txtNombre);
		txtNombre.setColumns(10);
	}
}
