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
