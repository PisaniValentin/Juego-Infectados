package GameObjects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;

public abstract class GameObject {
	protected Mapa mapa;
	protected int ancho;
	protected int alto;
	protected Punto punto;
	protected JLabel imagen;
	protected Visitor visitor;
	
	public abstract void accept(Visitor visitor);
	
	public Visitor getVisitor() {
		return visitor ;
	}
	
	public void setMapa(Mapa mapa) {
		this.mapa = mapa ;
	}
	public Mapa getMapa() {
		return mapa ;
	}
	
	public int getAncho() {
		return ancho ;
	}
	public int getLargo() {
		return alto ;
	}	
	public Punto getPunto() {
		return punto ;
	}
	public void setPunto(Punto p) {
		punto = p ;
	}
	
	public void cambiarImagen(String rutaDibujo) {
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getClassLoader().getResource(rutaDibujo));
		imagen = new JLabel(icono_imagen);
		ancho = icono_imagen.getIconWidth();
		alto = icono_imagen.getIconHeight();
	}
	
	public JLabel getImagen() {
		return imagen ;
	}
	public void setImagen(JLabel imagen) {
		this.imagen = imagen ;
	}
}
