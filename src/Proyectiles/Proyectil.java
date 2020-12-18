package Proyectiles;

import GameObjects.GameObject;
import Juego.GUI;
import Juego.Punto;

public abstract class Proyectil extends GameObject {
	protected int rango, da�o, velocidad;
	protected GUI frame;

	public Proyectil(int rango, int da�o, Punto punto) {
		this.rango = rango;
		this.da�o = da�o;
		this.punto = punto;
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
