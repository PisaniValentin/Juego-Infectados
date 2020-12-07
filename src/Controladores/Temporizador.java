package Controladores;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import GameObjects.GameObject;
import Juego.Mapa;
import Personajes.Infectado;
import Visitor.Visitor;

public class Temporizador extends Thread {
protected boolean termino;
protected Mapa mapa;
protected GameObject objeto;

	public Temporizador(GameObject objeto,Mapa mapa) {
		this.objeto=objeto;
		termino = false;
		this.mapa = mapa;
	}
	
	public Temporizador() {
		termino = false;
	}
	
	public void run() {
		activarEfectoTemporal();
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
	
	public void activarEfectoTemporal() {
		boolean recorro = true;
		Visitor visitor = objeto.getVisitor();
		List<GameObject> lista_aux = new LinkedList<GameObject>();
		for (GameObject objeto : mapa.getListaObjectos()) {
			lista_aux.add(objeto);
		}
		
		for (GameObject objeto : lista_aux) {
			objeto.accept(visitor);
		}
		
		this.iniciarTemporizador();
		while(recorro) {
			if(this.getTiempo()) {
				recorro=false;
			}
		}
		
		for (GameObject objeto : lista_aux) {
			objeto.accept(visitor);
		}
	}
	
	
}
