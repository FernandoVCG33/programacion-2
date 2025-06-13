package Dentista_;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ventana_principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_principal frame = new Ventana_principal();
					frame.setVisible(true);
					System.out.println("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 430);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio");
		lblNewLabel.setBounds(5, 5, 831, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel);
		
		JPanel panecentral = new JPanel();
		panecentral.setBounds(5, 45, 831, 343);
		contentPane.add(panecentral);
		panecentral.setLayout(null);
		



		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido doctor Juan !");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(285, 10, 321, 67);
		panecentral.add(lblNewLabel_1);
		
		JButton btn_reg_p = new JButton("Registrar paciente");
		btn_reg_p.setBounds(35, 143, 185, 58);
		btn_reg_p.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_reg_paciente frame = new Ventana_reg_paciente();
				frame.setVisible(true);
			}
		});
		panecentral.add(btn_reg_p);
		
		
		JButton btn_mostrar_recetas = new JButton("Registrar receta");
		btn_mostrar_recetas.setBounds(317, 143, 195, 58);
		btn_mostrar_recetas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ven_reg_medicamentos frame = new Ven_reg_medicamentos();
				frame.setVisible(true);
			}
		});
		panecentral.add(btn_mostrar_recetas);
		
		JButton btn_pagos = new JButton("Resgistro de  pagos");
		btn_pagos.setBounds(589, 149, 185, 47);
		btn_pagos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_reg_pago frame = new Ventana_reg_pago();
				frame.setVisible(true);
			}
		});
		panecentral.add(btn_pagos);
		
		JButton Mostrar_pacientes = new JButton("Mostrar pacientes");
		Mostrar_pacientes.setBounds(35, 227, 185, 47);
		
		Mostrar_pacientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_ver_pacientes frame = new Ventana_ver_pacientes();
				frame.setVisible(true);
			}
		});
		panecentral.add(Mostrar_pacientes);
		
		JButton btn_recetas = new JButton("Ver recetas");
		btn_recetas.setBounds(317, 227, 185, 47);
		btn_recetas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ven_ver_recetas frame = new Ven_ver_recetas();
				frame.setVisible(true);
			}
		});
		panecentral.add(btn_recetas);
		
		JButton btnmospagos = new JButton("Mostrar pagos totals");
		btnmospagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_ver_pagos frame = new Ventana_ver_pagos();
				frame.setVisible(true);
			}
		});
		btnmospagos.setBounds(589, 227, 185, 47);
		panecentral.add(btnmospagos);
		
		JButton btn_salir = new JButton("Salir");
		btn_salir.setBounds(702, 14, 85, 21);
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
				System.exit(0);
			}
		});
		contentPane.add(btn_salir);

	}
}
