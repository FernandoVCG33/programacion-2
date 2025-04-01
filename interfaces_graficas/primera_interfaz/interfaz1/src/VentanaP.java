import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class VentanaP extends JFrame {
    static final int ALTO=400;
    static final int ANCHO=600;
    JPanel pan;
    public VentanaP() {
        this.setTitle("ventana de inicio");
        this.setSize(ANCHO, ALTO);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(300, 100);
        pan=new JPanel();
        pan.setLayout(new BorderLayout(10,10));
        pan.setBackground(Color.BLUE);

        getContentPane().add(pan);
        //botones
        JButton btnAceptar=new JButton("Aceptar");
        JButton btnCancelar=new JButton("Cancelar");
        JButton btnLimpiar=new JButton("Limpiar");
        JButton btnAdelante=new JButton("Adelante>>");
        JLabel lb= new JLabel("Ingresa tu nombre:") ;
        JTextField txtTexto= new JTextField(20) ;
        JPanel pan1= new JPanel() ;
        pan1.setBackground(Color.black);
        JPanel pan2= new JPanel() ;
        pan2.setBackground(Color.cyan);
        pan2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JPanel pan3= new JPanel() ;
        pan3.setLayout(new BoxLayout(pan3,BoxLayout.Y_AXIS));
        pan3.setBackground(Color.green);
        JPanel pan4= new JPanel() ;
        pan4.setBackground(Color.red);
        JPanel pan5= new JPanel(new GridLayout(2,2,5,5)) ;
        pan5.setBackground(Color.MAGENTA);
		/*
		pan.add(btnAceptar);
		pan.add(btnCancelar);
		pan.add(btnLimpiar);
		pan.add(btnAdelante);
		pan.add(txtTexto);
		*/
        /*memorizar que hace cada layout*/
        pan.add(pan1,BorderLayout.NORTH);
        pan.add(pan2,BorderLayout.SOUTH);
        pan.add(pan3,BorderLayout.WEST);
        pan.add(pan4,BorderLayout.EAST);
        pan.add(pan5,BorderLayout.CENTER);
        pan1.add(btnAdelante);
        pan2.add(btnLimpiar);
        pan3.add(btnCancelar);
        pan4.add(btnAceptar);
        pan5.add(lb);
        pan5.add(txtTexto);

        pan3.add(new JButton("boton1"));
        pan3.add(new JButton("boton2"));
        pan3.add(new JButton("boton3"));

        btnLimpiar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                txtTexto.setText("");
            }
        } );
        btnCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showConfirmDialog(pan5, "estas seguro de cncelar (te voy a funar!!)");

            }
        });
        btnAceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(pan4, "se registro correctamente");
            }
        });
        btnAdelante.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Ventana2 v2 = new Ventana2();
                v2.setVisible(true);
            }
        });
    }

}