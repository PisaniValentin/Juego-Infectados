package Controladores;

import GameObjects.GameObject;
import Juego.Punto;
import Visitor.Visitor;

public class ControladorInfectados extends Controlador {

	public ControladorInfectados(GameObject objeto) {
		super(objeto);
	}

	protected boolean puedo = true;
//	protected List<GameObject> lista;

//	public ControladorInfectados(GameObject objeto, Mapa map) {
//		super(objeto, map);
//	}

	public void run() {
		Visitor visitor = this.getPersonaje().getVisitor();
		Punto pos_zombie = personaje.getPunto();
		int x = pos_zombie.getX();
		int y = pos_zombie.getY();
		boolean golpeo = false;
		while (personaje.getCargaViral() > 0 && y < objeto.getMapa().getGui().getWidth()) {
			try {
				Thread.sleep(30);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			y = y + personaje.getVelocidad();
			personaje.getPunto().setY(y);
			personaje.getImagen().setLocation(x, y);
			objeto.getMapa().getGui().repaint();
			if ((personaje.getHitbox().intersects(objeto.getMapa().getJugador().getHitbox()) && !golpeo)) {
				objeto.getMapa().getJugador().accept(visitor);
				// golpeo=true;
			}

		}
	}

//	public void setLista(List<GameObject> list) {
//		this.lista = list;
//	}

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
