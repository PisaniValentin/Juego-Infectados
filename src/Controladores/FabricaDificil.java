package Controladores;

import java.util.Random;

import Personajes.InfectadoAlpha;
import Personajes.InfectadoBeta;
import Personajes.Personaje;

public class FabricaDificil implements FactoryInfectados {

	@Override
	public Personaje create() {
		Personaje toReturn = null;
		Random r = new Random();
		if (r.nextBoolean()) {
			toReturn = new InfectadoAlpha(null, null);
		} else {
			toReturn = new InfectadoBeta(null, null);
		}
		return toReturn;
	}

}
