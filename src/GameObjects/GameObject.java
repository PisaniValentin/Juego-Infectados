package GameObjects;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Controlador;
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

	public abstract Rectangle getHitbox();

	public abstract Controlador getControlador();

	public abstract void mover();

	public abstract void accept(Visitor visitor);

	public Visitor getVisitor() {
		return visitor;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Mapa getMapa() {
		return mapa;
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

	public void setPunto(Punto p) {
		punto = p.clone();
	}

	public void cambiarImagen(String rutaDibujo) {
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getClassLoader().getResource(rutaDibujo));
		imagen = new JLabel(icono_imagen);
		ancho = icono_imagen.getIconWidth();
		alto = icono_imagen.getIconHeight();
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(String ruta) {
		ImageIcon dibujo = new ImageIcon(this.getClass().getClassLoader().getResource(ruta));
		imagen.setIcon(dibujo);
		imagen.setSize(ancho + 2, alto + 2);
	}

}
