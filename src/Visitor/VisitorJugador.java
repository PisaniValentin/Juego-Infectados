package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorJugador extends Visitor {

	public VisitorJugador(GameObject o) {
		super(o);
	}

	@Override
	public void visit(Infectado e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ProyectilJugador d) {
		// no debe hacer nada
	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Jugador d) {

	}

	@Override
	public void visit(Congelacion c) {
		c.getMapa().crearTemporizadorHielo(c);
	}

	@Override
	public void visit(DañoDoble dañoDoble) {
		obj.accept(dañoDoble.getVisitor());
	}

	@Override
	public void visit(Pocion pocion) {
		obj.accept(pocion.getVisitor());
	}

}
