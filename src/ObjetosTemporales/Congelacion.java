package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import Controladores.ControladorPremios;
import Controladores.Temporizador;
import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorEfectoCongelar;

public class Congelacion extends GameObject{
protected Rectangle hitbox;
protected Controlador controlador;

	public Congelacion(Punto p,Mapa map) {
		this.cambiarImagen("Imagenes/hielo.png");
		hitbox = new Rectangle();
		punto = p;
		mapa = map;
		visitor = new VisitorEfectoCongelar(this);
		controlador = new ControladorPremios(this,mapa);
	}
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void mover() {
		controlador.start();
	}
	
	@Override
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(),this.getPunto().getY(),this.getAncho(),this.getAlto());
	}
	
	public void congelar() {
		Temporizador tempo = new Temporizador(this,mapa);
		tempo.start();
		mapa.getListaObjectos().remove(this);
		mapa.getGui().remove(this.getImagen());
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Controlador getControlador() {
		return null;
	}

}
