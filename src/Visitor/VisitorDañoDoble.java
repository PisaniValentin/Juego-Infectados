package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.Da�oDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDa�oDoble extends Visitor
{

	public VisitorDa�oDoble(GameObject o) {
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

	@Override
	public void visit(Jugador d) {
		// TODO Auto-generated method stub
		
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
