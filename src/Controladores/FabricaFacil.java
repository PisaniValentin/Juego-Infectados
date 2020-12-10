package Controladores;

import Personajes.Infectado;
import Personajes.Personaje;

public class FabricaFacil implements FactoryInfectados {

	@Override
	public Personaje create() {
		return new Infectado(null, null);
	}

}
