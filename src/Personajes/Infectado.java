package Personajes;

import java.awt.Rectangle;

import Controladores.Controlador;
import Controladores.ControladorInfectados;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorInfectado;

public class Infectado extends Personaje {
	protected Rectangle hitbox_zombie;
	protected Controlador controlador;
	
	public Infectado(Punto p,Mapa map) {
		super(100,10,10);
		this.setPunto(p);
		this.cambiarImagen("Imagenes/zombie.gif");
		mapa = map;
		velocidad=1;
		visitor = new VisitorInfectado(this);
		controlador = new ControladorInfectados();
		controlador.setPersonaje(this);
		controlador.setMapa(map);
		controlador.setGUI(mapa.getGui());
		controlador.setLista(mapa.getListaObjectos());
		hitbox_zombie = new Rectangle(this.getPunto().getX(),this.getPunto().getY(),this.getAncho(),this.getAlto());
	}
	
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(),this.getPunto().getY(),this.getAncho(),this.getAlto());
	}
	
	public Controlador getControlador() {
		return controlador;
	}
	
	public void recibirDaño() {
		if(vida>5) {
			this.vida=vida-5;
			System.out.println("recibe daño el zombie, vida:"+vida);
		}else {
			this.vida=vida-5;
			System.out.println("el zombie murio, vida:"+vida);
			mapa.getGui().remove(this.getImagen());
			mapa.getGui().repaint();
			mapa.getListaObjectos().remove(this);
			controlador.setPersonaje(null);
			//controlador.stop();
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

	
}
