package Controladores;

import GameObjects.GameObject;
import Juego.Punto;
import Personajes.Personaje;
import Visitor.Visitor;

public class ControladorProyectilInfectado extends Controlador {

	protected int rango;
	
	public ControladorProyectilInfectado(GameObject objeto, int rango) {
		super(objeto);
		this.rango = rango;
	}
	
	public void run() {
		if(objeto.getMapa().getJugador().getCargaViral() < 100)
			mover();
	}

	@Override
	public void mover() {
		boolean proyectil_landed = false;
		Visitor visitor = objeto.getVisitor();
		int contador = 0;
		int posY = objeto.getPunto().getY();
		Personaje jugador = objeto.getMapa().getJugador();
		while (!proyectil_landed && contador <= rango && objeto.getMapa().getJugador().getCargaViral() < 100) {
			try {
				ControladorProyectiles.sleep(50);
				posY = posY + 10;
				objeto.getPunto().setY(posY);
				objeto.getImagen().setLocation(objeto.getPunto().getX(), objeto.getPunto().getY());
				objeto.getMapa().getGui().repaint();
				contador++;
				if (proyectil.getHitbox().intersects(jugador.getHitbox())) {
							jugador.accept(visitor);
							proyectil_landed = true;
							objeto.getMapa().getGui().repaint();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		objeto.getMapa().getGui().remove(objeto.getImagen());
		objeto.getMapa().getListaObjectos().remove(objeto);
		proyectil = null;
	}

	@Override
	public void setPunto(Punto punto) {

	}

	@Override
	public Punto getPunto() {
		return null;
	}

	@Override
	public void congelar() {

	}

}
