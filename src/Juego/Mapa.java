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
//	protected Punto spawn0, spawn1, spawn2, spawn3;
	protected Punto[] spawn;
//	protected Factory fabrica;
//	protected int cantidad_infectados;
	protected Nivel nivel;

//	private class Temporizador extends Thread {
//		protected boolean continuar;
//
//		protected Temporizador() {
//			this.continuar = false;
//		}
//
//		public void run() {
//			frenar();
//		}
//
//		public boolean getEstado() {
//			return continuar;
//		}
//
//		public void frenar() {
//			try {
//				while (cantidad_infectados != 0) {
//					this.sleep(10);
//				}
//				continuar = true;
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	public Mapa(Juego juego, GUI gui) {
		this.juego = juego;
		this.gui = gui;
		jugador = null;
//		cantidad_infectados = 0;
		lista_objects = new LinkedList<GameObject>();
//		spawn0 = new Punto(30, 11);
//		spawn1 = new Punto(80, 11);
//		spawn2 = new Punto(130, 11);
//		spawn3 = new Punto(180, 11);
		spawn = new Punto[] { new Punto(30, 11), new Punto(80, 11), new Punto(130, 11), new Punto(180, 11) };
//		fabrica = new Factory(this);
		nivel = new Nivel();
	}

	public void ponerOleada() {
//		for (int i = 0; i < 3; i++) {
//			System.out.println("|OLEADA|:" + (i + 1));
//			if (cantidad_infectados == 0) {
//				boolean puedoseguir = false;
//				List<GameObject> lista = crear_oleada(i);
//				Iterable<GameObject> lista = nivel.getOleada();
//				iniciarOleadas(lista);
//				
//				Temporizador tempo = new Temporizador();
//				tempo.start();
//				while (!puedoseguir) {
//					puedoseguir = tempo.getEstado();
//				}
//				if (cantidad_infectados == 0) {
//					System.out.println("entra aca2");
//					try {
//						Thread.sleep(2500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
		while (nivel.tieneSiguiente()) {
			System.out.println("|OLEADA|:" + nivel.getNumeroNivel());
			Iterable<GameObject> lista = nivel.getOleada1();
			iniciarOleadas(lista);
			while (lista_objects.size() != 1) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("oleada pt2");
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
		}
		System.out.println("GANASTE!!!");
	}

//	public void restarContadorInfectados() {
//		cantidad_infectados--;
//	}

//	public void iniciarOleadas(List<GameObject> lista) {
//		for (GameObject objeto : lista) {
//			objeto.getImagen().setLocation(objeto.getPunto().getX(), objeto.getPunto().getY());
//			objeto.getImagen().setSize(44, 64);
//			objeto.getImagen().setVisible(true);
//			lista_objects.add(objeto);
//			gui.add(objeto.getImagen());
//			objeto.mover();
//			cantidad_infectados++;
//			gui.repaint();
//			try {
//				Thread.sleep(2500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public void iniciarOleadas(Iterable<GameObject> lista) {
		Random r = new Random();
		for (GameObject objeto : lista) {
			objeto.setMapa(this);
			objeto.setPunto(spawn[r.nextInt(4)]);
			objeto.getImagen().setLocation(objeto.getPunto().getX(), objeto.getPunto().getY());
			objeto.getImagen().setSize(44, 64);
			objeto.getImagen().setVisible(true);
			lista_objects.add(objeto);
//			cantidad_infectados++;
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

//	public List<GameObject> crear_oleada(int dificultad) {
//		List<GameObject> toReturn = new LinkedList<GameObject>();
//		Personaje infectado = null;
//		Random r = new Random();
//		switch (dificultad) {
//		// oleadas para nivel 1
//		case 0: {
//			for (int i = 0; i < 3; i++) {
//				int numero = r.nextInt(3);
//				switch (numero) {
//				case 0: {
//					infectado = fabrica.getPersonaje("alpha", spawn0);
//					toReturn.add(infectado);
//					break;
//				}
//				case 1: {
//					infectado = fabrica.getPersonaje("alpha", spawn1);
//					toReturn.add(infectado);
//					break;
//				}
//				case 2: {
//					infectado = fabrica.getPersonaje("alpha", spawn2);
//					toReturn.add(infectado);
//					break;
//				}
//				case 3: {
//					infectado = fabrica.getPersonaje("alpha", spawn3);
//					toReturn.add(infectado);
//					break;
//				}
//				}
//			}
//			break;
//		}
//		// oleadas para nivel 2
//		case 1: {
//			for (int i = 0; i < 6; i++) {
//				int numero = r.nextInt(3);
//				switch (numero) {
//				case 0: {
//					infectado = fabrica.getPersonaje("alpha", spawn0);
//					toReturn.add(infectado);
//					break;
//				}
//				case 1: {
//					infectado = fabrica.getPersonaje("beta", spawn1);
//					toReturn.add(infectado);
//					break;
//				}
//				case 2: {
//					infectado = fabrica.getPersonaje("beta", spawn2);
//					toReturn.add(infectado);
//					break;
//				}
//				case 3: {
//					infectado = fabrica.getPersonaje("alpha", spawn3);
//					toReturn.add(infectado);
//					break;
//				}
//
//				}
//			}
//			break;
//		}
//		// oleadas para nivel 3
//		case 2: {
//			for (int i = 0; i < 8; i++) {
//				int numero = r.nextInt(3);
//				switch (numero) {
//				case 0: {
//					infectado = fabrica.getPersonaje("beta", spawn0);
//					toReturn.add(infectado);
//					break;
//				}
//				case 1: {
//					infectado = fabrica.getPersonaje("beta", spawn1);
//					toReturn.add(infectado);
//					break;
//				}
//				case 2: {
//					infectado = fabrica.getPersonaje("beta", spawn2);
//					toReturn.add(infectado);
//					break;
//				}
//				case 3: {
//					infectado = fabrica.getPersonaje("beta", spawn3);
//					toReturn.add(infectado);
//					break;
//				}
//
//				}
//			}
//			break;
//		}
//		}
//		return toReturn;
//	}

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
		// int x = spawn0.getX();
		// int y = spawn0.getY();
		// Punto punto = new Punto(60,379);
		// Congelacion hielo = new Congelacion(punto,this);
		// DañoDoble hielo = new DañoDoble(punto,this);
		// hielo.getImagen().setLocation(60,379);
		// hielo.getImagen().setSize(30, 30);
		// lista_objects.add(hielo);
		// gui.add(hielo.getImagen());
		// gui.repaint();
	}

	public void agregarInfectadoTest() {
//		Controlador c_infectado = new ControladorInfectados();
		Punto punto = new Punto(80, 60);
		Personaje zombie = new InfectadoBeta(punto, this);
		Personaje zombie2 = new InfectadoAlpha(punto, this);
		Personaje zombie3 = new InfectadoAlpha(punto, this);
//		c_infectado.setPersonaje(zombie);
//		c_infectado.setGUI(gui);
//		c_infectado.setMapa(this);
		// zombie.setMapa(this);
		zombie.getImagen().setLocation(80, 60);
		zombie.setPunto(spawn[2]);
		// zombie2.setMapa(this);
		zombie2.getImagen().setLocation(80, 60);
		zombie2.setPunto(spawn[3]);
		zombie.getImagen().setSize(44, 64);
		zombie2.getImagen().setSize(44, 64);

		// zombie3.setMapa(this);
		zombie3.getImagen().setLocation(80, 60);
		zombie3.setPunto(spawn[0]);
		zombie3.getImagen().setSize(44, 64);

		lista_objects.add(zombie);
		lista_objects.add(zombie2);
		lista_objects.add(zombie3);
		gui.add(zombie.getImagen());
		gui.add(zombie2.getImagen());
		gui.add(zombie3.getImagen());
//		c_infectado.start();

		zombie.mover();
		zombie2.mover();
		zombie3.mover();

		gui.repaint();
	}

//	public void remove(GameObject o) {
//		gui.remove(o.getImagen());
//		gui.repaint();
//		lista_objects.remove(o);
//	}
}
