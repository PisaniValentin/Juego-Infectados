package Juego;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

import Controladores.Nivel;
import GameObjects.GameObject;
import Personajes.InfectadoAlpha;
import Personajes.InfectadoBeta;
import Personajes.Personaje;
import Proyectiles.Proyectil;

public class Mapa {
	protected GUI gui;
	protected Juego juego;
	protected Personaje jugador;
	protected List<GameObject> lista_objects;
	protected Punto[] spawn;
	protected Nivel nivel;

	public Mapa(Juego juego, GUI gui) {
		this.juego = juego;
		this.gui = gui;
		jugador = null;
		lista_objects = new LinkedList<GameObject>();
		spawn = new Punto[] { new Punto(30, 11), new Punto(80, 11), new Punto(130, 11), new Punto(180, 11) };
		nivel = new Nivel();
	}

	public void ponerOleada() {
		while (nivel.tieneSiguiente()) {
			gui.actualizarEtiquetaOleada(nivel.getNumeroNivel());
			Iterable<GameObject> lista = nivel.getOleada1();
			iniciarOleadas(lista);
			while (lista_objects.size() != 1) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			lista = nivel.getOleada2();
			iniciarOleadas(lista);
			while (lista_objects.size() != 1) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			nivel.cambiarNivel();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		if (jugador.getCargaViral() <=100) {
			juego.finalizar(true);
		}
	}

	public void iniciarOleadas(Iterable<GameObject> lista) {
		Random r = new Random();
		for (GameObject objeto : lista) {
			objeto.setMapa(this);
			objeto.setPunto(spawn[r.nextInt(4)]);
			objeto.getImagen().setLocation(objeto.getPunto().getX(), objeto.getPunto().getY());
			objeto.getImagen().setSize(44, 64);
			objeto.getImagen().setVisible(true);
			lista_objects.add(objeto);
			gui.add(objeto.getImagen());
			objeto.mover();
			gui.repaint();
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Personaje getJugador() {
		return jugador;
	}

	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}

	public List<GameObject> getListaObjectos() {
		return lista_objects;
	}

	public Juego getJuego() {
		return juego;
	}

	public GUI getGui() {
		return gui;
	}

	public void agregarPersonaje(Personaje p) {
		int x = p.getPunto().getX();
		int y = p.getPunto().getY();
		int ancho = p.getAncho();
		int alto = p.getAlto();
		JLabel imagen = p.getImagen();
		imagen.setLocation(x, y);
		imagen.setSize(ancho, alto);
		imagen.setVisible(true);
		jugador = p;
		gui.add(jugador.getImagen());
		gui.repaint();
		lista_objects.add(p);

	}

	public void agregarDisparo(Proyectil proyectil) {
		lista_objects.add(proyectil);
	}

	public void agregarInfectado(InfectadoAlpha infectado, Punto spawn) {

	}

	public void agregarHielo() {
	}

	public void agregarInfectadoTest() {
		Punto punto = new Punto(80, 60);
		Personaje zombie = new InfectadoBeta(punto, this);
		Personaje zombie2 = new InfectadoAlpha(punto, this);
		Personaje zombie3 = new InfectadoAlpha(punto, this);
		zombie.getImagen().setLocation(80, 60);
		zombie.setPunto(spawn[2]);
		zombie2.getImagen().setLocation(80, 60);
		zombie2.setPunto(spawn[3]);
		zombie.getImagen().setSize(44, 64);
		zombie2.getImagen().setSize(44, 64);
		zombie3.getImagen().setLocation(80, 60);
		zombie3.setPunto(spawn[0]);
		zombie3.getImagen().setSize(44, 64);
		lista_objects.add(zombie);
		lista_objects.add(zombie2);
		lista_objects.add(zombie3);
		gui.add(zombie.getImagen());
		gui.add(zombie2.getImagen());
		gui.add(zombie3.getImagen());
		zombie.mover();
		zombie2.mover();
		zombie3.mover();

		gui.repaint();
	}
}
