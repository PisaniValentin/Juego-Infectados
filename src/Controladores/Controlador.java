package Controladores;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Juego.GUI;
import Juego.Mapa;
import Juego.Punto;
import Personajes.Personajes;
import Proyectiles.Proyectil;

public abstract class Controlador extends Thread {
protected Proyectil proyectil;
protected JPanel terreno;
protected Punto punto;
protected Personajes personaje;
protected JLabel imagen;
protected int ancho;
protected int largo;
protected GUI gui;
protected Mapa mapa;

public abstract void mover();
public abstract void setPunto(Punto punto);
public abstract Punto getPunto();

public GUI getGUI() {
	return gui;
}
public void setGUI(GUI gui) {
	this.gui=gui;
}


public JLabel getImagen() {
	return imagen ;
}
public void setImagen(JLabel imagen) {
	this.imagen = imagen ;
}

public Proyectil getProyectil() {
	return proyectil;
}

public Personajes getPersonaje() {
	return personaje;
}

public void setPersonaje(Personajes p) {
	this.personaje = p;
}


public void setProyectil(Proyectil p) {
	this.proyectil = p;
}

public JPanel getTerreno() {
	return terreno;
}
public void setTerreno(JPanel terreno) {
	this.terreno = terreno;
}






}
