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
public class Boggle extends JFrame{
    private static final long serialVersionUID = 1L;
    
    // Variables de portada
    public JPanel panel;
    private JButton boton1;
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
    }
    private void PanelesP(){
        panel = new JPanel(); // Creacion del panel
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void EtiquetasP(){
        JLabel etiqueta = new JLabel("JUEGO BOGGLE!!");
        etiqueta.setBounds(250, 5, 300, 40);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setFont(new Font ("arial",Font.BOLD,20)); // Estilo de la letra
        panel.add(etiqueta);

        JLabel descrip = new JLabel("Bienvenido al juego Boggle!!");
        descrip.setBounds(430, 100, 300, 40);
        descrip.setHorizontalAlignment(SwingConstants.CENTER);
        descrip.setFont(new Font ("arial",Font.BOLD,18));
        panel.add(descrip);

        JLabel descrip1 = new JLabel("¿Lograras susperar el reto John Cena?");
        descrip1.setBounds(400, 120, 350, 40);
        descrip1.setHorizontalAlignment(SwingConstants.CENTER);
        descrip1.setFont(new Font ("arial",Font.BOLD,18));
        panel.add(descrip1);

        JLabel jess = new JLabel("Jessica Yamile Salcido Cadena - 329575");
        jess.setBounds(400, 180, 350, 40);
        jess.setHorizontalAlignment(SwingConstants.CENTER);
        jess.setFont(new Font ("arial",Font.BOLD,18));
        panel.add(jess);

        JLabel alex = new JLabel("David Alejandro Perez Rico - 320753");
        alex.setBounds(400, 200, 350, 40);
        alex.setHorizontalAlignment(SwingConstants.CENTER);
        alex.setFont(new Font ("arial",Font.BOLD,18));
        panel.add(alex);
    }
    private void IconsP(){
        ImageIcon imagen1 = new ImageIcon("uach.png");
        JLabel imagen = new JLabel ();
        imagen.setBounds(40, 50, 320, 400);
        imagen.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH))); // Reescalado de imagen
        panel.add(imagen);
    }
    private void BotonesP(){
        boton1 = new JButton();
        boton1.setText("START");
        boton1.setEnabled(false); // Boton habilitado
        boton1.setBounds(540, 400, 100, 40);
        boton1.setForeground(Color.GREEN);
        boton1.setFont(new Font("arial",Font.BOLD,18));
        panel.add(boton1);
    }
    private void RadioBoton(){
        JRadioButton politica = new JRadioButton("Acepto las consecuencias del reto JOHN CENA!");
        politica.setBounds(400, 360, 400, 20);
        panel.add(politica);
        ActionListener accion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(politica.isSelected()==true){
                    boton1.setEnabled(true);
                }else{
                    boton1.setEnabled(false);
                }
            }
        };
        politica.addActionListener(accion);
    }
}
