package Controladores;

import Personajes.InfectadoBeta;
import Personajes.Personaje;

public class FabricaDificil implements FactoryInfectados {

	@Override
	public Personaje create() {
		return new InfectadoBeta(null, null);
	}

}
