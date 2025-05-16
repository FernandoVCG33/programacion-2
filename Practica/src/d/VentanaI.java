package d;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField codigo;
	private JTextField nota1;
	private JTextField cal;
	private JTextField nombreP;
	private JTextField estado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaI frame = new VentanaI();
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
	public VentanaI() {
		ArrayList<AlquilarCancha> registro = AlquilarCancha.leerTxt(Archivos.alquilerTexto);

        // Crear arreglo de Strings para el JList
        String[] register = new String[registro.size()];
        for (int i = 0; i < registro.size(); i++) {
            register[i] = registro.get(i).toString();
        }
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
		
		JLabel lblNewLabel_4 = new JLabel("Nombre de la cancha: ");
		lblNewLabel_4.setBounds(10, 31, 146, 13);
		Izquierda.add(lblNewLabel_4);
		
		textnombre = new JTextField();
		textnombre.setBounds(10, 54, 284, 26);
		Izquierda.add(textnombre);
		textnombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Hora de inicio :");
		lblNewLabel_5.setBounds(10, 90, 96, 13);
		Izquierda.add(lblNewLabel_5);
		
		codigo = new JTextField();
		codigo.setBounds(10, 113, 284, 26);
		Izquierda.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Total:");
		lblNewLabel_7.setBounds(10, 291, 45, 13);
		Izquierda.add(lblNewLabel_7);
		
		nota1 = new JTextField();
		nota1.setBounds(10, 171, 284, 26);
		Izquierda.add(nota1);
		nota1.setColumns(10);
		
		cal = new JTextField();
		cal.setBounds(10, 314, 284, 26);
		Izquierda.add(cal);
		cal.setColumns(10);
		
		nombreP = new JTextField();
		nombreP.setBounds(10, 227, 284, 26);
		Izquierda.add(nombreP);
		nombreP.setColumns(10);
		
		JButton btnCal = new JButton("Calcular");
		btnCal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
		            String nombreC = textnombre.getText();
		            int horaIn = Integer.parseInt(codigo.getText());
		            double horasT = Double.parseDouble(nota1.getText());
		            String nombrep = nombreP.getText();
		           
		            AlquilarCancha est = new AlquilarCancha(horasT,horaIn,nombreC,nombrep);
		            cal.setText(String.format("%.2f", est.calcularCosto()));
		            //promedio.setText(String.format("%.2f", est.getPromedio()));
		            //estado.setText(est.getEstado());
		            
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingresa números válidos en las notas.");
		        }
		    }
		});
		btnCal.setBounds(209, 263, 85, 21);
		Izquierda.add(btnCal);
		
		JButton btnL = new JButton("Limpiar");
		btnL.setBounds(114, 263, 85, 21);
		Izquierda.add(btnL);
		btnL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textnombre.setText("");
				codigo.setText("");
				nota1.setText("");
				cal.setText("");
				nombreP.setText("");
			}
		});
		
		JLabel lblNewLabel_10 = new JLabel("Total ganado");
		lblNewLabel_10.setBounds(10, 399, 85, 13);
		Izquierda.add(lblNewLabel_10);
		
		estado = new JTextField();
		estado.setBounds(10, 422, 284, 26);
		Izquierda.add(estado);
		estado.setColumns(10);
		
		JButton btnRE = new JButton("Registrar");
		btnRE.setBounds(10, 350, 284, 21);
		btnRE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombreC = textnombre.getText();
	            int horaIn = Integer.parseInt(codigo.getText());
	            double horasT = Double.parseDouble(nota1.getText());
	            String nombrep = nombreP.getText();
	            AlquilarCancha est = new AlquilarCancha(horasT,horaIn,nombrep,nombreC);
				if(est.registrarTxt(Archivos.alquilerTexto)) {
					JOptionPane.showMessageDialog(btnRE, "Se registro correctamente");
					textnombre.setText("");
					codigo.setText("");
					nota1.setText("");
					cal.setText("");
					nombreP.setText("");
					
				}
				else {
					JOptionPane.showMessageDialog(btnRE, "Ocurrio un error (intentaste registrar a evo.. )");
				}
	
			}
		});
		Izquierda.add(btnRE);
		
		JButton btncalp = new JButton("Calcular total ganado");
		btncalp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ArrayList<AlquilarCancha> registro = AlquilarCancha.leerTxt(Archivos.alquilerTexto);
		            double total = 0.0;
		            for (AlquilarCancha a : registro) {
		                total += a.calcularCosto();
		            }
		            estado.setText(String.format("%.2f", total));
		            
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "No puedo leer el registro.");
		        }
			}
		});
		btncalp.setBounds(0, 490, 304, 21);
		Izquierda.add(btncalp);
		
		JLabel lblNewLabel_12 = new JLabel("Horas totales");
		lblNewLabel_12.setBounds(10, 148, 85, 13);
		Izquierda.add(lblNewLabel_12);
		
		JLabel ln = new JLabel("Nombre de usuario");
		ln.setBounds(10, 207, 146, 13);
		Izquierda.add(ln);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(368, 37, 304, 521);
		contentPane.add(panelCentral);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Reporte completo");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(lblNewLabel_1, BorderLayout.NORTH);
		
		
		String[] datosVotantes1 = new String[registro.size()];
        for (int i = 0; i < registro.size(); i++) {
            datosVotantes1[i] = registro.get(i).toString();  // Usar toString() de AlquilerCancha
        }
        
        JList<String> list;
        list = new JList<>();
        JScrollPane scrollPane = new JScrollPane(list);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        panelCentral.add(scrollPane, BorderLayout.CENTER);

		
		panelCentral.add(scrollPane, BorderLayout.CENTER);
		
		JPanel cenBon = new JPanel();
		panelCentral.add(cenBon, BorderLayout.SOUTH);
		
		JButton btn = new JButton("Mostrar reporte");
		btn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ArrayList<AlquilarCancha> registro = AlquilarCancha.leerTxt(Archivos.alquilerTexto);

		        String[] register = new String[registro.size()];
		        for (int i = 0; i < registro.size(); i++) {
		            register[i] = registro.get(i).toString();
		        }

		        list.setListData(register); // Aquí actualizas los datos del JList
		    }
		});

		cenBon.add(btn);
		
		JButton btnlimpiar = new JButton("Limpiar reporte");
		btnlimpiar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        list.setListData(new String[0]); // Limpia la lista
		    }
		});

		cenBon.add(btnlimpiar);
		
		JPanel paneDerecha = new JPanel();
		paneDerecha.setBounds(720, 37, 256, 521);
		contentPane.add(paneDerecha);
		paneDerecha.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Reporte de noche");
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
