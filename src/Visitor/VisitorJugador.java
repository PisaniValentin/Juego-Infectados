package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import Personajes.InfectadoAlpha;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorJugador extends Visitor {

	public VisitorJugador(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(InfectadoAlpha e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ProyectilJugador d) {
		//no debe hacer nada
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
		// TODO Auto-generated method stub
		System.out.println("entre al visitor de jugador");
	}

	@Override
	public void visit(DañoDoble dañoDoble) {

		// TODO Auto-generated method stub
		
	}
	
	
	
}
