package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DaņoDoble;
import Personajes.InfectadoAlpha;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDaņoDoble extends Visitor
{

	public VisitorDaņoDoble(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(InfectadoAlpha e) {
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

	@Override
	public void visit(Jugador d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Congelacion c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DaņoDoble daņoDoble) {
		// TODO Auto-generated method stub
		
	}

}
