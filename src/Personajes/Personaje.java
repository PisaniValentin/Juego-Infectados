package Personajes;

import GameObjects.GameObject;
public abstract class Personaje extends GameObject{
	protected int ancho, alto,rango;
	protected int vida,cargaViral,velocidad;
	
	public abstract void atacar();
	public abstract void interactuar();
	public abstract void mover();
	
	protected Personaje(int vidas ,int cargaViral,int velocidad) {
		this.vida = vidas;
		this.cargaViral = cargaViral;
		this.velocidad = velocidad;
		imagen=null;
		punto=null;
		rango=0;
	}
	
	public int getRango() {
		return rango;
	}
	public int getVida() {
		return vida;
	}
	public abstract void setVelocidad(int i);
		
	public abstract int getVelocidad();
	

}
