package Controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import GameObjects.GameObject;
import Juego.Punto;
import Proyectiles.Proyectil;
import Proyectiles.ProyectilJugador;

public class ControladorPersonaje extends Controlador implements KeyListener {

	public ControladorPersonaje(GameObject objeto) {
		super(objeto);
	}

	@Override
	public void mover() {}

	@Override
	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	@Override
	public Punto getPunto() {
		return punto;
	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		Punto pos = personaje.getPunto();
		int velocidad = 3;
		switch (tecla.getKeyCode()) {
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
		}

		}
		personaje.getImagen().setLocation(pos.getX(), pos.getY());
		personaje.setPunto(pos);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Punto pos = personaje.getPunto();
		int rango = personaje.getRango();
		int daño = personaje.getDaño();

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: {
			Punto pos_disparo = new Punto(pos.getX() + 10, pos.getY() - 20);
			int x = pos_disparo.getX();
			int y = pos_disparo.getY();
			Proyectil disparo = new ProyectilJugador(rango, daño, pos_disparo);
			disparo.setMapa(objeto.getMapa());
			Controlador c_disparo = new ControladorProyectiles(disparo, personaje.getRango());
			JLabel imagen = disparo.getImagen();
			imagen.setLocation(x, y);
			imagen.setSize(15, 15);
			imagen.setVisible(true);
			objeto.getMapa().getGui().add(disparo.getImagen());
			objeto.getMapa().getGui().repaint();
			c_disparo.setProyectil(disparo);
			c_disparo.start();
			break;
		}
		}

	}

	@Override
	public void congelar() {}

	@Override
	public void keyTyped(KeyEvent e) {}

}
