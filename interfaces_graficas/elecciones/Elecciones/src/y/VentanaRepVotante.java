package y;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class VentanaRepVotante extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaRepVotante frame = new VentanaRepVotante();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaRepVotante() {
        // Leer votantes desde archivo
        ArrayList<Votante> votantes = Votante.leerVotanteTxt(Archivos.archivoVotante);

        // Crear arreglo de Strings para el JList
        String[] datosVotantes = new String[votantes.size()];
        for (int i = 0; i < votantes.size(); i++) {
            datosVotantes[i] = votantes.get(i).toString();
        }

        // Configuración general de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 656, 399);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel principal
        JPanel panPrincipal = new JPanel();
        panPrincipal.setBackground(new Color(128, 128, 255));
        contentPane.add(panPrincipal, BorderLayout.CENTER);
        panPrincipal.setLayout(new BorderLayout(5, 5));

        // Título
        JLabel lblTitulo = new JLabel("Votantes por Ciudad");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel panBotones = new JPanel();
        panBotones.setBackground(new Color(128, 128, 192));
        FlowLayout fl_panBotones = (FlowLayout) panBotones.getLayout();
        fl_panBotones.setAlignment(FlowLayout.RIGHT);
        panPrincipal.add(panBotones, BorderLayout.SOUTH);

        JButton btnModCandidato = new JButton("Modificar Votante");
        btnModCandidato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        panBotones.add(btnModCandidato);

        JButton btnMostrar = new JButton("Mostrar Todo");
        btnMostrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        panBotones.add(btnMostrar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        panBotones.add(btnEliminar);

        // Panel izquierdo
        JPanel panIzquierda = new JPanel();
        panIzquierda.setBackground(new Color(128, 128, 192));
        panPrincipal.add(panIzquierda, BorderLayout.WEST);
        panIzquierda.setLayout(new BorderLayout(0, 0));

        JLabel lblCiudad = new JLabel("Ciudad");
        lblCiudad.setHorizontalAlignment(SwingConstants.CENTER);
        lblCiudad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        panIzquierda.add(lblCiudad, BorderLayout.NORTH);

        // Lista de ciudades
        String[] ciudades = {
            "La Paz", "El Alto", "Santa Cruz", "Cochabamba",
            "Tarija", "Sucre", "Potosí", "Oruro", "Pando", "Beni"
        };
        JList<String> listCiudad = new JList<>(ciudades);
        JScrollPane scrollCiudad = new JScrollPane(listCiudad);
        panIzquierda.add(scrollCiudad, BorderLayout.CENTER);

        // Panel banderas
        JPanel panBanderas = new JPanel();
        panIzquierda.add(panBanderas, BorderLayout.SOUTH);
        panBanderas.setLayout(new BorderLayout(0, 0));

        JButton btnMostrarCiudad = new JButton("Mostrar");
        btnMostrarCiudad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        panBanderas.add(btnMostrarCiudad, BorderLayout.NORTH);

        JLabel lblImagen = new JLabel("Imagen");
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        panBanderas.add(lblImagen, BorderLayout.SOUTH);

        // Panel central con lista de votantes
        JPanel panCentro = new JPanel();
        panCentro.setLayout(new BorderLayout(0, 0));
        panPrincipal.add(panCentro, BorderLayout.CENTER);

        JLabel lblVotantes = new JLabel("Votantes por Ciudad");
        lblVotantes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblVotantes.setHorizontalAlignment(SwingConstants.CENTER);
        lblVotantes.setBackground(new Color(128, 128, 192));
        panCentro.add(lblVotantes, BorderLayout.NORTH);
        
        
        String[] datosVotantes1 = new String[votantes.size()];
        for (int i = 0; i < votantes.size(); i++) {
            datosVotantes1[i] = votantes.get(i).toString();  // Usar toString() de Votante
        }
        JList<String> listVotantes = new JList<>(datosVotantes);
        listVotantes.setBackground(new Color(192, 192, 192));
        JScrollPane scrollVotantes = new JScrollPane(listVotantes);
        panCentro.add(scrollVotantes, BorderLayout.CENTER);
  

    }
}
