package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import Controladores.ControladorPremios;
import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;

public abstract class Premio extends GameObject
{

	protected Rectangle hitbox;
	protected Controlador controlador;
	
	public Premio(Punto p, Mapa map)
	{
		controlador = new ControladorPremios(this);
		punto = p;
		mapa = map;
		hitbox = new Rectangle();
	}
	
	@Override
	public void mover() {
		controlador.start();
	}

	@Override
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(), this.getPunto().getY(), this.getAncho(), this.getAlto());
	}

	@Override
	public Controlador getControlador() {
		return null;
	}

	public Visitor getVisitor() {
		return visitor;
	}
	
}
