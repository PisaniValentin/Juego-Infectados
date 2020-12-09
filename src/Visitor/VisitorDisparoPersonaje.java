package Visitor;


import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import Personajes.InfectadoAlpha;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDisparoPersonaje extends Visitor{
protected int daño;
	
	public VisitorDisparoPersonaje(GameObject o,int daño) {
		super(o);
		this.daño = daño;
	}

	@Override
	public void visit(InfectadoAlpha e) {
		e.recibirDaño(daño);
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
		
	}

	@Override
	public void visit(DañoDoble dañoDoble) {
	}
	


}
