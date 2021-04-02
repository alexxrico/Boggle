import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
public class Boggle extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    
    // Variables de portada
    public JPanel portada;
    private JLabel etiqueta, descrip, descrip1, jess, alex, imagen, gif1;
    private JButton boton1;
    private JRadioButton politica;
    // Variables del inicio
    public JPanel inicio;
    public static void main(String[] args) {
        Boggle Ventana = new Boggle();
        Ventana.setVisible(true);
    }
    public Boggle(){
        setSize(800,500); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Terminar ejecucion al cerrar ventana
        setTitle("BOGGLE");
        setLocationRelativeTo(null); // Pantalla en el centro
        Portada();
    }
    // Diseño de la ventda de la portada
    private void Portada(){
        
        PanelesP();
        EtiquetasP();
        IconsP();
        BotonesP();
        RadioBoton();
        Gif();
    }
    private void PanelesP(){
        portada = new JPanel(); // Creacion del portada
        portada.setLayout(null);
        this.getContentPane().add(portada);
    }
    private void EtiquetasP(){
        etiqueta = new JLabel("JUEGO BOGGLE!!");
        etiqueta.setBounds(250, 5, 300, 40);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setFont(new Font ("arial",Font.BOLD,20)); // Estilo de la letra
        portada.add(etiqueta);

        descrip = new JLabel("Bienvenido al juego Boggle!!");
        descrip.setBounds(430, 50, 300, 40);
        descrip.setHorizontalAlignment(SwingConstants.LEFT);
        descrip.setFont(new Font ("arial",Font.BOLD,18));
        portada.add(descrip);

        descrip1 = new JLabel("¿Lograras susperar el reto John Cena?");
        descrip1.setBounds(380, 80, 350, 40);
        descrip1.setHorizontalAlignment(SwingConstants.LEFT);
        descrip1.setFont(new Font ("arial",Font.BOLD,18));
        portada.add(descrip1);

        jess = new JLabel("Jessica Yamile Salcido Cadena - 329575");
        jess.setBounds(30, 390, 350, 40);
        jess.setHorizontalAlignment(SwingConstants.LEFT);
        jess.setFont(new Font ("arial",Font.BOLD,16));
        portada.add(jess);

        alex = new JLabel("David Alejandro Perez Rico - 320753");
        alex.setBounds(30, 420, 350, 40);
        alex.setHorizontalAlignment(SwingConstants.LEFT);
        alex.setFont(new Font ("arial",Font.BOLD,16));
        portada.add(alex);
    }
    private void IconsP(){
        ImageIcon imagen1 = new ImageIcon("archivos\\uach.png");
        imagen = new JLabel();
        imagen.setBounds(70, 50, 250, 340);
        imagen.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH))); // Reescalado de imagen
        portada.add(imagen);
    }
    private void BotonesP(){
        boton1 = new JButton();
        boton1.setText("START");
        boton1.setEnabled(false); // Boton habilitado
        boton1.setBounds(500, 400, 100, 40);
        boton1.setForeground(Color.GREEN);
        boton1.setFont(new Font("arial",Font.BOLD,18));
        portada.add(boton1);
        
        boton1.addActionListener(this);
    }
    private void RadioBoton(){
        politica = new JRadioButton("Acepto las consecuencias del reto JOHN CENA!");
        politica.setBounds(400, 360, 400, 20);
        portada.add(politica);
        
        politica.addActionListener(this);
    }
    private void Gif(){
        ImageIcon gif = new ImageIcon("archivos\\john1.gif");
        gif1 = new JLabel(gif);
        gif1.setBounds(350, 120, 400, 200);
        portada.add(gif1);
    }
    private void VaciarVentana(){
        etiqueta.setVisible(false);
        descrip.setVisible(false);
        descrip1.setVisible(false);
        jess.setVisible(false);
        alex.setVisible(false);
        imagen.setVisible(false);
        gif1.setVisible(false);
        politica.setVisible(false);
        boton1.setVisible(false);

        portada.setVisible(false);
    }
    private void Inicio(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evento = e.getSource();
        // Evento si se selecciona el boton de aceptar concecuencias
        if(evento == politica){
            if(politica.isSelected()==true){
                boton1.setEnabled(true); 
            }else{
                boton1.setEnabled(false);
            }
        }
        // Evento si se selecciona el boton de "Satrt"
        else if(evento == boton1){
            VaciarVentana();
            Inicio();
        }
    }
}
