package ObjetosTemporales;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDaņoDoble;

public class DaņoDoble extends Premio {

	public DaņoDoble(Punto p, Mapa map) {
		super(p, map);
		this.cambiarImagen("Imagenes/danodoble.png");
		visitor = new VisitorDaņoDoble(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
