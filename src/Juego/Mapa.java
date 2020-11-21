package Juego;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

import Controladores.Controlador;
import Controladores.ControladorInfectados;
import Personajes.Infectado;
import Personajes.Personaje;
import Proyectiles.Proyectil;

public class Mapa {
protected GUI gui;
protected Juego juego;
protected Personaje jugador;
protected List<Personaje> lista_infectados;
protected List<Proyectil> lista_proyectiles;
protected Punto spawn0,spawn1,spawn2,spawn3,spawn4;

	public Mapa(Juego juego,GUI gui) {
		this.juego = juego;
		this.gui = gui;
		jugador = null;
		lista_infectados = new LinkedList<Personaje>();
		lista_proyectiles = new LinkedList<Proyectil>();
	}
	
	public List<Proyectil> getListaDisparos(){
		return lista_proyectiles;
	}
	
	public List<Personaje> getListaInfectados(){
		return lista_infectados;
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
		int ancho = p.getAncho() ;
		int alto = p.getAlto();
		JLabel imagen = p.getImagen();
		imagen.setLocation(x,y);
		imagen.setSize(ancho, alto);
		imagen.setVisible(true);
		jugador= p;
		gui.add(jugador.getImagen());
		gui.repaint();
		
	}
	
	public void agregarDisparo(Proyectil proyectil) {
		lista_proyectiles.add(proyectil);
	}
	
	public void agregarInfectado(Infectado infectado,Punto spawn) {
		
	}
	
	public void agregarInfectadoTest() {
		Controlador c_infectado = new ControladorInfectados();
		Punto punto = new Punto(80,60);
		Personaje zombie = new Infectado(punto);
		c_infectado.setPersonaje(zombie);
		c_infectado.setGUI(gui);
		
		zombie.setMapa(this);
		zombie.getImagen().setLocation(80,60);
		zombie.setPunto(punto);
		zombie.getImagen().setSize(44,64);
		lista_infectados.add(zombie);
		gui.add(zombie.getImagen());
		c_infectado.start();
		
		gui.repaint();
	}

	
	
}



