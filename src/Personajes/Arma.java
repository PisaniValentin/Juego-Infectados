package Personajes;

public class Arma {
protected int rango,da�o;
	
	public Arma(int rango, int da�o) {
		this.rango = rango;
		this.da�o = da�o;
	}
	
	public int getRango() {
		return rango;
	}
	
	public int getDa�o() {
		return da�o;
	}
	
	public void setRango(int rango) {
		this.rango = rango;
	}
	
	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}
}
