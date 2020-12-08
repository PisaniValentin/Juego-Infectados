package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import Personajes.InfectadoAlpha;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorEfectoCongelar extends Visitor {

	public VisitorEfectoCongelar(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(InfectadoAlpha e) {
		if(!e.estaQuieto()) {
			System.out.println("entre visitor congelacion");
			e.setVelocidad(0);
			e.setImagen("Imagenes/congelado.png");
		}else {
			e.descongelar();
		}
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
		
	}

	@Override
	public void visit(Congelacion c) {
		// TODO Auto-generated method stub
		System.out.println("entre a este visitor");
	}

	@Override
	public void visit(DañoDoble dañoDoble) {
		// TODO Auto-generated method stub
		
	}

}
