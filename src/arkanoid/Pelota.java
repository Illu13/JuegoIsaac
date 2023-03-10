package arkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor {

	private int velocidadX = -4;
	private int velocidadY = 4;

	public Pelota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pelota (int x, int y) {
		super(x, y);
		this.ancho = 10;
		this.largo = 10;
		this.setSpriteActual(ResourcesCache.getInstance().getImagen(ResourcesCache.IMAGEN_PELOTA));
	}


	@Override
	public String toString() {
		return "Pelota [velocidadMovimiento=" + x + ", y=" + y + ", ancho=" + ancho + ", largo=" + largo + "]";
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
		if (this.y < 10) {
			this.velocidadY = -this.velocidadY;
		}

	}

	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		
			
		if (a instanceof Nave || a instanceof Ladrillo) {
			this.velocidadY = -this.velocidadY;
		}
		this.y += this.velocidadY;
		
	}

}
