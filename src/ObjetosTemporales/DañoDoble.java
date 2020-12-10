package ObjetosTemporales;

import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDa�oDoble;

public class Da�oDoble extends Premio {

	public Da�oDoble(Punto p, Mapa map) {
		super(p,map);
		this.cambiarImagen("Imagenes/danodoble.png");
		visitor = new VisitorDa�oDoble(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
