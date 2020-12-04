package Proyectiles;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Controladores.Controlador;
import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDisparoPersonaje;

public class ProyectilJugador extends Proyectil{
//protected Mapa mapa;
protected Rectangle hitbox_proyectil;

	public ProyectilJugador(int rango,int daño,Punto punto) {
		super(rango,daño,punto);
		visitor = new VisitorDisparoPersonaje(this,this.getMapa());
		hitbox_proyectil = new Rectangle(this.getPunto().getX(),this.getPunto().getY(),ancho,alto);
	}
	
	public JLabel getImagen() {
		return imagen;
	}
	
	public Rectangle getHitbox() {
		Rectangle hitbox_actual = new Rectangle(this.getPunto().getX(),this.getPunto().getY(),ancho,alto);
		return hitbox_actual;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
//	public void remove() {
//		mapa.getGui().remove(this.getImagen());
//	}

	@Override
	public Controlador getControlador() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public boolean hayColision(GameObject p) {
//		Rectangle hitbox_proyectil = new Rectangle(this.getPunto().getX(),this.getPunto().getY(),ancho,alto);
//		Rectangle hitbox_zombie = new Rectangle(p.getPunto().getX(),p.getPunto().getY(),p.getAncho(),p.getLargo());
//		
//		return hitbox_proyectil.intersects(hitbox_zombie);
//	}
	
}
