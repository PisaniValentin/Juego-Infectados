package Visitor;


import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.Da�oDoble;
import Personajes.InfectadoAlpha;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDisparoPersonaje extends Visitor{
protected int da�o;
	
	public VisitorDisparoPersonaje(GameObject o,int da�o) {
		super(o);
		this.da�o = da�o;
	}

	@Override
	public void visit(InfectadoAlpha e) {
		e.recibirDa�o(da�o);
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
	public void visit(Da�oDoble da�oDoble) {
	}
	


}
