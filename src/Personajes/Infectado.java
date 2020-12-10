package Personajes;

import java.awt.Rectangle;
import java.util.Random;

import Controladores.Controlador;
import Controladores.ControladorInfectados;
import Controladores.FabricaPremio;
import Controladores.FabricaPremioRandom;
import Juego.Mapa;
import Juego.Punto;
import ObjetosTemporales.Premio;
import Visitor.Visitor;
import Visitor.VisitorInfectado;

public class Infectado extends Personaje
{
	protected Rectangle hitbox_zombie;
	protected Controlador controlador;
	protected FabricaPremio fabrica;

	public Infectado(Punto p, Mapa map)
	{
		super(100,10);
		this.punto = p;
		mapa = map;
		this.cambiarImagen("Imagenes/zombie.gif");
		velocidad = 1;
		arma = new Arma(10, 10);
		visitor = new VisitorInfectado(this, arma.getDaño());
		controlador = new ControladorInfectados(this);
		controlador.setPersonaje(this);
		fabrica = new FabricaPremioRandom();
	}

	public void descongelar() {
		velocidad = 2;
		this.setImagen("Imagenes/zombie.gif");
	}

	public void recibirDaño(int daño) {
		if (cargaViral > 0) {
			this.cargaViral = cargaViral - daño;
			if (cargaViral <= 0) {
				mapa.getGui().remove(this.getImagen());
				mapa.getGui().repaint();
				mapa.getListaObjectos().remove(this);
				Random r = new Random();
				float chance = r.nextFloat();
				if (chance < 0.30f) {
					Premio premio = fabrica.create();
					premio.setMapa(this.mapa);
					premio.setPunto(this.punto);
					premio.getImagen().setLocation(this.punto.getX(), this.punto.getY());
					premio.getImagen().setSize(24, 26);
					mapa.getGui().add(premio.getImagen());
					mapa.getGui().repaint();
					premio.mover();
				}
			}
			System.out.println("recibe daño el zombie, vida:" + cargaViral);
		}
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
	public void mover() {
		this.controlador.start();
	}

	public void congelar() {
		controlador.congelar();
	}

	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(), this.getPunto().getY(), this.getAncho(), this.getAlto());
	}

	public Controlador getControlador() {
		return controlador;
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
