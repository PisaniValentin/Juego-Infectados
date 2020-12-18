package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.Da�oDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
import Personajes.Personaje;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorInfectado extends Visitor {
	protected int da�o;

	public VisitorInfectado(GameObject o, Personaje personaje) {
		super(o);
	}

	public VisitorInfectado(GameObject o, int da�o) {
		super(o);
		this.da�o = da�o;
	}

	@Override
	public void visit(Infectado e) {
		e.descongelar();
	}

	@Override
	public void visit(ProyectilJugador d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub

	}

	public void visit(Jugador jugador) {
		jugador.recibirDa�o(da�o);
	}

	@Override
	public void visit(Congelacion c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Da�oDoble da�oDoble) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Pocion pocion) {
		// TODO Auto-generated method stub

	}

}
