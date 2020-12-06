package Controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JLabel;

import GameObjects.GameObject;
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
		int rango = personaje.getRango();
		int daño = personaje.getDaño();
		
		int velocidad = 3;
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
				Punto pos_disparo = new Punto(pos.getX()+10,pos.getY()-20);
				int x = pos_disparo.getX();
				int y = pos_disparo.getY();
				Proyectil disparo = new ProyectilJugador(rango,daño,pos_disparo);
				JLabel imagen = disparo.getImagen();
				imagen.setLocation(x,y);
				imagen.setSize(15,15);
				imagen.setVisible(true);
				gui.add(disparo.getImagen());
				gui.repaint();
				c_disparo.setProyectil(disparo);
				c_disparo.start();
				break;
			}
		
		}
		personaje.getImagen().setLocation(pos.getX(),pos.getY());
		personaje.setPunto(pos);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void congelar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLista(List<GameObject> listaObjectos) {
		// TODO Auto-generated method stub
		
	}

	
}
