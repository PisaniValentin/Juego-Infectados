package Personajes;

import java.awt.Rectangle;

import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDisparoInfectado;
import Visitor.VisitorInfectado;

public class Infectado extends Personajes {
	protected Rectangle hitbox_zombie;

	public Infectado(Punto p) {
		super(100,10,10);
		this.setPunto(p);
		this.cambiarImagen("Imagenes/test1.png");
		visitor = new VisitorInfectado(this);
		hitbox_zombie = new Rectangle(this.getPunto().getX(),this.getPunto().getY(),getAncho(),getLargo());
	}
	
	public Rectangle getHitbox() {
		return hitbox_zombie;
	}
	
	public void recibirDaño() {
		this.vidas=vidas-5;
		System.out.println("recibe daño el zombie, vida:"+vidas);
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
		// TODO Auto-generated method stub
		
	}



	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

	
}
