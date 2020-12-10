package Proyectiles;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Controlador;
import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDisparoPersonaje;

public class ProyectilJugador extends Proyectil {
	
	protected Rectangle hitbox_proyectil;

	public ProyectilJugador(int rango, int daño, Punto punto) {
		super(rango, daño, punto);
		visitor = new VisitorDisparoPersonaje(this, daño);
		hitbox_proyectil = new Rectangle(this.getPunto().getX(), this.getPunto().getY(), ancho, alto);
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getClassLoader().getResource("Imagenes/disparo.gif"));
		imagen = new JLabel(icono_imagen);
		ancho = icono_imagen.getIconWidth();
		alto = icono_imagen.getIconHeight();
	}

	public Rectangle getHitbox() {
		Rectangle hitbox_actual = new Rectangle(this.getPunto().getX(), this.getPunto().getY(), ancho, alto);
		return hitbox_actual;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	@Override
	public Controlador getControlador() {
		// TODO Auto-generated method stub
		return null;
	}
}
