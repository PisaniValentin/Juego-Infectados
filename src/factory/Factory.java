package factory;

import Juego.Mapa;
import Juego.Punto;
import Personajes.InfectadoAlpha;
import Personajes.InfectadoBeta;
import Personajes.Personaje;

public class Factory {
	protected Mapa map;

	public Factory(Mapa map) {
		this.map = map;
	}

	public Personaje getPersonaje(String nombre, Punto punto) {
		if (nombre.equals("alpha")) {
			return new InfectadoAlpha(punto, map);
		} else {
			return new InfectadoBeta(punto, map);
		}
	}

}
