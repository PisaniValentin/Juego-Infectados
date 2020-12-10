package ObjetosTemporales;

import Controladores.TemporizadorHielo;
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

	public void congelar() {
		TemporizadorHielo tempo = new TemporizadorHielo(this, mapa);
		tempo.start();
		mapa.getGui().remove(this.getImagen());
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

}
