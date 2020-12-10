package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.TemporizadorHielo;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDañoDoble;

public class DañoDoble extends Premio {

	public DañoDoble(Punto p, Mapa map) {
		this.cambiarImagen("Imagenes/danodoble.png");
		hitbox = new Rectangle();
		punto = p;
		mapa = map;
		visitor = new VisitorDañoDoble(this);
	}

	public void buff() {
		TemporizadorHielo tempo = new TemporizadorHielo(this, mapa);
		tempo.start();
		mapa.getListaObjectos().remove(this);
		mapa.getGui().remove(this.getImagen());
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

	public Visitor getVisitor() {
		return visitor;
	}

}
