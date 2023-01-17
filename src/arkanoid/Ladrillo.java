package arkanoid;

import java.awt.Color;
import java.awt.Graphics;



public class Ladrillo extends Actor {
	
	protected int puntosVida;
	protected String color;
	
	
	public Ladrillo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ladrillo(int x, int y, int ancho, int largo, String color) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.largo = largo;
		this.color = color;
	}
	public Ladrillo(int puntosVida, String color) {
		super();
		this.puntosVida = puntosVida;
		this.color = color;
	}
	public int getPuntosVida() {
		return puntosVida;
	}
	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Ladrillo [puntosVida=" + puntosVida + ", color=" + color + ", x=" + x + ", y=" + y + ", ancho=" + ancho
				+ ", largo=" + largo + "]";
	}
	
	public void paint(Graphics g) {
		
		if (color == "Rojo") {
			g.setColor(Color.RED);
			g.fillRect(this.x, this.y, this.ancho, this.largo);
		}
		if (color == "Verde") {
			g.setColor(Color.GREEN);
			g.fillRect(this.x, this.y, this.ancho, this.largo);
		}
		if (color == "Azul") {
			g.setColor(Color.BLUE);
			g.fillRect(this.x, this.y, this.ancho, this.largo);
		}
		if (color == "Naranja") {
			g.setColor(Color.ORANGE);
			g.fillRect(this.x, this.y, this.ancho, this.largo);
		}
		if (color == "Plateado") {
			g.setColor(Color.GRAY);
			g.fillRect(this.x, this.y, this.ancho, this.largo);
		}
		if (color == "Dorado") {
			g.setColor(Color.YELLOW);
			g.fillRect(this.x, this.y, this.ancho, this.largo);
		}
	}
	@Override
	public void actua() {
		// TODO Auto-generated method stub
		
	}
	
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con un player o un disparo, eliminamos al monstruo
		if (a instanceof Pelota) {
			Arkanoid.getInstance().eliminaActor(this);
		}
	}
	
}
