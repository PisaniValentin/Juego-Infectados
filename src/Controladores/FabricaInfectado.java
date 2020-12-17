package Controladores;

import Personajes.Infectado;
import Personajes.Personaje;

public class FabricaInfectado implements FactoryInfectados {

	@Override
	public Personaje create() {
		return new Infectado(null, null);
	}

}
