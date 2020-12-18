package factory;

import java.util.Random;

import Personajes.Personaje;

public class FabricaMedia implements FactoryInfectados {

	protected FactoryInfectados infectado, alpha, beta;

	public FabricaMedia() {
		infectado = new FabricaInfectado();
		alpha = new FabricaAlpha();
		beta = new FabricaBeta();
	}

	@Override
	public Personaje create() {
		Random r = new Random();
		Personaje toReturn = null;
		switch (r.nextInt(3)) {
		case 0: {
			toReturn = infectado.create();
			break;
		}
		case 1: {
			toReturn = alpha.create();
			break;
		}
		case 2: {
			toReturn = beta.create();
			break;
		}
		}
		return toReturn;
	}

}
