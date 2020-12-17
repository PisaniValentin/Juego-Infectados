package Controladores;

import java.util.LinkedList;
import java.util.List;
import GameObjects.GameObject;
import Juego.Mapa;
import Visitor.Visitor;

public class TemporizadorHielo extends Thread {
	protected boolean termino;
	protected Mapa mapa;
	protected GameObject objeto;

	public TemporizadorHielo(GameObject objeto, Mapa mapa) {
		this.objeto = objeto;
		termino = false;
		this.mapa = mapa;
	}

	public TemporizadorHielo() {
		termino = false;
	}

	public void run() {
		activarEfectoTemporal();
	}

	public void iniciarTemporizador() {
		try {
			Thread.sleep(3000);
			termino = true;
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
		mapa.getListaObjectos().remove(objeto);
		mapa.getGui().remove(objeto.getImagen());
		List<GameObject> lista_aux = new LinkedList<GameObject>();
		for (GameObject obj: mapa.getListaObjectos()) {
			lista_aux.add(obj);
		}
		for (GameObject obj : lista_aux) {
			obj.accept(visitor);
		}
		this.iniciarTemporizador();
		while (recorro) {
			if (this.getTiempo()) {
				recorro = false;
			}
		}
		for (GameObject obj : lista_aux) {
			obj.accept(visitor);
		}
	}

}
