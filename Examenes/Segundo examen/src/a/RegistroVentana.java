package a;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistroVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField codigo;
	private JTextField nota1;
	private JTextField nota2;
	private JTextField nota3;
	private JTextField promedio;
	private JTextField estado;
	private JTextField promg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroVentana frame = new RegistroVentana();
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
	public RegistroVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de estudiantes");
		lblNewLabel.setBounds(5, 5, 976, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		contentPane.add(lblNewLabel);
		
		JPanel Izquierda = new JPanel();
		Izquierda.setBackground(new Color(64, 128, 128));
		Izquierda.setBounds(5, 37, 304, 521);
		contentPane.add(Izquierda);
		Izquierda.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Registrar estudiantes");
		lblNewLabel_3.setBounds(96, 10, 127, 13);
		Izquierda.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setBounds(10, 55, 45, 13);
		Izquierda.add(lblNewLabel_4);
		
		textnombre = new JTextField();
		textnombre.setBounds(10, 78, 284, 26);
		Izquierda.add(textnombre);
		textnombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Codigo:");
		lblNewLabel_5.setBounds(10, 124, 45, 13);
		Izquierda.add(lblNewLabel_5);
		
		codigo = new JTextField();
		codigo.setBounds(10, 147, 284, 26);
		Izquierda.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nota 1 :");
		lblNewLabel_6.setBounds(10, 195, 45, 13);
		Izquierda.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Nota 2 :");
		lblNewLabel_7.setBounds(121, 195, 45, 13);
		Izquierda.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nota 3: ");
		lblNewLabel_8.setBounds(249, 195, 45, 13);
		Izquierda.add(lblNewLabel_8);
		
		nota1 = new JTextField();
		nota1.setBounds(10, 220, 70, 31);
		Izquierda.add(nota1);
		nota1.setColumns(10);
		
		nota2 = new JTextField();
		nota2.setBounds(131, 218, 54, 33);
		Izquierda.add(nota2);
		nota2.setColumns(10);
		
		nota3 = new JTextField();
		nota3.setBounds(240, 218, 54, 33);
		Izquierda.add(nota3);
		nota3.setColumns(10);
		
		JButton btnCal = new JButton("Calcular");
		btnCal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
		            String nombre1 = textnombre.getText();
		            String codigo1 = codigo.getText();
		            double n1 = Double.parseDouble(nota1.getText());
		            double n2 = Double.parseDouble(nota2.getText());
		            double n3 = Double.parseDouble(nota3.getText());

		            Estudiantes est = new Estudiantes(codigo1, nombre1, n1, n2, n3);
		        
		            promedio.setText(String.format("%.2f", est.getPromedio()));
		            estado.setText(est.getEstado());
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingresa números válidos en las notas.");
		        }
		    }
		});
		btnCal.setBounds(100, 261, 85, 21);
		Izquierda.add(btnCal);
		
		JButton btnL = new JButton("Limpiar");
		btnL.setBounds(209, 261, 85, 21);
		Izquierda.add(btnL);
		btnL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textnombre.setText("");
				codigo.setText("");
				nota1.setText("");
				nota2.setText("");
				nota3.setText("");
			}
		});
		
		JLabel lblNewLabel_9 = new JLabel("Promedio:");
		lblNewLabel_9.setBounds(10, 308, 85, 13);
		Izquierda.add(lblNewLabel_9);
		
		promedio = new JTextField();
		promedio.setBounds(10, 333, 284, 26);
		Izquierda.add(promedio);
		promedio.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Estado");
		lblNewLabel_10.setBounds(10, 376, 85, 13);
		Izquierda.add(lblNewLabel_10);
		
		estado = new JTextField();
		estado.setBounds(10, 399, 284, 26);
		Izquierda.add(estado);
		estado.setColumns(10);
		
		JButton btnRE = new JButton("Registrar estudiante");
		btnRE.setBounds(10, 434, 284, 21);
		btnRE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(btnRE, "Se registro correctamente");
				textnombre.setText("");
				codigo.setText("");
				nota1.setText("");
				nota2.setText("");
				nota3.setText("");
			}
		});
		Izquierda.add(btnRE);
		
		JLabel lblNewLabel_11 = new JLabel("Promedio general");
		lblNewLabel_11.setBounds(100, 465, 127, 13);
		Izquierda.add(lblNewLabel_11);
		
		promg = new JTextField();
		promg.setBounds(96, 476, 96, 19);
		Izquierda.add(promg);
		promg.setColumns(10);
		
		JButton btncalp = new JButton("Calcular promedio");
		btncalp.setBounds(0, 500, 304, 21);
		Izquierda.add(btncalp);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(368, 37, 304, 521);
		contentPane.add(panelCentral);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Estudiantes registrados");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(lblNewLabel_1, BorderLayout.NORTH);
		
		
		
		JList list = new JList();
		panelCentral.add(list, BorderLayout.WEST);
		JScrollPane scrollPane = new JScrollPane(list);
		panelCentral.add(scrollPane, BorderLayout.CENTER);
		JPanel cenBon = new JPanel();
		panelCentral.add(cenBon, BorderLayout.SOUTH);
		
		JButton btn = new JButton("Mostrar reporte");
		cenBon.add(btn);
		
		JButton btnlimpiar = new JButton("Limpiar reporte");
		cenBon.add(btnlimpiar);
		
		JPanel paneDerecha = new JPanel();
		paneDerecha.setBounds(720, 37, 256, 521);
		contentPane.add(paneDerecha);
		paneDerecha.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Estidiantes destacados");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		paneDerecha.add(lblNewLabel_2, BorderLayout.NORTH);
		
		
		
		JList listaDestacados = new JList();
		paneDerecha.add(listaDestacados, BorderLayout.WEST);
		JScrollPane scroll2 = new JScrollPane(listaDestacados);
		paneDerecha.add(scroll2, BorderLayout.CENTER);
		JPanel paneBotones = new JPanel();
		paneDerecha.add(paneBotones, BorderLayout.SOUTH);
		
		JButton btnMR = new JButton("Mostrar reporte");
		paneBotones.add(btnMR);
		
		JButton btnLR = new JButton("Limpiar reporte");
		paneBotones.add(btnLR);
	}
}
