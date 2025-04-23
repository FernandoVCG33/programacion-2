package y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
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
		setBounds(100, 100, 692, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panPrincipal = new JPanel();
		panPrincipal.setBackground(new Color(64, 224, 208));
		contentPane.add(panPrincipal, BorderLayout.CENTER);
		panPrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Elecciones 2025");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panPrincipal.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panMenu = new JPanel();
		panPrincipal.add(panMenu, BorderLayout.CENTER);
		panMenu.setLayout(new GridLayout(1, 3, 5, 5));
		
		JPanel panOpciones1 = new JPanel();
		panMenu.add(panOpciones1);
		panOpciones1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JButton btnNuevoPartido = new JButton("Registrar partido");
		btnNuevoPartido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaRegistroPartido frame = new VentanaRegistroPartido();
				frame.setVisible(true);
			}
		});;
		btnNuevoPartido.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		panOpciones1.add(btnNuevoPartido);
		
		JButton btn_recinto = new JButton("Registrar recinto");
		btn_recinto.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		panOpciones1.add(btn_recinto);
		btn_recinto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaRegistroRecinto frame = new VentanaRegistroRecinto();
				frame.setVisible(true);
			}
		});
		
		JButton btn_candidatos = new JButton("Registrar Candidatos");
		btn_candidatos.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		panOpciones1.add(btn_candidatos);
		btn_candidatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 VentanaRegistroCandidato frame = new  VentanaRegistroCandidato();
				frame.setVisible(true);
			}
		});
		JButton btnNewButton_3 = new JButton("Registrar votante");
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		panOpciones1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Modificar candidato");
		btnNewButton_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		panOpciones1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Modificar votante");
		btnNewButton_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		panOpciones1.add(btnNewButton_5);
		
		JPanel panOpciones2 = new JPanel();
		panMenu.add(panOpciones2);
		panOpciones2.setLayout(new GridLayout(6, 1, 0, 0));
		
		JButton btnNewButton_6 = new JButton("New button");
		panOpciones2.add(btnNewButton_6);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		panOpciones2.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		panOpciones2.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("New button");
		panOpciones2.add(btnNewButton_3_1);
		
		JPanel panImagen = new JPanel();
		JLabel lblImagen  =  new JLabel();
		Icon icono =  new ImageIcon("BG.jpg");
		panImagen.setLayout(new BorderLayout(0, 0));
		lblImagen.setIcon(icono);
		panImagen.add(lblImagen);
		panMenu.add(panImagen);
		
		JPanel panBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panPrincipal.add(panBoton, BorderLayout.SOUTH);
		
		JButton btnRegistrarVoto = new JButton("Registrar Votos");
		panBoton.add(btnRegistrarVoto);
	}


}
