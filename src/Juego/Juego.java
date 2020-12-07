package Juego;


import Controladores.Controlador;
import Controladores.ControladorPersonaje;
import Personajes.Jugador;
import Personajes.Personaje;

public class Juego {
protected GUI gui;
protected Mapa mapa;

	public Juego() {
		gui= new GUI();
		gui.setVisible(true);
		mapa = new Mapa(this,gui);
		gui.setMapa(mapa);
		Personaje personaje = new Jugador();
		
		Punto punto = new Punto(113,445);
		personaje.setPunto(punto);
		personaje.setMapa(mapa);
		mapa.agregarPersonaje(personaje);
		mapa.agregarInfectadoTest();
		mapa.setJugador(personaje);
		Controlador c_jugador = new ControladorPersonaje(personaje,mapa);
		c_jugador.setPersonaje(personaje);
		c_jugador.setGUI(gui);
		gui.addKeyListener((ControladorPersonaje) c_jugador);
		mapa.agregarHielo();
		
		}
}
