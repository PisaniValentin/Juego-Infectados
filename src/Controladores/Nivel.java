package Controladores;

import java.util.LinkedList;
import java.util.List;

import GameObjects.GameObject;

public abstract class Nivel {
	protected FactoryInfectados fabrica;
	protected int tamañoOleada;

	public Iterable<GameObject> getOleada1() {
		List<GameObject> toReturn = new LinkedList<GameObject>();
		for (int i = 0; i < tamañoOleada / 2; i++) {
			toReturn.add(fabrica.create());
		}
		return toReturn;
	}

	public Iterable<GameObject> getOleada2() {
		List<GameObject> toReturn = new LinkedList<GameObject>();
		for (int i = 0; i < tamañoOleada / 2; i++) {
			toReturn.add(fabrica.create());
		}
		return toReturn;
	}
	
	public abstract Nivel siguienteNivel();
}
