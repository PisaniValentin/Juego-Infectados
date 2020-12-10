package Controladores;

import GameObjects.GameObject;
import Juego.Punto;
import Visitor.Visitor;

public class ControladorInfectados extends Controlador {

	protected boolean puedo = true;

	public ControladorInfectados(GameObject objeto) {
		super(objeto);
	}

	public void run() {
		Visitor visitor = this.getPersonaje().getVisitor();
		Punto pos_zombie = personaje.getPunto();
		int x = pos_zombie.getX();
		int y = pos_zombie.getY();
		boolean golpeo = false;
		while (personaje.getCargaViral() > 0) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(y < 420)
				y = y + personaje.getVelocidad();
			else
				y = 0;
			personaje.getPunto().setY(y);
			personaje.getImagen().setLocation(x, y);
			objeto.getMapa().getGui().repaint();
			if ((personaje.getHitbox().intersects(objeto.getMapa().getJugador().getHitbox()) && !golpeo)) {
				objeto.getMapa().getJugador().accept(visitor);
			}

		}
	}

	public void congelar() {
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

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

}
