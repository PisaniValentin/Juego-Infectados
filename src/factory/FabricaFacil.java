package factory;

import Personajes.Personaje;

public class FabricaFacil implements FactoryInfectados {
	
	protected FactoryInfectados infectados;
	
	public FabricaFacil()
	{
		infectados = new FabricaInfectado();
	}

	@Override
	public Personaje create() {
		return infectados.create();
	}

}
