package Controladores;

import java.util.Random;

import Personajes.InfectadoAlpha;
import Personajes.InfectadoBeta;
import Personajes.Personaje;

public class FabricaMedia implements FactoryInfectados {

	@Override
	public Personaje create() {
		Random r = new Random();
		Personaje toReturn = null;
		if (r.nextBoolean()) {
			toReturn = new InfectadoAlpha(null, null);
		} else {
			toReturn = new InfectadoBeta(null, null);
		}
		return toReturn;
	}

}
