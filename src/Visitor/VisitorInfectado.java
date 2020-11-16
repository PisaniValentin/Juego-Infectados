package Visitor;

import GameObjects.GameObject;
import Personajes.Infectado;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorInfectado extends Visitor {

	public VisitorInfectado(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Infectado e) {
		System.out.println("entra aca2");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ProyectilJugador d) {
		System.out.println("entra aca visitorInfectado");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub
		
	}

}
