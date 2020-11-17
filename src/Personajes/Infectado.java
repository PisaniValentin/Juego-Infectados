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
		this.cambiarImagen("Imagenes/zombie.gif");
		visitor = new VisitorInfectado(this);
		hitbox_zombie = new Rectangle(this.getPunto().getX(),this.getPunto().getY(),this.getAncho(),this.getAlto());
	}
	
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(),this.getPunto().getY(),this.getAncho(),this.getAlto());
	}
	
	public void recibirDaño() {
		if(vidas>5) {
			this.vidas=vidas-5;
			System.out.println("recibe daño el zombie, vida:"+vidas);
		}else {
			this.vidas=vidas-5;
			System.out.println("el zombie murio, vida:"+vidas);
			mapa.getGui().remove(this.getImagen());
			mapa.getGui().repaint();
			mapa.getListaInfectados().remove(this);
			
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
		// TODO Auto-generated method stub
		
	}



	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

	
}
