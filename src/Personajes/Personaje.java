package Personajes;

import GameObjects.GameObject;
public abstract class Personaje extends GameObject{
	protected int ancho, alto,rango;
	protected int vida,cargaViral,velocidad;
	protected Arma arma;
	
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
		this.arma = new Arma(0,0);
	}
	public int getDaño() {
		return arma.getDaño();
	}
	
	public int getRango() {
		return arma.getRango();
	}
	
	public Arma getArma() {
		return arma;
	}
	
	public void setArma(Arma arma) {
		this.arma=arma;
	}
	
	public int getVida() {
		return vida;
	}
	public abstract void setVelocidad(int i);
		
	public abstract int getVelocidad();
	

}
