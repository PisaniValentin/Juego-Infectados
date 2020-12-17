package Controladores;

public class NivelDos extends Nivel{

	public NivelDos() {
		fabrica = new FabricaMedia();
		tamañoOleada = 9;
	}

	@Override
	public Nivel siguienteNivel() {
		return new NivelTres();
	}

}
