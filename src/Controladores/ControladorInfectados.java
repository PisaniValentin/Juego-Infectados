package Controladores;

import Juego.Punto;
import Visitor.Visitor;

public class ControladorInfectados extends Controlador {

	public void run() {
		mover();
	}
	@Override
	public void mover() {
		Visitor visitor = personaje.getVisitor();
		Punto pos_zombie = personaje.getPunto();
		int x = pos_zombie.getX();
		int y = pos_zombie.getY();
		boolean golpeo = false;
		while(y<gui.getContentPane().getWidth()+300) {
			try {
				this.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			y = y+1;
			personaje.getPunto().setY(y);
			personaje.getImagen().setLocation(x, y);
			gui.repaint();
			if(personaje.getHitbox().intersects(mapa.getJugador().getHitbox()) || y>mapa.getJugador().getPunto().getY() && !golpeo) {
				mapa.getJugador().accept(visitor);
				golpeo=true;
			}
		}
		
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
	
	

}
