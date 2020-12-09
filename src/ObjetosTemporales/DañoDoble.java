package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import Controladores.TemporizadorHielo;
import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorPremios;

public class DañoDoble extends GameObject{

	protected Rectangle hitbox;

	public DañoDoble(Punto p,Mapa map) {
		this.cambiarImagen("Imagenes/hielo.png");
		hitbox = new Rectangle();
		punto = p;
		mapa = map;
		visitor = new VisitorPremios(this);
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	@Override
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(),this.getPunto().getY(),this.getAncho(),this.getAlto());
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
	
	public void buff() {
		TemporizadorHielo tempo = new TemporizadorHielo(this,mapa);
		tempo.start();
		mapa.getListaObjectos().remove(this);
		mapa.getGui().remove(this.getImagen());
	}

	@Override
	public Controlador getControlador() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

}
