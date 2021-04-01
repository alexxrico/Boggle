/*
    Prueba de ventanas con java
*/
import javax.swing.JFrame;

public class Prueba extends JFrame {
    private static final long serialVersionUID = 1L;
    public Prueba(){
        setSize(500,500); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Terminar ejecucion al cerrar ventana
        setTitle("Boggle");
        setLocationRelativeTo(null); // Pantalla en el centro
    }
    public static void main(String[] args) {
        Prueba p1 = new Prueba();
        p1.setVisible(true);
    }
}
