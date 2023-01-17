package arkanoid;

import java.awt.Graphics;


public abstract class Actor {
	
	protected int x;
	protected int y;
	protected int ancho = 30;
	protected int largo = 30;
	
	
	
	
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract void paint(Graphics g); 


	public Actor(int x, int y, int ancho, int largo) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.largo = largo;
	}
	
	public abstract void actua ();
	
	public void colisionaCon(Actor a) {
	}




	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}




	public int getAncho() {
		return ancho;
	}




	public void setAncho(int ancho) {
		this.ancho = ancho;
	}




	public int getLargo() {
		return largo;
	}




	public void setLargo(int largo) {
		this.largo = largo;
	}




	@Override
	public String toString() {
		return "Actor [x=" + x + ", y=" + y + ", ancho=" + ancho + ", largo=" + largo + "]";
	}
	
	

}
