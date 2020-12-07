package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDisparoPersonaje extends Visitor{
protected int daño;
	public VisitorDisparoPersonaje(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	
	public VisitorDisparoPersonaje(GameObject o,int daño) {
		super(o);
		this.daño = daño;
	}

	@Override
	public void visit(Infectado e) {
		e.recibirDaño(daño);
	}

	@Override
	public void visit(ProyectilJugador d) {
		// TODO Auto-generated method stub
		//System.out.println("entre aca1");
	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub
		//System.out.println("entre aca2");
	}

	@Override
	public void visit(Jugador d) {
		// TODO Auto-generated method stub
		//System.out.println("entre aca3");
		
	}

	@Override
	public void visit(Congelacion c) {
		c.congelar();
	}

	@Override
	public void visit(DañoDoble dañoDoble) {
		dañoDoble.buff();
	}
	


}
