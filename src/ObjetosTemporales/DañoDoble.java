package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDañoDoble;

public class DañoDoble extends Premio {

	public DañoDoble(Punto p, Mapa map) {
		super(p,map);
		this.cambiarImagen("Imagenes/danodoble.png");
		hitbox = new Rectangle();
		visitor = new VisitorDañoDoble(this);
	}

	public void buff() {
		int daño = mapa.getJugador().getArma().getDaño();
		mapa.getJugador().getArma().setDaño(daño*2);
		mapa.getListaObjectos().remove(this);
		mapa.getGui().remove(this.getImagen());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mapa.getJugador().getArma().setDaño(daño);
	}

	@Override
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
