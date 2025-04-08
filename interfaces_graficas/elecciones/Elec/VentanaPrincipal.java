package y;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("Elecciones 2025");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panePrincipal = new JPanel();
		panePrincipal.setBackground(new Color(0, 128, 128));
		contentPane.add(panePrincipal, BorderLayout.CENTER);
		panePrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel lbElecciones2025 = new JLabel("Elecciones 2025");
		lbElecciones2025.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		lbElecciones2025.setHorizontalAlignment(SwingConstants.CENTER);
		panePrincipal.add(lbElecciones2025, BorderLayout.NORTH);
		
		JPanel paneMenu = new JPanel();
		panePrincipal.add(paneMenu, BorderLayout.CENTER);
		paneMenu.setLayout(new GridLayout(1, 1, 5, 5));
		
		JPanel panel_3 = new JPanel();
		paneMenu.add(panel_3);
		panel_3.setLayout(new GridLayout(6, 1, 3, 3));
		
		JButton btnNewButton_1 = new JButton("Registrar partido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrarPartido frame = new VentanaRegistrarPartido();
				frame.setVisible(true);
			}
		});
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrar reciente");
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_3.add(btnNewButton_6);
		
		JPanel panel_2 = new JPanel();
		paneMenu.add(panel_2);
		panel_2.setLayout(new GridLayout(6, 1, 5, 5));
		
		JButton btnNewButton_1_1 = new JButton("Registrar partido");
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Registrar reciente");
		panel_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("New button");
		panel_2.add(btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("New button");
		panel_2.add(btnNewButton_4_1);
		
		JButton btnNewButton_5_1 = new JButton("New button");
		panel_2.add(btnNewButton_5_1);
		
		JButton btnNewButton_6_1 = new JButton("New button");
		panel_2.add(btnNewButton_6_1);
		
		JPanel panel_1 = new JPanel();
		paneMenu.add(panel_1);
		
		JPanel PaneVotos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) PaneVotos.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		PaneVotos.setBackground(new Color(0, 255, 0));
		panePrincipal.add(PaneVotos, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Registrar votos");
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		PaneVotos.add(btnNewButton);
	}

}
