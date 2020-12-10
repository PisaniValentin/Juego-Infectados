package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.TemporizadorHielo;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDaņoDoble;

public class DaņoDoble extends Premio {

	public DaņoDoble(Punto p, Mapa map) {
		this.cambiarImagen("Imagenes/danodoble.png");
		hitbox = new Rectangle();
		punto = p;
		mapa = map;
		visitor = new VisitorDaņoDoble(this);
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
