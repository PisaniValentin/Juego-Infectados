package Proyectiles;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;

public abstract class Proyectil extends GameObject{
protected int rango,daño,velocidad,ancho,alto;
protected JLabel imagen;
protected Punto punto;	
protected Mapa mapa;
protected JPanel frame;
	
	public Proyectil(int rango,int daño,Punto punto) {
		this.rango = rango;
		this.daño = daño;
		this.punto = punto;
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getClassLoader().getResource("Imagenes/disparo.gif"));
		imagen = new JLabel(icono_imagen);
		ancho = icono_imagen.getIconWidth();
		alto = icono_imagen.getIconHeight();
		
	}
	public abstract Rectangle getHitbox();
	
	public void setFrame(JPanel frame) {
		this.frame = frame;
	}
	public JPanel getFrame() {
		return frame;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa ;
	}
	public Mapa getMapa() {
		return mapa ;
	}
	
	public void mover() {
		
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public Punto getPunto() {
		return punto;
	}
	
	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	
	public JLabel getImagen() {
		return imagen;
	}
	
	public int getRango() {
		return rango;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
	
}
