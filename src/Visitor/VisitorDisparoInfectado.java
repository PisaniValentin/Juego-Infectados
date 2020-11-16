package Visitor;

import GameObjects.GameObject;
import Personajes.Infectado;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDisparoInfectado extends Visitor {

	public VisitorDisparoInfectado(GameObject o) {
		super(o);
	}

	@Override
	public void visit(ProyectilJugador d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Infectado e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub
		
	}
	

}
