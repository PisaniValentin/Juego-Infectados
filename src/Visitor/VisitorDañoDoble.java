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
	public void visit(Infectado e) {}

	@Override
	public void visit(ProyectilJugador d) {}

	@Override
	public void visit(ProyectilInfectado d) {}

	@Override
	public void visit(Jugador d) 
	{
		int da�o = d.getArma().getDa�o();
		d.getArma().setDa�o(da�o*2);
		obj.getMapa().getGui().remove(obj.getImagen());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		d.getArma().setDa�o(da�o);
	}

	@Override
	public void visit(Congelacion c) {}

	@Override
	public void visit(Da�oDoble da�oDoble) {}

	@Override
	public void visit(Pocion pocion) {}

}
