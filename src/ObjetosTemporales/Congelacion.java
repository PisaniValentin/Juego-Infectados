package ObjetosTemporales;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Controladores.Controlador;
import Controladores.Temporizador;
import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Personajes.Infectado;
import Visitor.Visitor;

public class Congelacion extends GameObject{
protected Rectangle hitbox;
	
	public Congelacion(Punto p,Mapa map) {
		this.cambiarImagen("Imagenes/hielo.png");
		hitbox = new Rectangle();
		punto = p;
		mapa = map;
	}
	
	@Override
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(),this.getPunto().getY(),this.getAncho(),this.getAlto());
	}
	
	public void congelar() {
		Temporizador tempo = new Temporizador(mapa);
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
