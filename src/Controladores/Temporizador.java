package Controladores;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

import GameObjects.GameObject;
import Juego.Mapa;
import Personajes.Infectado;

public class Temporizador extends Thread {
protected boolean termino;
protected Mapa mapa;
	public Temporizador(Mapa mapa) {
		termino = false;
		this.mapa = mapa;
	}
	
	public void run() {
		congelar();
	}
	
	public void iniciarTemporizador() {
		try {
			this.sleep(3000);
			termino=true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean getTiempo() {
		return termino;
	}
	
	public void congelar() {
		boolean recorro = true;
		JLabel imagen = new JLabel();
		List<GameObject> lista_aux = new LinkedList<GameObject>();
		for (GameObject objeto : mapa.getListaObjectos()) {
			lista_aux.add(objeto);
		}
		
		for (GameObject objeto : lista_aux) {
			if(objeto instanceof Infectado) {
				Infectado zombie = (Infectado) objeto;
				zombie.setVelocidad(0);
				zombie.setImagen("Imagenes/congelado.png");
				mapa.getGui().repaint();
			}
		}
		this.iniciarTemporizador();
		while(recorro) {
			if(this.getTiempo()) {
				recorro=false;
			}
		}
		for (GameObject objeto : lista_aux) {
			if(objeto instanceof Infectado) {
				Infectado zombie = (Infectado) objeto;
				zombie.setVelocidad(1);
				zombie.setImagen("Imagenes/zombie.gif");
				mapa.getGui().repaint();
			}
		}
	}
	
}
