package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
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
		// TODO Auto-generated method stub
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
		jugador.recibirDaño();
	}

	@Override
	public void visit(Congelacion c) {
		// TODO Auto-generated method stub
		
	}

}
