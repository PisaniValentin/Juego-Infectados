package ObjetosTemporales;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDañoDoble;

public class DañoDoble extends Premio {

	public DañoDoble(Punto p, Mapa map) {
		super(p,map);
		this.cambiarImagen("Imagenes/danodoble.png");
		visitor = new VisitorDañoDoble(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
