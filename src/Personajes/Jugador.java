package Personajes;

import java.awt.Rectangle;

import Controladores.Controlador;
import Controladores.ControladorPersonaje;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {
	protected ControladorPersonaje controlador;
	protected boolean buff;

	public Jugador() {
		super(0, 8);
		visitor = new VisitorJugador(this);
		controlador = new ControladorPersonaje(this);
		controlador.setPersonaje(this);
		arma.setRango(300);
		arma.setDaño(20);
		cambiarImagen("Imagenes/jugador.png");
		velocidad = 6;
		buff = false;
	}

	@Override
	public void atacar() {
	}

	public boolean isBuffed() {
		return buff;
	}

	public void setBuff(boolean buff) {
		this.buff = buff;
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void recibirDaño(int daño) {
		cargaViral = cargaViral + daño;
		if (cargaViral>=100) {
			System.out.println("Perdio");
			this.controlador.interrupt();
		}
		System.out.println("el jugador recibio daño" + cargaViral);
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
		return new Rectangle(this.getPunto().getX(), this.getPunto().getY(), this.getAncho(), this.getAlto());
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
