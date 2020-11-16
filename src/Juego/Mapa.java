package Juego;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

import Personajes.Infectado;
import Personajes.Personajes;
import Proyectiles.Proyectil;

public class Mapa {
protected GUI gui;
protected Juego juego;
protected Personajes jugador;
protected List<Personajes> lista_infectados;
protected List<Proyectil> lista_proyectiles;

	public Mapa(Juego juego,GUI gui) {
		this.juego = juego;
		this.gui = gui;
		jugador = null;
		lista_infectados = new LinkedList<Personajes>();
		lista_proyectiles = new LinkedList<Proyectil>();
	}
	
	public List<Proyectil> getListaDisparos(){
		return lista_proyectiles;
	}
	
	public List<Personajes> getListaInfectados(){
		return lista_infectados;
	}
	
	public Juego getJuego() {
		return juego;
	}
	
	public GUI getGui() {
		return gui;
	}
	
	public void agregarPersonaje(Personajes p) {
		int x = p.getPunto().getX();
		int y = p.getPunto().getY();
		int ancho = p.getAncho() ;
		int alto = p.getLargo();
		JLabel imagen = p.getImagen();
		imagen.setLocation(x,y);
		imagen.setSize(ancho, alto);
		imagen.setVisible(true);
		jugador= p;
		gui.getTerreno().add(jugador.getImagen());
		gui.getTerreno().repaint();
		
	}
	
	public void agregarDisparo(Proyectil proyectil) {
		lista_proyectiles.add(proyectil);
	}
	
	public void agregarInfectado(Infectado infectado,Punto punto) {
		
	}
	
	public void agregarInfectadoTest() {
		Punto punto = new Punto(80,60);
		Personajes zombie = new Infectado(punto);
		
		zombie.getImagen().setLocation(80,60);
		zombie.setPunto(punto);
		zombie.getImagen().setSize(60,60);
		lista_infectados.add(zombie);
		gui.getTerreno().add(zombie.getImagen());
		gui.getTerreno().repaint();
	}

	
	
}



