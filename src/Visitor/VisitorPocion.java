package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorPocion extends Visitor
{

	public VisitorPocion(GameObject o) {
		super(o);
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

		obj.getMapa().getGui().remove(obj.getImagen());
		int Sanacion = d.getCargaViral();
		if(Sanacion >0)
		{
			if(Sanacion >=20) {
				d.setCargaViral(Sanacion -20);
				obj.getMapa().getGui().actualizarEtiquetaCargaViral(d.getCargaViral());
			}
			else
				d.setCargaViral(0);
				obj.getMapa().getGui().actualizarEtiquetaCargaViral(d.getCargaViral());
		}
		System.out.println("Vida = "+d.getCargaViral());
	}

	@Override
	public void visit(Congelacion c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DañoDoble dañoDoble) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Pocion pocion) {
		// TODO Auto-generated method stub
		
	}

}
