package Controladores;

import GameObjects.GameObject;
import Juego.Punto;
import Visitor.Visitor;

public class ControladorPremios extends Controlador {

	public ControladorPremios(GameObject objeto) {
		super(objeto);
	}

	public void run() {
		mover();
	}

	@Override
	public void mover() {
		Visitor visitor = objeto.getVisitor();
		Punto pos = objeto.getPunto();
		int x = pos.getX();
		int y = pos.getY();
		int velocidad = 4;
		boolean seAgarro = false;
		while (y < 3000 && !seAgarro) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			y = y + velocidad;
			objeto.getPunto().setY(y);
			objeto.getImagen().setLocation(x, y);
			objeto.getMapa().getGui().repaint();
			if ((objeto.getHitbox().intersects(objeto.getMapa().getJugador().getHitbox()) && !seAgarro)) {
				objeto.getMapa().getJugador().accept(visitor);
				seAgarro = true;
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

	@Override
	public void congelar() {
		// TODO Auto-generated method stub

	}

}
