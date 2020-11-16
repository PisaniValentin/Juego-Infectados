package Personajes;

import java.awt.Rectangle;

import javax.swing.JLabel;

import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
public abstract class Personajes extends GameObject{
	protected int ancho;
	protected int largo;
	protected JLabel labelImagen;
	protected Punto punto;
	protected JLabel imagen;
	protected int vidas,cargaViral,velocidad;
	protected Mapa mapa;
	
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
		
	}

}
