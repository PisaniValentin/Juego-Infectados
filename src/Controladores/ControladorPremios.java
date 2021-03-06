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
		Visitor visitor = objeto.getMapa().getJugador().getVisitor();
		Punto pos = objeto.getPunto();
		int x = pos.getX();
		int y = pos.getY();
		int velocidad = 4;
		boolean seAgarro = false;
		while (y < 500 && !seAgarro) {
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
				objeto.accept(visitor);
				seAgarro = true;
			}
		}
		if (!seAgarro)
			objeto.getMapa().getGui().remove(objeto.getImagen());
	}

	@Override
	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	@Override
	public Punto getPunto() {
		return punto;
	}

	@Override
	public void congelar() {
	}

}
