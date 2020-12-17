package Proyectiles;

import GameObjects.GameObject;
import Juego.GUI;
import Juego.Punto;

public abstract class Proyectil extends GameObject {
	protected int rango, daño, velocidad;
	protected GUI frame;

	public Proyectil(int rango, int daño, Punto punto) {
		this.rango = rango;
		this.daño = daño;
		this.punto = punto;
//		ImageIcon icono_imagen = new ImageIcon(this.getClass().getClassLoader().getResource("Imagenes/disparo.gif"));
//		imagen = new JLabel(icono_imagen);
//		ancho = icono_imagen.getIconWidth();
//		alto = icono_imagen.getIconHeight();
	}

	public void remove() {
		mapa.getGui().remove(this.getImagen());
	}

	public void setFrame(GUI gui) {
		this.frame = gui;
	}

	public GUI getFrame() {
		return frame;
	}

	public int getRango() {
		return rango;
	}


	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

}
