package factory;

import java.util.Random;

import ObjetosTemporales.Congelacion;
import ObjetosTemporales.DañoDoble;
import ObjetosTemporales.Pocion;
import ObjetosTemporales.Premio;

public class FabricaPremioRandom implements FabricaPremio {

	@Override
	public Premio create() {
		Premio p = null;
		Random r = new Random();
		switch (r.nextInt(3)) {
		case 0: {
			p = new Pocion(null, null);
			break;

		}
		case 1: {
			p = new Congelacion(null, null);
			break;
		}
		case 2: {
			p = new DañoDoble(null, null);
			break;
		}
		}
		return p;
	}

}
