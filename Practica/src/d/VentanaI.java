package d;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaI extends JFrame implements Archivos , Parametros {

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
	 * @throws IOException 
	 */
	public VentanaI() throws IOException {
		/*añadir esto*/
		ArrayList<AlquilarCancha> registro = AlquilarCancha.leerTxt(Archivos.alquilerTexto);
		ArrayList<AlquilarCancha> registroBin = AlquilarCancha.leeBin(Archivos.alquilerBinario);

        
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
	            if (Parametros.horalimite >horaIn) {
	            	if(est.registrarTxt(Archivos.alquilerTexto)) {
						JOptionPane.showMessageDialog(btnRE, "Se registro correctamente");
						textnombre.setText("");
						codigo.setText("");
						nota1.setText("");
						cal.setText("");
						nombreP.setText("");	
					}
					else {
						JOptionPane.showMessageDialog(btnRE, "Ocurrio un error");
					}
	            }
	            else {
	            	try {
						if(est.escribeBin(Archivos.alquilerBinario)) {
							JOptionPane.showMessageDialog(btnRE, "Se registro correctamente en binario");
							textnombre.setText("");
							codigo.setText("");
							nota1.setText("");
							cal.setText("");
							nombreP.setText("");	
						}
						else {
							JOptionPane.showMessageDialog(btnRE, "Ocurrio un error ");
						}
					} catch (HeadlessException | IOException e1) {
						// TODO Auto-generated catch block
						
					}
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
		            ArrayList<AlquilarCancha> registroBins = AlquilarCancha.leeBin(Archivos.alquilerBinario);
		            for (AlquilarCancha z : registroBins) {
						total+=z.calcularCosto();
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
		panelCentral.setBounds(342, 37, 330, 521);
		contentPane.add(panelCentral);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Reporte completo");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(lblNewLabel_1, BorderLayout.NORTH);
		
	
		/*Leer en la lista scrool*/
        JList<String> list;
        list = new JList<>();
        JScrollPane scrollPane = new JScrollPane(list);
        panelCentral.add(scrollPane, BorderLayout.CENTER);
        panelCentral.add(scrollPane, BorderLayout.CENTER);
		panelCentral.add(scrollPane, BorderLayout.CENTER);
		
		JPanel cenBon = new JPanel();
		panelCentral.add(cenBon, BorderLayout.SOUTH);
		
		JButton btn = new JButton("Mostrar registro");
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
		
		JPanel panelDerecha = new JPanel();
		panelDerecha.setBounds(705, 37, 276, 521);
		contentPane.add(panelDerecha);
		panelDerecha.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Registro noche");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelDerecha.add(lblNewLabel_2, BorderLayout.NORTH);
		
		/*leer en listas */	
		JList <String> list_binario  ;
		list_binario=new JList();
		list_binario.setBackground(new Color(255, 255, 255));
		JScrollPane scrollBinarios = new JScrollPane(list_binario);
		panelDerecha.add(scrollBinarios, BorderLayout.CENTER);
		
		
		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(64, 128, 128));
		panelDerecha.add(panel_botones, BorderLayout.SOUTH);
		
		JButton registroB = new JButton("Mostrar Registro");
		panel_botones.add(registroB);
		registroB.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ArrayList<AlquilarCancha> registroBin = AlquilarCancha.leeBin(Archivos.alquilerBinario);
		        String [] registerBin = new String[registroBin.size()];
		        for (int i = 0; i < registroBin.size(); i++) {
		            registerBin[i] = registroBin.get(i).toString(); // o usa registroBin.get(i)
		        }
		        list_binario.setListData(registerBin);
		    }
		});
		
		
		JButton Lbin = new JButton("Limpiar Registro");
		panel_botones.add(Lbin);
		Lbin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				list_binario.setListData(new String[0]);
			}
		});
	}
}
