package Controladores;

import Personajes.InfectadoAlpha;
import Personajes.Personaje;

public class FabricaFacil implements FactoryInfectados {

	@Override
	public Personaje create() {
		return new InfectadoAlpha(null, null);
	}

}
