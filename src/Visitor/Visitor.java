package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.Da�oDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
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

	public abstract void visit(Jugador d);

	public abstract void visit(Congelacion c);

	public abstract void visit(Da�oDoble da�oDoble);

	public abstract void visit(Pocion pocion);

}
