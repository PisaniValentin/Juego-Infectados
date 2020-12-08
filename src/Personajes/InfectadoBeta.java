package Personajes;


import Juego.Mapa;
import Juego.Punto;

public class InfectadoBeta extends InfectadoAlpha {
protected Punto p;

	public InfectadoBeta(Punto p,Mapa map) {
		super(p,map);
		mapa = map;
		this.cambiarImagen("Imagenes/zombieBeta.gif");
		velocidad= 1;
	}
	
	public void descongelar() {
		velocidad=1;
		this.setImagen("Imagenes/zombieBeta.gif");
	}
	
	
	public void recibirDaño(int daño) {
		if(cargaViral>5) {
			this.cargaViral=cargaViral-daño/2;
			System.out.println("recibe daño el zombie, vida:"+cargaViral);
		}else {
			this.cargaViral=cargaViral-daño/2;
			System.out.println("el zombie murio, vida:"+cargaViral);
			mapa.getGui().remove(this.getImagen());
			mapa.getGui().repaint();
			mapa.getListaObjectos().remove(this);
			controlador.setPersonaje(null);
		}
	}

}
