package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDa�oDoble;

public class Da�oDoble extends Premio {

	public Da�oDoble(Punto p, Mapa map) {
		super(p,map);
		this.cambiarImagen("Imagenes/danodoble.png");
		hitbox = new Rectangle();
		visitor = new VisitorDa�oDoble(this);
	}

	public void buff() {
		int da�o = mapa.getJugador().getArma().getDa�o();
		mapa.getJugador().getArma().setDa�o(da�o*2);
		mapa.getListaObjectos().remove(this);
		mapa.getGui().remove(this.getImagen());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mapa.getJugador().getArma().setDa�o(da�o);
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
