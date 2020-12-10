package Proyectiles;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Controlador;
import Juego.Punto;
import Visitor.Visitor;
import Visitor.VisitorDisparoInfectado;

public class ProyectilInfectado extends Proyectil {

	protected Rectangle hitbox_proyectil;
	
	public ProyectilInfectado(int rango, int daño, Punto punto) {
		super(rango, daño, punto);
		visitor = new VisitorDisparoInfectado(this, daño);
		hitbox_proyectil = new Rectangle(this.getPunto().getX(), this.getPunto().getY(), ancho, alto);
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getClassLoader().getResource("Imagenes/disparox2.png"));
		imagen = new JLabel(icono_imagen);
		ancho = icono_imagen.getIconWidth();
		alto = icono_imagen.getIconHeight();
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Rectangle getHitbox() {
		Rectangle hitbox_actual = new Rectangle(this.getPunto().getX(), this.getPunto().getY(), ancho, alto);
		return hitbox_actual;
	}

	@Override
	public Controlador getControlador() {
		// TODO Auto-generated method stub
		return null;
	}

}
