package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.MenuKeyListener;



public class Nave extends Actor {

	protected static int VELOCIDAD = 5;
	protected int vidas;
	private boolean izquierda = false, derecha = false;

	public Nave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nave(int x, int y, int ancho, int largo) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.largo = largo;
	}

	public Nave(int velocidad, int vidas) {
		super();
		this.vidas = vidas;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	@Override
	public String toString() {
		return "Nave [velocidad=" + ", vidas=" + vidas + ", x=" + x + ", y=" + y + ", ancho=" + ancho + ", largo="
				+ largo + "]";
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.ancho, this.largo);
	}

	@Override
	public void actua() {
		if (izquierda)
			this.x -= VELOCIDAD;
		if (derecha)
			this.x += VELOCIDAD;
		
		mover(this.x);

	}

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = true;
			break;
		case KeyEvent.VK_RIGHT:
			derecha = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = false;
			break;
		case KeyEvent.VK_RIGHT:
			derecha = false;
			break;
		}
	}
	
	public void mover(int x) {
		this.x = x;
		// Controlo los casos en los que el jugador pueda salir del Canvas
		MiCanvas canvas = Arkanoid.getInstance().getCanvas(); // Referencia al objeto Canvas usado
		
		// Compruebo si el jugador sale por la derecha
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}

		// Compruebo si el jugador sale por la izquierda
		if (this.x < 0) {
			this.x = 0;
		}
	}
}
