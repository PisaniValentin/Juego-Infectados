package Personajes;

import Juego.Mapa;
import Juego.Punto;

public class InfectadoBeta extends Infectado {
	protected Punto p;

	public InfectadoBeta(Punto p, Mapa map) {
		super(p, map);
		mapa = map;
		this.cambiarImagen("Imagenes/zombieBeta.gif");
		velocidad = 1;
		arma = new Arma(30, 20);
	}

	public void descongelar() {
		velocidad = 1;
		this.setImagen("Imagenes/zombieBeta.gif");
	}

}
