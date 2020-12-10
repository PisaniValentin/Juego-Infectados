package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorPocion;

public class Pocion extends Premio
{
	public Pocion(Punto p, Mapa map) {
		super(p,map);
		this.cambiarImagen("Imagenes/pocion.png");
		hitbox = new Rectangle();
		visitor = new VisitorPocion(this);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

	public Visitor getVisitor() {
		return visitor;
	}
	

	@Override
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(), this.getPunto().getY(), this.getAncho(), this.getAlto());
	}


	@Override
	public Controlador getControlador() {
		return null;
	}
	
}
