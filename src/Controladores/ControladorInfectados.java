package Controladores;


import java.util.List;

import GameObjects.GameObject;
import Juego.Punto;
import Personajes.Infectado;
import Visitor.Visitor;
public class ControladorInfectados extends Controlador{
protected boolean puedo = true;
protected List<GameObject> lista;
protected Temporizador temporizador;

	public void run() {
		Visitor visitor = this.getPersonaje().getVisitor();
		Punto pos_zombie = personaje.getPunto();
		int x = pos_zombie.getX();
		int y = pos_zombie.getY();
		boolean golpeo = false;
		while( personaje != null && y<gui.getContentPane().getWidth()+300 ) {
			try {
				this.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			y = y+personaje.getVelocidad();
			personaje.getPunto().setY(y);
			personaje.getImagen().setLocation(x, y);
			gui.repaint();
			if((personaje.getHitbox().intersects(mapa.getJugador().getHitbox()) && !golpeo) ) {
				mapa.getJugador().accept(visitor);
				//golpeo=true;
			}
		}
	}
	
	public void setLista(List<GameObject> list) {
		this.lista = list;
	}
	
	public void congelar(){
	}

	@Override
	public void setPunto(Punto punto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Punto getPunto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Controlador getControlador() {
		return personaje.getControlador();
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}


	
	

}
