package Controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import Juego.Punto;
import Proyectiles.Proyectil;
import Proyectiles.ProyectilJugador;

public class ControladorPersonaje extends Controlador implements KeyListener{

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPunto(Punto punto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Punto getPunto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		
		Punto pos = personaje.getPunto();
		int velocidad = 6;
		switch(tecla.getKeyCode()) {
			case KeyEvent.VK_LEFT: {
				int v = pos.getX() - velocidad;
				pos.setX(v);
				break;
			}
			case KeyEvent.VK_RIGHT: {
				int v = pos.getX() + velocidad;
				pos.setX(v);
				break;
			}
			case KeyEvent.VK_UP: {
				Controlador c_disparo = new ControladorProyectiles();
				c_disparo.setPersonaje(personaje);
				c_disparo.setGUI(personaje.getMapa().getGui());
				c_disparo.setTerreno(terreno);

				Punto pos_disparo = new Punto(pos.getX()+25,pos.getY()-30);
				int x = pos_disparo.getX();
				int y = pos_disparo.getY();
				Proyectil disparo = new ProyectilJugador(10,10,pos_disparo);
				
				JLabel imagen = disparo.getImagen();
				imagen.setLocation(x,y);
				imagen.setSize(15,15);
				imagen.setVisible(true);
				gui.getTerreno().add(disparo.getImagen());
				gui.getTerreno().repaint();
				c_disparo.setProyectil(disparo);
				disparo.setFrame(gui.getTerreno());
				c_disparo.start();
				personaje.getMapa().agregarDisparo(disparo);
				
				break;
			}
		
		}
		personaje.getImagen().setLocation(pos.getX(),pos.getY());
		personaje.setPunto(pos);
	//	terreno.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
