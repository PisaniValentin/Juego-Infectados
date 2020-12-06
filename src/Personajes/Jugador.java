package Personajes;


import java.awt.Rectangle;

import Controladores.Controlador;
import Controladores.ControladorPersonaje;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje{
	
	
	protected VisitorJugador visitor;
	protected ControladorPersonaje controlador;
	public Jugador() {
		super(100,0,4);
		visitor = new VisitorJugador(this);
		controlador = new ControladorPersonaje();
		controlador.setPersonaje(this);
		arma.setRango(300);
		arma.setDaño(10);
		cambiarImagen("Imagenes/jugador.png");
		velocidad=6;
	}
	
	@Override
	public void atacar() {
	}
	

	public Controlador getControlador() {
		return controlador;
	}

	public void recibirDaño(int daño) {
		vida = vida - daño;
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

	@Override
	public void setVelocidad(int i) {
		velocidad = i;
		
	}

	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return velocidad;
	}


}
