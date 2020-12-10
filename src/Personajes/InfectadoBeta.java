package Personajes;

import Juego.Mapa;
import Juego.Punto;

public class InfectadoBeta extends InfectadoAlpha {
	protected Punto p;

	public InfectadoBeta(Punto p, Mapa map) {
		super(p, map);
		mapa = map;
		this.cambiarImagen("Imagenes/zombieBeta.gif");
		velocidad = 1;
		arma = new Arma(30, 20);
	}

	public void descongelar() {
		velocidad = 1;
		this.setImagen("Imagenes/zombieBeta.gif");
	}

	public void recibirDaño(int daño) {
		if (cargaViral > 0) {
			this.cargaViral = cargaViral - daño / 2;
			if (cargaViral == 0) {
				mapa.getGui().remove(this.getImagen());
//				mapa.restarContadorInfectados();
				mapa.getGui().repaint();
				mapa.getListaObjectos().remove(this);
			}
		}
	}

}
