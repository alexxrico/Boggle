import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class Boggle extends JFrame{
    private static final long serialVersionUID = 1L;
    public Boggle(){
        setSize(500,500); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Terminar ejecucion al cerrar ventana
        setTitle("BOGGLE");
        setLocationRelativeTo(null); // Pantalla en el centro
        IniciarComponentes();
    }
    private void IniciarComponentes(){
        JPanel panel = new JPanel(); // Creacion del panel
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        JLabel etiqueta = new JLabel("JUEGO BOGGLE!!");
        panel.add(etiqueta);
        etiqueta.setBounds(85, 5, 300, 80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setFont(new Font ("arial",Font.BOLD,20)); // Estilo de la letra

        JLabel imagen = new JLabel (new ImageIcon("uach.png"));
        imagen.setBounds(40, 80, 400, 400);
        panel.add(imagen);
    }
    public static void main(String[] args) {
        Boggle Ventana = new Boggle();
        Ventana.setVisible(true);
    }
}
