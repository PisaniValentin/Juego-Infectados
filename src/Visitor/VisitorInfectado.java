package Visitor;

import GameObjects.GameObject;
import Personajes.Infectado;
import Personajes.Jugador;
import Personajes.Personaje;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorInfectado extends Visitor {

	public VisitorInfectado(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Infectado e) {
		System.out.println("entra a22");
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
	public void visit(Jugador jugador) {
		jugador.recibirDaņo();
	}

}
