package Controladores;

import Juego.Punto;

public class ControladorInfectados extends Controlador {

	public void run() {
		mover();
	}
	@Override
	public void mover() {
	
		Punto pos_zombie = personaje.getPunto();
		int x = pos_zombie.getX();
		int y = pos_zombie.getY();
		int contador = 0;
		while(y<gui.getContentPane().getWidth()) {
			try {
				this.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			y = y+1;
			personaje.getPunto().setY(y);
			personaje.getImagen().setLocation(x, y);
			gui.repaint();
			contador++;
		}
		
	}

	@Override
	public void setPunto(Punto punto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Punto getPunto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
