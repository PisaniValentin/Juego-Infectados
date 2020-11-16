package Visitor;

import GameObjects.GameObject;
import Personajes.Infectado;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public abstract class Visitor {
protected GameObject obj;
	
	public Visitor(GameObject o) {
		obj = o;		
	}
	public abstract void visit(Infectado e);
	
	public abstract void visit(ProyectilJugador d);
	
	public abstract void visit(ProyectilInfectado d);

}
