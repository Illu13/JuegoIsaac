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
	public Ladrillo(int x, int y, int ancho, int largo) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.largo = largo;
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
		g.setColor(Color.YELLOW);
		g.fillRect(this.x, this.y, this.ancho, this.largo);
	}
	@Override
	public void actua() {
		// TODO Auto-generated method stub
		
	}
	
}
