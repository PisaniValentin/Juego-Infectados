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
	
	public void recibirDaño() {
		vida = vida -10;
		System.out.println("el jugador recibio daño"+vida);
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
		visitor.visit(this);
	}

	@Override
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(),this.getPunto().getY(),this.getAncho(),this.getAlto());
	}


}
