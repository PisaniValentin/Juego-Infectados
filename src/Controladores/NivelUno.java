package Controladores;

public class NivelUno extends Nivel{

	public NivelUno() {
		fabrica = new FabricaFacil();
		tama�oOleada = 6;
	}

	@Override
	public Nivel siguienteNivel() {
		return new NivelDos();
	}

}
