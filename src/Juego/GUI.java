package Juego;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	protected JPanel calle;
	protected Mapa mapa;
	private CustomPanel contentPane;
	protected JLabel etiquetaVida,etiquetaOleada,etiquetaVidaActual,etiquetaOleadaActual;

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 541);
		contentPane = new CustomPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		etiquetaVida = new JLabel("Vida:");
		etiquetaVida.setSize(80, 70);
		etiquetaVida.setLocation(150, 450);
		etiquetaVida.setForeground(Color.white);
		contentPane.add(etiquetaVida);
		
		etiquetaVidaActual = new JLabel("100");
		etiquetaVidaActual.setSize(85, 70);
		etiquetaVidaActual.setLocation(180, 450);
		etiquetaVidaActual.setForeground(Color.white);
		contentPane.add(etiquetaVidaActual);
		
		etiquetaOleada = new JLabel("Oleada:");
		etiquetaOleada.setSize(80, 70);
		etiquetaOleada.setLocation(30, 450);
		etiquetaOleada.setForeground(Color.white);
		contentPane.add(etiquetaOleada);
		
		etiquetaOleadaActual = new JLabel("");
		etiquetaOleadaActual.setSize(80, 70);
		etiquetaOleadaActual.setLocation(80, 450);
		etiquetaOleadaActual.setForeground(Color.white);
		contentPane.add(etiquetaOleadaActual);
		
		
	}
	
	
	public void actualizarEtiquetaVida(int vida) {
		etiquetaVidaActual.setText(""+vida);
	}
	
	public void actualizarEtiquetaOleada(int oleada) {
		etiquetaOleadaActual.setText(""+oleada);
	}

	public void setMapa(Mapa m) {
		mapa = m;
	}
}
