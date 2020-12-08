package Juego;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

import Controladores.Controlador;
import Controladores.ControladorInfectados;
import GameObjects.GameObject;
import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import Personajes.InfectadoAlpha;
import Personajes.InfectadoBeta;
import Personajes.Personaje;
import Proyectiles.Proyectil;

public class Mapa {
protected GUI gui;
protected Juego juego;
protected Personaje jugador;
protected List<GameObject> lista_objects;
protected Punto spawn0,spawn1,spawn2,spawn3;

	public Mapa(Juego juego,GUI gui) {
		this.juego = juego;
		this.gui = gui;
		jugador = null;
		lista_objects = new LinkedList<GameObject>();
		spawn0 = new Punto(30,11);
		spawn1 = new Punto(80,11);
		spawn2 = new Punto(130,11);
		spawn3 = new Punto(180,11);
	}
	
	public Personaje getJugador() {
		return jugador;
	}
	
	public void setJugador(Personaje jugador) {
		this.jugador= jugador;
	}
	
	public List<GameObject> getListaObjectos(){
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
		int ancho = p.getAncho() ;
		int alto = p.getAlto();
		JLabel imagen = p.getImagen();
		imagen.setLocation(x,y);
		imagen.setSize(ancho, alto);
		imagen.setVisible(true);
		jugador= p;
		gui.add(jugador.getImagen());
		gui.repaint();
		lista_objects.add(p);
		
	}
	
	public void agregarDisparo(Proyectil proyectil) {
		lista_objects.add(proyectil);
	}
	
	public void agregarInfectado(InfectadoAlpha infectado,Punto spawn) {
		
	}
	
	public void agregarHielo() {
	//	int x = spawn0.getX();
	//	int y = spawn0.getY();
	//	Punto punto = new Punto(60,379);
	//	Congelacion hielo = new Congelacion(punto,this);
	//	DañoDoble hielo = new DañoDoble(punto,this);
	//	hielo.getImagen().setLocation(60,379);
	//	hielo.getImagen().setSize(30, 30);
	//	lista_objects.add(hielo);
	//	gui.add(hielo.getImagen());
	//	gui.repaint();
	}
	
	public void agregarInfectadoTest() {
//		Controlador c_infectado = new ControladorInfectados();
		Punto punto = new Punto(80,60);
		Personaje zombie = new InfectadoBeta(punto,this);
		Personaje zombie2 = new InfectadoAlpha(punto,this);
		Personaje zombie3 = new InfectadoAlpha(punto,this);
//		c_infectado.setPersonaje(zombie);
//		c_infectado.setGUI(gui);
//		c_infectado.setMapa(this);
	//	zombie.setMapa(this);
		zombie.getImagen().setLocation(80,60);
		zombie.setPunto(spawn2);
	//	zombie2.setMapa(this);
		zombie2.getImagen().setLocation(80,60);
		zombie2.setPunto(spawn3);
		zombie.getImagen().setSize(44,64);
		zombie2.getImagen().setSize(44,64);
		
	//	zombie3.setMapa(this);
		zombie3.getImagen().setLocation(80,60);
		zombie3.setPunto(spawn0);
		zombie3.getImagen().setSize(44,64);
		
		
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

	
	
}



