package ObjetosTemporales;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorPremios;

public class Congelacion extends Premio {

	public Congelacion(Punto p, Mapa map) {
		super(p,map);
		this.cambiarImagen("Imagenes/hielo.png");
		visitor = new VisitorPremios(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
