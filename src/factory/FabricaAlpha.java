package factory;

import Personajes.InfectadoAlpha;
import Personajes.Personaje;

public class FabricaAlpha implements FactoryInfectados{

	@Override
	public Personaje create() {
		return new InfectadoAlpha(null,null);
	}

}
