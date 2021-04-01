import javax.swing.JFrame;
public class Boggle extends JFrame{
    private static final long serialVersionUID = 1L;
    public Boggle(){
        setSize(500,500); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Terminar ejecucion al cerrar ventana
        setTitle("Boggle");
        setLocationRelativeTo(null); // Pantalla en el centro
    }
    public static void main(String[] args) {
        Boggle p1 = new Boggle();
        p1.setVisible(true);
    }
}
