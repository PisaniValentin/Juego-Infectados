package Personajes;

import GameObjects.GameObject;
public abstract class Personaje extends GameObject{
	protected int ancho, alto,rango,velocidad,cargaViral;
	protected Arma arma;
	
	public abstract void atacar();
	public abstract void interactuar();
	public abstract void mover();
	public abstract void setVelocidad(int i);
	public abstract int getVelocidad();
	
	protected Personaje(int cargaViral,int velocidad) {
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
	
	public int getCargaViral() {
		return cargaViral;
	}

	

}
