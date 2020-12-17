package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.Da�oDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorCongelar extends Visitor {

	public VisitorCongelar(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Infectado e) {
		if (!e.estaQuieto()) {
			e.setVelocidad(0);
			e.setImagen("Imagenes/congelado.png");
		} else {
			e.descongelar();
		}
	}

	@Override
	public void visit(ProyectilJugador d) {
	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Jugador d) {
		System.out.println("congelar visita a jugador");
//		TemporizadorHielo tempo = new TemporizadorHielo(obj, obj.getMapa());
//		tempo.start();
//		obj.getMapa().getGui().remove(obj.getImagen());

	}

	@Override
	public void visit(Congelacion c) {
		
	}

	@Override
	public void visit(Da�oDoble da�oDoble) {
	}

	@Override
	public void visit(Pocion pocion) {
		// TODO Auto-generated method stub
		
	}

}
