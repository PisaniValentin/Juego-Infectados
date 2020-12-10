package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import GameObjects.GameObject;
import Visitor.Visitor;

public abstract class Premio extends GameObject
{

	protected Rectangle hitbox;
	protected Controlador controlador;
	

	@Override
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(), this.getPunto().getY(), this.getAncho(), this.getAlto());
	}


	@Override
	public void mover() {
		controlador.start();
	}

	@Override
	public Controlador getControlador() {
		return null;
	}

}
