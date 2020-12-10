package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import Controladores.TemporizadorHielo;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorPremios;

public class Congelacion extends Premio {

	public Congelacion(Punto p, Mapa map) {
		super(p,map);
		this.cambiarImagen("Imagenes/hielo.png");
		hitbox = new Rectangle();
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

	public Visitor getVisitor() {
		return visitor;
	}
	

	@Override
	public Rectangle getHitbox() {
		return new Rectangle(this.getPunto().getX(), this.getPunto().getY(), this.getAncho(), this.getAlto());
	}

	@Override
	public Controlador getControlador() {
		return null;
	}

}
