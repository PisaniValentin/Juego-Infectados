package Juego;

import Controladores.Controlador;
import Controladores.ControladorPersonaje;
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

		// crear personaje
		Personaje personaje = new Jugador();
		Punto punto = new Punto(113, 400);
		personaje.setPunto(punto);
		personaje.setMapa(mapa);
		mapa.agregarPersonaje(personaje);
		System.out.println(mapa);
		mapa.getGui().actualizarEtiquetaCargaViral(0);

		// mapa.agregarInfectadoTest();
		mapa.setJugador(personaje);
		Controlador c_jugador = new ControladorPersonaje(personaje);
		c_jugador.setPersonaje(personaje);
		gui.addKeyListener((ControladorPersonaje) c_jugador);
		// mapa.agregarHielo();
		mapa.ponerOleada();
	}
}
