package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.event.MenuKeyListener;




public class Nave extends Actor {

	protected static int VELOCIDAD = 8;
	private boolean izquierda = false, derecha = false;
	
	

	public Nave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nave(int x, int y) {
		super(x, y, ImagesCache.getInstance().getImagen(ImagesCache.IMAGEN_NAVE));
	}

	



	@Override
	public void actua() {
		if (izquierda)
			this.x -= VELOCIDAD;
		if (derecha)
			this.x += VELOCIDAD;
		
		mover(this.x, this.y);

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
	
	public void mover(int x, int y) {
		this.x = x;
		this.y = y;
		// Controlo los casos en los que el jugador pueda salir del Canvas
		MiCanvas canvas = Arkanoid.getInstance().getCanvas(); // R
		
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
