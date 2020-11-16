package Juego;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.Controlador;
import Controladores.ControladorProyectiles;
import Personajes.Jugador;
import Personajes.Personajes;
import Proyectiles.Proyectil;
import Proyectiles.ProyectilJugador;

import java.awt.FlowLayout;

public class GUI extends JFrame {
protected JPanel calle;
protected Mapa mapa;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI frame = new GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		calle = new JPanel();
		calle.setBounds(92, 11, 211, 245);
		contentPane.add(calle);
		calle.setLayout(null);
	
	}
	
	public JPanel getTerreno() {
		return calle;
	}
	

	public void agregarJugador(Personajes p) {
//		//this.addKeyListener((Jugador) p);
//		int x = p.getPunto().getX();
//		int y = p.getPunto().getY();
//		int ancho = p.getAncho() ;
//		int alto = p.getLargo();
//		JLabel imagen = p.getImagen();
//		//imagen.setBounds(79, 196, largo,ancho );
//		imagen.setLocation(x,y);
//		imagen.setSize(ancho, alto);
//		calle.add(imagen);
//		imagen.setVisible(true);
//		calle.repaint();
	}
	
	public void setMapa(Mapa m) {
		mapa = m;
	}
}
