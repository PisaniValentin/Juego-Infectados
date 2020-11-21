package Personajes;


import java.awt.Rectangle;

import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje{
	
	
	protected VisitorJugador visitor;

	public Jugador() {
		super(100,0,4);
		visitor = new VisitorJugador(this);
		rango=300;
		cambiarImagen("Imagenes/jugador.png");
	}
	
	@Override
	public void atacar() {
	}

	@Override
	public void interactuar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor visitor) {
		
	}

	@Override
	public Rectangle getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}


}
