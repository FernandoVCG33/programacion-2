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
		setBounds(500, 200, 700, 459);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clínica dental Rios");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 24, 329, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel);
		
		JPanel panecentral = new JPanel();
		panecentral.setBackground(new Color(255, 255, 255));
		panecentral.setBounds(0, 74, 841, 348);
		contentPane.add(panecentral);
		panecentral.setLayout(null);
		



		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido doctor Juan !");
		lblNewLabel_1.setBackground(new Color(233, 235, 254));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(217, 25, 321, 67);
		panecentral.add(lblNewLabel_1);
		
		JButton btn_reg_p = new JButton("Registrar paciente");
		btn_reg_p.setForeground(new Color(255, 255, 255));
		btn_reg_p.setBackground(new Color(0, 128, 192));
		btn_reg_p.setBounds(64, 143, 147, 58);
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
		btn_mostrar_recetas.setForeground(new Color(255, 255, 255));
		btn_mostrar_recetas.setBackground(new Color(0, 128, 192));
		btn_mostrar_recetas.setBounds(251, 143, 147, 58);
		btn_mostrar_recetas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ven_reg_medicamentos frame = new Ven_reg_medicamentos();
				frame.setVisible(true);
			}
		});
		panecentral.add(btn_mostrar_recetas);
		
		JButton btn_pagos = new JButton("Resgistro de pago");
		btn_pagos.setForeground(new Color(255, 255, 255));
		btn_pagos.setBackground(new Color(0, 128, 192));
		btn_pagos.setBounds(436, 143, 147, 58);
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
		Mostrar_pacientes.setBackground(new Color(255, 128, 64));
		Mostrar_pacientes.setBounds(64, 211, 147, 58);
		
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
		btn_recetas.setBackground(new Color(255, 128, 64));
		btn_recetas.setBounds(251, 211, 147, 58);
		btn_recetas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ven_ver_recetas frame = new Ven_ver_recetas();
				frame.setVisible(true);
			}
		});
		panecentral.add(btn_recetas);
		
		JButton btnmospagos = new JButton("Mostrar pagos");
		btnmospagos.setBackground(new Color(255, 128, 64));
		btnmospagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_ver_pagos frame = new Ventana_ver_pagos();
				frame.setVisible(true);
			}
		});
		btnmospagos.setBounds(436, 211, 147, 58);
		panecentral.add(btnmospagos);
		
		JLabel lblNewLabel_2 = new JLabel("Acciones rápidas:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(64, 120, 102, 13);
		panecentral.add(lblNewLabel_2);
		
		JButton btn_salir = new JButton("Salir");
		btn_salir.setBackground(new Color(255, 128, 64));
		btn_salir.setForeground(new Color(64, 0, 64));
		btn_salir.setBounds(518, 39, 85, 29);
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
				System.exit(0);
			}
		});
		contentPane.add(btn_salir);

	}
}
