package Controladores;

import java.util.Random;

import javax.swing.JLabel;

import GameObjects.GameObject;
import Juego.Punto;
import Proyectiles.Proyectil;
import Proyectiles.ProyectilInfectado;
import Visitor.Visitor;

public class ControladorInfectados extends Controlador {

	public ControladorInfectados(GameObject objeto) {
		super(objeto);
	}

	public void run() {
		
		Visitor visitor = this.getPersonaje().getVisitor();
		Punto pos_zombie = personaje.getPunto();
		int x = pos_zombie.getX();
		int y = pos_zombie.getY();
		boolean golpeo = false;
		while (personaje.getCargaViral() > 0 && objeto.getMapa().getJugador().getCargaViral()<100) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(y < 400)
				y = y + personaje.getVelocidad();
			else
				y = 0;
			personaje.getPunto().setY(y);
			personaje.getImagen().setLocation(x, y);
			objeto.getMapa().getGui().repaint();
			
			Punto pos = personaje.getPunto();
			int rango = personaje.getRango();
			int daño = personaje.getDaño();
			Random r = new Random();
			float chance = r.nextFloat();
			if (chance < 0.02f) {
				Punto pos_disparo = new Punto(pos.getX() + 10, pos.getY()+10);
				int xp = pos_disparo.getX();
				int yp = pos_disparo.getY();
				Proyectil disparo = new ProyectilInfectado(rango, daño, pos_disparo);
				disparo.setMapa(objeto.getMapa());
				Controlador c_disparo = new ControladorProyectilInfectado(disparo, rango);
				JLabel imagen = disparo.getImagen();
				imagen.setLocation(xp, yp);
				imagen.setSize(15, 15);
				imagen.setVisible(true);
				objeto.getMapa().getGui().add(disparo.getImagen());
				objeto.getMapa().getGui().repaint();
				c_disparo.setProyectil(disparo);
				c_disparo.start();
			}
			
			if ((personaje.getHitbox().intersects(objeto.getMapa().getJugador().getHitbox()) && !golpeo)) {
				objeto.getMapa().getJugador().accept(visitor);
				golpeo=!golpeo;
			}

		}
	}

	public void congelar() {}

	@Override
	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	public Punto getPunto() {
		return punto;
	}

	@Override
	public void mover() {}

}
