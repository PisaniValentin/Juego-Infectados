package Visitor;

import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.Da�oDoble;
import Personajes.Infectado;
import Personajes.Jugador;
import Proyectiles.ProyectilInfectado;
import Proyectiles.ProyectilJugador;

public class VisitorEfectoDa�o extends Visitor{

	public VisitorEfectoDa�o(GameObject o) {
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
		if(!d.isBuffed()) {
			d.getArma().setDa�o(d.getDa�o()*2);
			d.setBuff(true);
		}else {
			d.getArma().setDa�o(d.getDa�o()/2);
			d.setBuff(false);
		}
	}

	@Override
	public void visit(Congelacion c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Da�oDoble da�oDoble) {
		// TODO Auto-generated method stub
		
	}

}
