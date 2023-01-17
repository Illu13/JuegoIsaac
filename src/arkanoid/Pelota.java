package arkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor {

	private int velocidadX = -5;
	private int velocidadY = -5;

	public Pelota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pelota(int x, int y, int ancho, int largo) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.largo = largo;
	}

	@Override
	public String toString() {
		return "Pelota [velocidadMovimiento=" + x + ", y=" + y + ", ancho=" + ancho + ", largo=" + largo + "]";
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(this.x, this.y, this.ancho, this.largo);
	}

	@Override
	public void actua() {
		// El monstruo se mueve de manera horizontal, en cada FPS
		this.x += this.velocidadX;
		// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
		if (this.x < 0 || (this.x + this.ancho) > Arkanoid.getInstance().getCanvas().getWidth()) {
			this.velocidadX = -this.velocidadX;
		}

		// Copiamos el esquema anterior para el movimiento vertical
		this.y += this.velocidadY;
		// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
		if (this.y < 0 || (this.y + this.largo) > Arkanoid.getInstance().getCanvas().getHeight()) {
			this.velocidadY = -this.velocidadY;
		}

	}

	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con monstruo, eliminamos el disparo
		if (a instanceof Nave) {
		}

	}

}
