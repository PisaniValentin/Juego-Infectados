package ObjetosTemporales;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorPocion;

public class Pocion extends Premio {
	public Pocion(Punto p, Mapa map) {
		super(p, map);
		this.cambiarImagen("Imagenes/pocion.png");
		visitor = new VisitorPocion(this);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);

	}
}
