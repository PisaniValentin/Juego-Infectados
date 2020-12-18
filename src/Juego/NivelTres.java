package Juego;

import factory.FabricaDificil;

public class NivelTres extends Nivel {

	public NivelTres() {
		fabrica = new FabricaDificil();
		tama�oOleada = 12;
	}

	@Override
	public Nivel siguienteNivel() {
		return new NivelUno();
	}

}
