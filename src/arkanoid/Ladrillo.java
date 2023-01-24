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

	public Ladrillo(int x, int y, int ancho, int largo, String color, int puntosVida) {
		super(x, y);
		this.largo = 36;
		this.ancho = 20;
		this.setSpriteActual(ResourcesCache.getInstance().getImagen(ResourcesCache.IMAGEN_LADRILLO));
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

	@Override
	public void actua() {
		// TODO Auto-generated method stub

	}

	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con un player o un disparo, eliminamos al monstruo
		if (a instanceof Pelota) {
				Arkanoid.getInstance().eliminaActor(this);
			Arkanoid.getInstance().incorporaNuevoActor(new Explosion(this.x, this.y));
			System.out.println("Hola");
		}
	}


}
