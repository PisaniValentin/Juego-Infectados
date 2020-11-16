package Juego;


import Controladores.Controlador;
import Controladores.ControladorPersonaje;
import Personajes.Jugador;
import Personajes.Personajes;

public class Juego {
protected GUI gui;
protected Mapa mapa;

	public Juego() {
		gui= new GUI();
		gui.setVisible(true);
		mapa = new Mapa(this,gui);
		gui.setMapa(mapa);
		Personajes personaje = new Jugador();
		
		Punto punto = new Punto(55,185);
		personaje.setPunto(punto);
		personaje.setMapa(mapa);
		mapa.agregarPersonaje(personaje);
		mapa.agregarInfectadoTest();
		Controlador c_jugador = new ControladorPersonaje();
		c_jugador.setPersonaje(personaje);
		c_jugador.setGUI(gui);
		c_jugador.setTerreno(gui.getTerreno());
		
		gui.addKeyListener((ControladorPersonaje) c_jugador);
		
		
		}
}
