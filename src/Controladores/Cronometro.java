package Controladores;

public class Cronometro extends Thread{
protected int tiempo;
protected boolean noTermina;

	public Cronometro(int tiempo) {
		this.tiempo = tiempo;
		noTermina = true;
	}
	
	public void run() {
		pausar();
	}
	
	public void pausar() {
		try {
			this.sleep(tiempo);
			noTermina = true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean termino() {
		return noTermina;
	}
	
}
