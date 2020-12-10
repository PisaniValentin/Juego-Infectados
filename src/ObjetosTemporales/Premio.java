package ObjetosTemporales;

import java.awt.Rectangle;

import Controladores.Controlador;
import Controladores.ControladorPremios;
import GameObjects.GameObject;
import Juego.Mapa;
import Juego.Punto;

public abstract class Premio extends GameObject
{

	protected Rectangle hitbox;
	protected Controlador controlador;
	
	public Premio(Punto p, Mapa map)
	{
		controlador = new ControladorPremios(this);
		punto = p;
		mapa = map;
	}
	
	@Override
	public void mover() {
		controlador.start();
	}
}
