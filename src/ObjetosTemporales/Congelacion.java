package ObjetosTemporales;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorCongelar;

public class Congelacion extends Premio {

	public Congelacion(Punto p, Mapa map) {
		super(p, map);
		this.cambiarImagen("Imagenes/hielo.png");
		visitor = new VisitorCongelar(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
