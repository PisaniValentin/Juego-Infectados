package Personajes;

import java.awt.Rectangle;

import javax.swing.JLabel;

import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
public abstract class Personajes extends GameObject{
	protected int ancho, alto,rango;
	protected JLabel labelImagen;
	protected Punto punto;
	protected JLabel imagen;
	protected int vidas,cargaViral,velocidad;
	
	public abstract void atacar();
	public abstract void interactuar();
	public abstract void mover();
	public abstract Rectangle getHitbox();
	
	protected Personajes(int vidas ,int cargaViral,int velocidad) {
		this.vidas = vidas;
		this.cargaViral = cargaViral;
		this.velocidad = velocidad;
		imagen=null;
		punto=null;
		rango=0;
	}
	
	public int getRango() {
		return rango;
	}

}
