package Visitor;

import Controladores.TemporizadorHielo;
import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import ObjetosTemporales.Pocion;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorJugador extends Visitor {

	public VisitorJugador(GameObject o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Infectado e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ProyectilJugador d) {
		// no debe hacer nada
	}

	@Override
	public void visit(ProyectilInfectado d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Jugador d) {
		// TODO Auto-generated method stub
		System.out.println("entre al visitor de jugador");
	
	}

	@Override
	public void visit(Congelacion c) {
		// TODO Auto-generated method stub
		System.out.println("congelacion");
		TemporizadorHielo tempo = new TemporizadorHielo(c, c.getMapa());
		tempo.start();
		obj.getMapa().getGui().remove(c.getImagen());
	}

	@Override
	public void visit(DañoDoble dañoDoble) {
		System.out.println("dañodoble");
		obj.accept(dañoDoble.getVisitor());
	}

	@Override
	public void visit(Pocion pocion) {
		// TODO Auto-generated method stub
		System.out.println("pocion");
		obj.accept(pocion.getVisitor());
		
	}

}
