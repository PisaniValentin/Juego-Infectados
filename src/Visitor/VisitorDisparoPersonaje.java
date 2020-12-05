package Visitor;

import GameObjects.GameObject;
import Juego.Mapa;
import ObjetosTemporales.Congelacion;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDisparoPersonaje extends Visitor{
protected Mapa map;
	public VisitorDisparoPersonaje(GameObject o,Mapa map) {
		super(o);
		this.map = map;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Infectado e) {
		System.out.println("pegue2");
		e.recibirDaño();
	}

	@Override
	public void visit(ProyectilJugador d) {
		// TODO Auto-generated method stub
		//System.out.println("entre aca1");
		System.out.println("toca con disparo");
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
		System.out.println("entra visitor");
		c.congelar();
	}

}
