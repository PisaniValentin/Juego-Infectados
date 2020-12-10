package Controladores;

import java.util.List;

import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;

public class ControladorPremios extends Controlador {

	public ControladorPremios(GameObject objeto) {
		super(objeto);
	}

//	public ControladorPremios(GameObject objeto, Mapa map) {
//		super(objeto, map);
//		// TODO Auto-generated constructor stub
//	}

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
				this.sleep(30);
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

//	@Override
//	public void setLista(List<GameObject> listaObjectos) {
//		// TODO Auto-generated method stub
//
//	}

}
