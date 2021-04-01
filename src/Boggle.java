import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        this.getContentPane().add(panel);
        
        JLabel etiqueta = new JLabel("Juego Boggle!!");
        panel.add(etiqueta);
    }
    public static void main(String[] args) {
        Boggle Ventana = new Boggle();
        Ventana.setVisible(true);
    }
}
