package Controladores;

import java.util.LinkedList;
import java.util.List;

import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;

public class ControladorProyectiles extends Controlador {

	protected int rango;

	public ControladorProyectiles(GameObject objeto, int rango) {
		super(objeto);
		this.rango = rango;
	}

	public void run() {
		mover();
	}

	public void mover() {
		boolean proyectil_landed = false;
		Visitor visitor = objeto.getVisitor();
		int contador = 0;
		int posY = objeto.getPunto().getY();
		List<GameObject> lista = objeto.getMapa().getListaObjectos();
		while (!proyectil_landed && contador <= rango) {
			try {
				// esto hay que sacarlo afuera del while (!proyectil_landed && contador <= rango) {
				List<GameObject> lista_aux = new LinkedList<GameObject>();
				for (GameObject objeto : lista) {
					lista_aux.add(objeto);
				}
				ControladorProyectiles.sleep(50);
				posY = posY - 10;
				objeto.getPunto().setY(posY);
				objeto.getImagen().setLocation(objeto.getPunto().getX(), objeto.getPunto().getY());
				objeto.getMapa().getGui().repaint();
				contador++;
				for (GameObject game_object : lista_aux) {
					//y en este if comprobar que game_object este vivo
					//asi cuando muere se actualiza mas rapido que la lista
					if (!objeto.getMapa().getListaObjectos().isEmpty()) {
						if (proyectil.getHitbox().intersects(game_object.getHitbox()) && game_object != objeto) {
							game_object.accept(visitor);
							proyectil_landed = true;
							objeto.getMapa().getGui().repaint();
						}
					}
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
		this.punto = punto;
	}

	@Override
	public Punto getPunto() {
		return this.punto;
	}

	@Override
	public void congelar() {

	}
}
