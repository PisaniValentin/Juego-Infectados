package Visitor;

import GameObjects.GameObject;
import Personajes.Infectado;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDisparoPersonaje extends Visitor{

	public VisitorDisparoPersonaje(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Infectado e) {
		e.recibirDaño();
	}

	@Override
	public void visit(ProyectilJugador d) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub
	}

}
