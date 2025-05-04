package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

public class VentanaRepRecintos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRepRecintos frame = new VentanaRepRecintos();
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
	public VentanaRepRecintos() {
		ArrayList<Recinto> recintos = Recinto.leerRecintosTxt(Archivos.archivoRecintos);
		
		String[] datosVotantes = new String[recintos.size()];
        for (int i = 0; i < recintos.size(); i++) {
            datosVotantes[i] = recintos.get(i).toString();
        }
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panPrincipal = new JPanel();
		panPrincipal.setBackground(new Color(128, 0, 255));
		contentPane.add(panPrincipal);
		panPrincipal.setLayout(new BorderLayout(5, 5));
		
		JLabel lblNewLabel = new JLabel("Reporte recintos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panPrincipal.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panPrincipal.add(panel, BorderLayout.SOUTH);
		
		JButton btnLimpiar = new JButton("Limpiar");
		panel.add(btnLimpiar);
		
		JButton btnNewButton = new JButton("Eliminar");
		panel.add(btnNewButton);
		
		JPanel panelCiudades = new JPanel();
		panPrincipal.add(panelCiudades, BorderLayout.WEST);
		panelCiudades.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Ciudades");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCiudades.add(lblNewLabel_1, BorderLayout.NORTH);
		
		// Lista de ciudades
        String[] ciudades = {
            "La Paz", "El Alto", "Santa Cruz", "Cochabamba",
            "Tarija", "Sucre", "Potosí", "Oruro", "Pando", "Beni"
        };
		
		JList<String> listCiudades = new JList<>(ciudades);
		panelCiudades.add(listCiudades);
		JScrollPane scrollPane_1 = new JScrollPane(listCiudades);
		panelCiudades.add(scrollPane_1);
		
		JPanel paneCentral = new JPanel();
		paneCentral.setBackground(new Color(192, 192, 192));
		panPrincipal.add(paneCentral, BorderLayout.CENTER);
		paneCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Recintos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(192, 192, 192));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		paneCentral.add(lblNewLabel_2, BorderLayout.NORTH);
		
		
		String[] datosVotantes1 = new String[recintos.size()];
        for (int i = 0; i < recintos.size(); i++) {
            datosVotantes1[i] = recintos.get(i).toString();  // Usar toString() de Votante
        }
		JList list_recintos = new JList(datosVotantes);
		paneCentral.add(list_recintos, BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane(list_recintos);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		paneCentral.add(scrollPane, BorderLayout.CENTER);
	}

}
