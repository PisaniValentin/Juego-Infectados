package Personajes;

import java.awt.Rectangle;
import java.util.Random;

import Controladores.Controlador;
import Controladores.ControladorInfectados;
import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import ObjetosTemporales.Congelacion;
import Visitor.Visitor;
import Visitor.VisitorInfectado;

public class InfectadoAlpha extends Personaje {
	protected Rectangle hitbox_zombie;
	protected Controlador controlador;

	public InfectadoAlpha(Punto p, Mapa map) {
		super(100, 10);
		this.punto = p;
//		Punto punto = p;
//		this.setPunto(punto);
		this.cambiarImagen("Imagenes/zombie.gif");
		mapa = map;
		velocidad = 2;
		arma = new Arma(30, 30);
		visitor = new VisitorInfectado(this, arma.getDaño());
		controlador = new ControladorInfectados(this);
		controlador.setPersonaje(this);
//		controlador.setMapa(map);
//		controlador.setLista(mapa.getListaObjectos());
//		hitbox_zombie = new Rectangle(this.getPunto().getX(), this.getPunto().getY(), this.getAncho(), this.getAlto());

	}

	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(), this.getPunto().getY(), this.getAncho(), this.getAlto());
	}

	public void descongelar() {
		velocidad = 2;
		this.setImagen("Imagenes/zombie.gif");
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void recibirDaño(int daño) {
		if (cargaViral > 0) {
			this.cargaViral = cargaViral - daño;
			if (cargaViral == 0) {

				mapa.getGui().remove(this.getImagen());
				mapa.getGui().repaint();
				mapa.getListaObjectos().remove(this);
//				mapa.restarContadorInfectados();// resto la cantidad de los infectados para controlar oleadas
				Random r = new Random();
				float chance = r.nextFloat();
				// System.out.println("el zombie murio, vida:"+cargaViral);
				// controlador.setPersonaje(null);
				if (chance < 0.30f) {
					GameObject hielo = new Congelacion(punto, mapa);
					hielo.getImagen().setLocation(this.punto.getX(), this.punto.getY());
					hielo.getImagen().setSize(24, 26);
					mapa.getGui().add(hielo.getImagen());
					mapa.getGui().repaint();
					hielo.mover();
				}
			}
			System.out.println("recibe daño el zombie, vida:" + cargaViral);
		}
	}

	public void congelar() {
		controlador.congelar();
	}

	@Override
	public void mover() {
		this.controlador.start();
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interactuar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void setVelocidad(int i) {
		velocidad = i;

	}

	public int getVelocidad() {
		return velocidad;
	}

	public boolean estaQuieto() {
		return velocidad == 0;
	}

}
