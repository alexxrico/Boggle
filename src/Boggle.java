import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class Boggle extends JFrame{
    public JPanel panel;
    private static final long serialVersionUID = 1L;
    public Boggle(){
        setSize(800,500); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Terminar ejecucion al cerrar ventana
        setTitle("BOGGLE");
        setLocationRelativeTo(null); // Pantalla en el centro
        IniciarComponentes();
        
    }
    private void IniciarComponentes(){
        Paneles();
        Etiquetas();
        Icons();
        
    }
    private void Paneles(){
         panel = new JPanel(); // Creacion del panel
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void Etiquetas(){
        JLabel etiqueta = new JLabel("JUEGO BOGGLE!!");
        panel.add(etiqueta);
        etiqueta.setBounds(250, 5, 300, 40);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setFont(new Font ("arial",Font.BOLD,20)); // Estilo de la letra
    }
    private void Icons(){
        ImageIcon imagen1 = new ImageIcon("uach.png");
        JLabel imagen = new JLabel ();
        imagen.setBounds(40, 50, 320, 400);
        imagen.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH))); // Reescalado de imagen
        panel.add(imagen);
    }
    public static void main(String[] args) {
        Boggle Ventana = new Boggle();
        Ventana.setVisible(true);
    }
}
