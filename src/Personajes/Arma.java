package Personajes;

public class Arma {
protected int rango,daño;
	
	public Arma(int rango, int daño) {
		this.rango = rango;
		this.daño = daño;
	}
	
	public int getRango() {
		return rango;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public void setRango(int rango) {
		this.rango = rango;
	}
	
	public void setDaño(int daño) {
		this.daño = daño;
	}
}
