package arkanoid;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public abstract class Actor {
	
	protected int x;
	protected int y;
	protected int ancho = 30;
	protected int largo = 30;
	protected BufferedImage img;
	
	
	
	
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
	}


	public Actor(int x, int y, BufferedImage img) {
		super();
		this.x = x;
		this.y = y;
	
		this.setImg(img);
	}
	
	public abstract void actua ();
	
	public void colisionaCon(Actor a) {
	}
	
	public BufferedImage getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
		this.ancho = this.img.getWidth();
		this.largo = this.img.getHeight();
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
