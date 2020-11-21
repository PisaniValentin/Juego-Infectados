package Controladores;

import GameObjects.GameObject;
import Juego.Punto;
import Personajes.Infectado;
import Personajes.Personaje;
import Visitor.Visitor;

public class ControladorProyectiles extends Controlador {

	public void run() {
		mover();
	}
	
	public void mover() {
		boolean proyectil_landed=false;
		Visitor visitor= proyectil.getVisitor();
		int contador=0;
		int posY = proyectil.getPunto().getY();
		while(!proyectil_landed && contador<=personaje.getRango()) {
			try {
				ControladorProyectiles.sleep(50);
				posY = posY - 10;
				proyectil.getPunto().setY(posY);
				proyectil.getImagen().setLocation(proyectil.getPunto().getX(), proyectil.getPunto().getY());
				gui.repaint();
				contador++;
				for(GameObject zombie : personaje.getMapa().getListaInfectados()) {
					if(!personaje.getMapa().getListaInfectados().isEmpty()) {
						if(proyectil.getHitbox().intersects(zombie.getHitbox())) {
							zombie.accept(visitor);
							proyectil_landed = true;
							gui.repaint();
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gui.remove(proyectil.getImagen());
		proyectil = null;
	}

	@Override
	public void setPunto(Punto punto) {
		this.punto=punto;
	}

	@Override
	public Punto getPunto() {
		return this.punto;
	}

}
