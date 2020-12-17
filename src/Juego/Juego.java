package Juego;

import java.util.List;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controladores.Controlador;
import Controladores.ControladorPersonaje;
import GameObjects.GameObject;
import Personajes.Jugador;
import Personajes.Personaje;

public class Juego {
	protected GUI gui;
	protected Mapa mapa;

	public Juego() {
		gui = new GUI();
		gui.setVisible(true);
		mapa = new Mapa(this, gui);
		gui.setMapa(mapa);

		init();
	}
	
	public void finalizar(boolean gano) {
		int opcion;
		List<GameObject> aux = new LinkedList<GameObject>();
		for(GameObject o : mapa.getListaObjectos()) {
			aux.add(o);
		}
		for (GameObject gameObject : aux) {
			gui.remove(gameObject.getImagen());
			mapa.getListaObjectos().remove(gameObject);
		}
		if (!gano) {
			JOptionPane.showMessageDialog(gui, "HAS PERDIDO", "Lo lamento...", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(gui, "¡GANASTE!", "Felicidades", JOptionPane.OK_OPTION);
		}
		gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
		gui.dispose();
	}
	
	private void init() {
		// crear personaje
		Jugador personaje = new Jugador();
		Punto punto = new Punto(113, 400);
		personaje.setPunto(punto);
		personaje.setMapa(mapa);
		mapa.agregarPersonaje(personaje);
		mapa.getGui().actualizarEtiquetaCargaViral(0);

		mapa.setJugador(personaje);
		ControladorPersonaje c_jugador = new ControladorPersonaje(personaje);
		gui.addKeyListener(c_jugador);
		mapa.ponerOleada();
	}
}
