package Proyectiles;

import java.awt.Rectangle;

import Controladores.Controlador;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDisparoInfectado;

public class ProyectilInfectado extends Proyectil {
	protected Visitor visitor;

	public ProyectilInfectado(int rango, int daño, Punto punto) {
		super(rango, daño, punto);
		visitor = new VisitorDisparoInfectado(this);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Rectangle getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Controlador getControlador() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
