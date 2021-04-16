import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Boggle extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    
    // Variables del programa
    String[] consonantes = {"B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T",
                            "V", "W", "X", "Y", "Z"};
    String[] vocales = {"A", "E", "I", "O", "U"};
    static int tam = 26;
    static Trie raiz;
    String nombre;

    // Variables de portada
    public JPanel portada;
    private JLabel etiqueta, descrip, descrip1, jess, alex, imagen, gif1;
    private JButton boton1;
    private JRadioButton politica;

    // Variables del inicio
    public JPanel inicio;
    private JLabel gif2;
    private JTextField usuario;
    private JButton comenzar, agregar;

    // Variables del juego
    public JPanel juego;
    private JLabel bienvenida;
    public static void main(String[] args) {
        Boggle Ventana = new Boggle();
        Ventana.setVisible(true);
    }
    // Clase del Trie
    static class Trie{
        Trie[] hijos = new Trie[tam];
        boolean fin;
        Trie(){
            fin=false;
            for(int i=0; i<tam; i++){
                hijos[i]=null;
            }
        }
    };
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
        // Reescalado de imagen
        imagen.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH))); 
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
    // Recoger informacion del archivo
    private void Insertar(String llave){
        int nivel, index;
        int largo = llave.length();
        Trie nodoAux = raiz;
        for(nivel=0; nivel<largo; nivel++){
            index = llave.charAt(nivel)-'a';
            if(nodoAux.hijos[index] == null){
                nodoAux.hijos[index] = new Trie();
            }
            nodoAux = nodoAux.hijos[index];
        }
        nodoAux.fin = true;
    }
    private boolean Buscar(String llave){
        int nivel, index;
        int largo = llave.length();
        Trie nodoAux = raiz;
        for(nivel=0; nivel<largo; nivel++){
            index = llave.charAt(nivel)-'a';
            if(nodoAux.hijos[index] == null){
                return false;
            }
            nodoAux = nodoAux.hijos[index];
        }
        return (nodoAux != null && nodoAux.fin);
    }
    private int Indice(String llave){
        int length = llave.length();
        int indice = 0;
        for(int i=0; i<length; i++){
            indice += llave.charAt(i);
        }
        return indice;
    }
    // Funciones de la pantalla de iniciar juego
    private void Inicio(){
        inicio = new JPanel();
        inicio.setLayout(null);
        this.getContentPane().add(inicio);
        CajaTexto();
        EtiquetasIn();
        BotonesIN();
        GifIN();
    }
    private void EtiquetasIn(){
        inicio.add(etiqueta);

        JLabel instruc = new JLabel("Ingresa un  nommbre de usuario:");
        instruc.setBounds(250, 50, 300, 40);
        instruc.setHorizontalAlignment(SwingConstants.LEFT);
        instruc.setFont(new Font ("arial",Font.BOLD,16));
        inicio.add(instruc);
    }
    private void CajaTexto(){
        usuario = new JTextField("Anonimo");
        usuario.setBounds(250, 100, 100, 25);
        inicio.add(usuario);
    }
    private void BotonesIN(){
        agregar = new JButton("Agregar");
        agregar.setBounds(370, 98, 100, 30);
        agregar.setEnabled(true);
        inicio.add(agregar);
        agregar.addActionListener(this);

        comenzar = new JButton("Comenzar");
        comenzar.setBounds(300, 130, 100, 30);
        comenzar.setEnabled(false);
        comenzar.setForeground(Color.GREEN);
        inicio.add(comenzar);
        comenzar.addActionListener(this);
    }
    private void GifIN(){
        ImageIcon gif = new ImageIcon("archivos\\john2.gif");
        gif2 = new JLabel(gif);
        gif2.setBounds(200, 170, 350, 300);
        inicio.add(gif2);
    }
    private void Juego(){
        juego = new JPanel();
        juego.setLayout(null);
        this.getContentPane().add(juego);
        Tablero();
        EtiquetasJ();
    }
    private void Tablero(){
        raiz = new Trie();
        try{
            File archivo = new File("archivos\\diccionario20202.txt");
            Scanner leer = new Scanner(archivo);
            while(leer.hasNextLine()){
                String data = leer.nextLine();
                Insertar(data);
            }
            leer.close();

        }catch(FileNotFoundException ex){
            System.out.println("ERROR");
            ex.printStackTrace();
        }
    }
    private void EtiquetasJ(){
        juego.add(etiqueta);

        bienvenida = new JLabel("Bienvenido '"+nombre+"'");
        bienvenida.setBounds(250, 40, 300, 40);
        bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        bienvenida.setFont(new Font ("arial",Font.BOLD,16));
        juego.add(bienvenida);
    }
    /*
    private void Fichero() throws IOException{
        FileWriter fw = new FileWriter("archivos\\puntuacion.txt",true);
        fw.write(usuario.getText());
        fw.close();
    }
    */
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
            // Quitamos la portada y mandamos a llamar el panel de inicio
            portada.setVisible(false);
            Inicio();
        }
        // Agregar usuario
        else if(evento == agregar){
            comenzar.setEnabled(true);
            nombre=usuario.getText();
        }
        else if(evento == comenzar){
            inicio.setVisible(false);
            Juego();
        }
    }
}
