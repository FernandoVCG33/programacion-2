package y;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRepCompleto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRepCompleto frame = new VentanaRepCompleto();
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
	public VentanaRepCompleto() {
		ArrayList<PartidoPolitico> partidos =  PartidoPolitico.leerPartidosTxt(Archivos.archivoPartidos);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panPrincipal = new JPanel();
		panPrincipal.setBackground(new Color(128, 128, 255));
		contentPane.add(panPrincipal);
		panPrincipal.setLayout(new BorderLayout(5, 5));
		
		JLabel lblTitulo = new JLabel("Candidatos y Partidos Politicos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panPrincipal.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panBotones = new JPanel();
		panBotones.setBackground(new Color(128, 128, 192));
		FlowLayout fl_panBotones = (FlowLayout) panBotones.getLayout();
		fl_panBotones.setAlignment(FlowLayout.RIGHT);
		panPrincipal.add(panBotones, BorderLayout.SOUTH);
		
		JButton btnModCandidato = new JButton("Modificar Candidato");
		btnModCandidato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panBotones.add(btnModCandidato);
		
		JButton btnMostrar = new JButton("Mostrar Todo");
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panBotones.add(btnMostrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panBotones.add(btnEliminar);
		
		JPanel panIzquierdo = new JPanel();
		panIzquierdo.setBackground(new Color(128, 128, 192));
		panPrincipal.add(panIzquierdo, BorderLayout.WEST);
		panIzquierdo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPartidos = new JLabel("Partidos Políticos");
		lblPartidos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panIzquierdo.add(lblPartidos, BorderLayout.NORTH);
		
		String partidosModelo[] = new String[partidos.size()];
		for(int i=0; i<partidos.size();i++) {
			partidosModelo[i] = partidos.get(i).toString();
		}
		
		JList listPartidos = new JList();
		listPartidos.setModel(new AbstractListModel() {
			String[] values = partidosModelo;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panIzquierdo.add(listPartidos);
		
		JPanel panIzqBotones = new JPanel();
		panIzquierdo.add(panIzqBotones, BorderLayout.SOUTH);
		panIzqBotones.setLayout(new BorderLayout(0, 0));
		
		JButton btnIzqMostrar = new JButton("Mostrar");
		btnIzqMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnIzqMostrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panIzqBotones.add(btnIzqMostrar, BorderLayout.NORTH);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice =  listPartidos.getSelectedIndex();
				VentanaModPartido v1 =  new VentanaModPartido(indice);
				v1.setVisible(true);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panIzqBotones.add(btnModificar, BorderLayout.SOUTH);
		
		JButton btnInhabilitar = new JButton("Inhabilitar");
		btnInhabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = listPartidos.getSelectedIndex();
				partidos.get(indice).setHabilitado(false);
				if(PartidoPolitico.reescribirPartido(partidos, Archivos.archivoPartidos)) {
					JOptionPane.showMessageDialog(btnInhabilitar, "Se inhabilito con exito");
				}else {
					JOptionPane.showMessageDialog(btnInhabilitar, "Ha ocurrido un error");
				}
				
				
			}
		});
		btnInhabilitar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panIzqBotones.add(btnInhabilitar);
		
		JPanel panCentro = new JPanel();
		panPrincipal.add(panCentro, BorderLayout.CENTER);
		panCentro.setLayout(new BorderLayout(0, 0));
		
		JList listCandidatos = new JList();
		panCentro.add(listCandidatos);
		
		JLabel lblCandidatos = new JLabel("Candidatos del Partido");
		lblCandidatos.setBackground(new Color(128, 128, 192));
		lblCandidatos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCandidatos.setHorizontalAlignment(SwingConstants.CENTER);
		panCentro.add(lblCandidatos, BorderLayout.NORTH);
	}

}
