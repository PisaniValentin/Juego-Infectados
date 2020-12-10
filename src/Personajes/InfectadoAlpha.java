package Personajes;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;

public class InfectadoAlpha extends Infectado {

	public InfectadoAlpha(Punto p, Mapa map) {
		super(p,map);
		this.cambiarImagen("Imagenes/InfectadoAlpha.gif");
		velocidad = 2;
		arma = new Arma(30, 30);
	}

	public void descongelar() {
		velocidad = 2;
		this.setImagen("Imagenes/InfectadoAlpha.gif");
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	

}
