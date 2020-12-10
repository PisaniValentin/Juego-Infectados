package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.ControladorPremios;
import Controladores.TemporizadorHielo;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorPremios;

public class Congelacion extends Premio {

	public Congelacion(Punto p, Mapa map) {
		this.cambiarImagen("Imagenes/hielo.png");
		hitbox = new Rectangle();
		punto = p;
		mapa = map;
		visitor = new VisitorPremios(this);
		controlador = new ControladorPremios(this);
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

	public Visitor getVisitor() {
		return visitor;
	}
}
