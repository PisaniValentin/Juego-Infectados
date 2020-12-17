package factory;

import java.util.Random;

import Personajes.Personaje;

public class FabricaDificil implements FactoryInfectados {

	protected FactoryInfectados alpha, beta;
	
	public FabricaDificil()
	{
		alpha = new FabricaAlpha();
		beta = new FabricaBeta();
	}
	@Override
	public Personaje create() {
		Personaje toReturn = null;
		Random r = new Random();
		if (r.nextBoolean()) {
			toReturn = alpha.create();
		} else {
			toReturn = beta.create();
		}
		return toReturn;
	}

}
