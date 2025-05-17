package d;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JList;

public class Ventanaprubas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanaprubas frame = new Ventanaprubas();
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
	public Ventanaprubas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Pruebas");
		lblNewLabel.setBackground(new Color(0, 128, 64));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		
		JList <String> lista;
		lista=new JList();
		JScrollPane scrollG = new JScrollPane(lista);
		panel.add(scrollG, BorderLayout.CENTER);
		
		lista.setListData(new String[0]);	
		//lista.setListData(register);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 0, 128));
		contentPane.add(panel_1, BorderLayout.SOUTH);
	}

}
