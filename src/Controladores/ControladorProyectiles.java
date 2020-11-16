package Controladores;

import Juego.Punto;
import Personajes.Infectado;
import Personajes.Personajes;
import Visitor.Visitor;

public class ControladorProyectiles extends Controlador {

	public void jugar() {
		this.start();
	}
	public void run() {
		mover();
	}
	
	public void mover() {
		boolean proyectil_landed=false;
		Punto proyectil_p = new Punto(personaje.getPunto().getX()+25, personaje.getPunto().getY()-20);
		//Visitor visitor= proyectil.getVisitor();
		proyectil.setFrame(personaje.getMapa().getGui().getTerreno());
		proyectil.setPunto(proyectil_p);
		int contador=0;
		int posY = proyectil_p.getY();
		while(!proyectil_landed && contador<=proyectil.getRango()) {
			try {
				ControladorProyectiles.sleep(50);
				posY = posY - 10;
				proyectil.getPunto().setY(posY);
				proyectil.getImagen().setLocation(proyectil.getPunto().getX(), proyectil.getPunto().getY());
				gui.repaint();
				contador++;
				//System.out.println("entro aca"+proyectil.getHitbox());
				for(Personajes zombie : personaje.getMapa().getListaInfectados()) {
					if(!personaje.getMapa().getListaInfectados().isEmpty()) {
						//System.out.println("zombie"+zombie.getHitbox());
						if(proyectil.getHitbox().intersects(zombie.getHitbox())) {
							//System.out.println("entro aca");
							Visitor visitor= proyectil.getVisitor();
							zombie.accept(visitor);
							proyectil_landed = true;
							gui.repaint();
							
						}
						
					}
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		proyectil.getFrame().remove(proyectil.getImagen());
		proyectil = null;
	}

	@Override
	public void setPunto(Punto punto) {
		this.punto=punto;
	}

	@Override
	public Punto getPunto() {
		return this.punto;
	}

}
