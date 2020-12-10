package Controladores;

import java.util.LinkedList;
import java.util.List;

import GameObjects.GameObject;

public class Nivel {
	protected FactoryInfectados fabrica;
	protected int tama�oOleada;
	protected int numeroNivel;

	public Nivel() {
		this.fabrica = new FabricaFacil();
		numeroNivel = 1;
		tama�oOleada = 6;
	}

	public Iterable<GameObject> getOleada1() {
		List<GameObject> toReturn = new LinkedList<GameObject>();
		for (int i = 0; i < tama�oOleada / 2; i++) {
			toReturn.add(fabrica.create());
		}
		return toReturn;
	}

	public Iterable<GameObject> getOleada2() {
		List<GameObject> toReturn = new LinkedList<GameObject>();
		for (int i = 0; i < tama�oOleada / 2; i++) {
			toReturn.add(fabrica.create());
		}
		return toReturn;
	}

	public void cambiarNivel() {
		numeroNivel++;
		switch (numeroNivel) {
		case 2:
			fabrica = new FabricaMedia();
			tama�oOleada = 8;
			break;
		case 3:
			fabrica = new FabricaDificil();
			tama�oOleada = 10;
			break;
		default:
			fabrica = new FabricaFacil();
			tama�oOleada = 6;
			numeroNivel = 4;
			break;
		}
	}

	public int getNumeroNivel() {
		return numeroNivel;
	}

	public boolean tieneSiguiente() {
		return numeroNivel <= 3;
	}
}
