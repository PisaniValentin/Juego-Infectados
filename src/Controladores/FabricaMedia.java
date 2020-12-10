package Controladores;

import java.util.Random;

import Personajes.Infectado;
import Personajes.InfectadoAlpha;
import Personajes.InfectadoBeta;
import Personajes.Personaje;

public class FabricaMedia implements FactoryInfectados {

	@Override
	public Personaje create() {
		Random r = new Random();
		Personaje toReturn = null;
		switch(r.nextInt(3))
		{
		case 0: {
			toReturn = new Infectado(null,null);
			break;
		}
		case 1: {
			toReturn = new InfectadoAlpha(null,null);
			break;
		}
		case 2: {
			toReturn = new InfectadoBeta(null,null);
			break;
		}
		}
		return toReturn;
	}

}
