package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorPremios extends Visitor {

	public VisitorPremios(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Infectado e) {
		if (!e.estaQuieto()) {
			e.setVelocidad(0);
			e.setImagen("Imagenes/congelado.png");
		} else {
			e.descongelar();
		}
	}

	@Override
	public void visit(ProyectilJugador d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Jugador d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Congelacion c) {
		c.congelar();
	}

	@Override
	public void visit(DañoDoble dañoDoble) {
		dañoDoble.buff();
	}

	@Override
	public void visit(Pocion pocion) {
		// TODO Auto-generated method stub
		
	}

}
