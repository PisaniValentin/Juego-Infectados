package Controladores;

import java.util.LinkedList;
import java.util.List;

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
		List<GameObject> lista = personaje.getMapa().getListaObjectos();
		List<GameObject> lista_aux = new LinkedList<GameObject>();
		for(GameObject objeto : lista) {
			lista_aux.add(objeto);
		}
		while(!proyectil_landed && contador<=personaje.getRango()) {
			try {
				ControladorProyectiles.sleep(50);
				posY = posY - 10;
				proyectil.getPunto().setY(posY);
				proyectil.getImagen().setLocation(proyectil.getPunto().getX(), proyectil.getPunto().getY());
				gui.repaint();
				contador++;
				for(GameObject objeto : lista_aux) {
					if(!personaje.getMapa().getListaObjectos().isEmpty() ) {
						if(proyectil.getHitbox().intersects(objeto.getHitbox()) && objeto != proyectil) {
							objeto.accept(visitor);
							//System.out.println("pegue");
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
		personaje.getMapa().getListaObjectos().remove(proyectil);
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

	public ControladorProyectiles getControlador() {
		// TODO Auto-generated method stub
		return (ControladorProyectiles) proyectil.getControlador();
	}

	@Override
	public void congelar() {
		
	}

	@Override
	public void setLista(List<GameObject> listaObjectos) {
		// TODO Auto-generated method stub
		
	}



}
