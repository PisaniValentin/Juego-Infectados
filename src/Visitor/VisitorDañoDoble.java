package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorDañoDoble extends Visitor
{

	public VisitorDañoDoble(GameObject o) {
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
		int daño = d.getArma().getDaño();
		d.getArma().setDaño(daño*2);
		obj.getMapa().getGui().remove(obj.getImagen());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		d.getArma().setDaño(daño);
	}

	@Override
	public void visit(Congelacion c) {}

	@Override
	public void visit(DañoDoble dañoDoble) {}

	@Override
	public void visit(Pocion pocion) {}

}
