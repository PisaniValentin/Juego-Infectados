package Controladores;

import javax.swing.JLabel;
import GameObjects.GameObject;
import Juego.Punto;
import Personajes.Personaje;
import Proyectiles.Proyectil;

public abstract class Controlador extends Thread {
	protected Proyectil proyectil;
	protected Punto punto;
	protected Personaje personaje;
	protected JLabel imagen;
	protected int ancho, largo;
//	protected Mapa mapa;
	protected GameObject objeto;

	public abstract void mover();

	public abstract void setPunto(Punto punto);

	public abstract Punto getPunto();

	public abstract void congelar();

//	public Controlador(GameObject objeto, Mapa map) {
//		this.objeto = objeto;
//		this.mapa = map;
//	}

	public Controlador(GameObject objeto) {
		this.objeto = objeto;
	}

//	public void setMapa(Mapa mapa) {
//		this.mapa = mapa;
//	}
//
//	public Mapa getMapa() {
//		return mapa;
//	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}

	public Proyectil getProyectil() {
		return proyectil;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje p) {
		this.personaje = p;
	}

	public void setProyectil(Proyectil p) {
		this.proyectil = p;
	}

//	public List<GameObject> getLista() {
//		return mapa.getListaObjectos();
//	}

//	public abstract void setLista(List<GameObject> listaObjectos);

}
