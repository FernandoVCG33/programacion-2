package Dentista_;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana_ver_pagos extends JFrame implements Archivos {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> modeloLista;
	private JList<String> lista_de_pagos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_ver_pagos frame = new Ventana_ver_pagos();
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
	public Ventana_ver_pagos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro de pagos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(204, 10, 215, 47);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 559, 249);
		contentPane.add(scrollPane);

		modeloLista = new DefaultListModel<>();
		lista_de_pagos = new JList<>(modeloLista);
		scrollPane.setViewportView(lista_de_pagos);

		JButton btn_reg_pagos = new JButton("Mostrar");
		btn_reg_pagos.setBounds(224, 329, 85, 21);
		contentPane.add(btn_reg_pagos);

		JButton btn_limpiar_pagos = new JButton("Limpiar");
		btn_limpiar_pagos.setBounds(355, 329, 85, 21);
		contentPane.add(btn_limpiar_pagos);

		// Acción del botón "Mostrar"
		btn_reg_pagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloLista.clear();
				ArrayList<Pago> lista = Pago.leerPagosDesdeTxt(Archivos.registroPagos);

				if (lista.isEmpty()) {
					modeloLista.addElement("No hay pagos registrados o el archivo no se encontró.");
				} else {
					for (Pago p : lista) {
						modeloLista.addElement(p.mostrarPago());
						modeloLista.addElement("--------------------------------------------------");
					}
				}
			}
		});

		// Acción del botón "Limpiar"
		btn_limpiar_pagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloLista.clear();
			}
		});
	}
}
