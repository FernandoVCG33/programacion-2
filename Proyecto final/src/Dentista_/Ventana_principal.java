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
		setBounds(100, 100, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Inicio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panecentral = new JPanel();
		contentPane.add(panecentral, BorderLayout.CENTER);
		panecentral.setLayout(null);
		



		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido doctor Juan !");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(402, 24, 321, 67);
		panecentral.add(lblNewLabel_1);
		
		JButton btn_reg_p = new JButton("Registrar paciente");
		btn_reg_p.setBounds(35, 143, 252, 351);
		btn_reg_p.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_reg_paciente frame = new Ventana_reg_paciente();
				frame.setVisible(true);
			}
		});
		panecentral.add(btn_reg_p);
		
		
		JButton btn_mostrar_recetas = new JButton("ver recetas");
		btn_mostrar_recetas.setBounds(350, 143, 274, 351);
		panecentral.add(btn_mostrar_recetas);
		
		JButton btn_pagos = new JButton("Lista de  pagos");
		btn_pagos.setBounds(769, 143, 227, 351);
		panecentral.add(btn_pagos);
	}
}
