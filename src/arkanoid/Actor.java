package arkanoid;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public abstract class Actor {
	
	protected int x;
	protected int y;
	protected int ancho = 30;
	protected int largo = 30;
	protected BufferedImage img;
	protected BufferedImage spriteActual;
	protected boolean marcadoParaEliminacion = false;
	// Posibilidad de que el actor sea animado, a trav�s del siguiente array de sprites y las variables
	// velocidadDeCambioDeSprite y unidadDeTiempo
	protected List<BufferedImage> spritesDeAnimacion = new ArrayList<BufferedImage>();
	protected int velocidadDeCambioDeSprite = 0;
	private int unidadDeTiempo = 0;
	
	
	
	
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
	
	public void actua() {
		// En el caso de que exista un array de sprites el actor actual se tratar� de una animaci�n, para eso llevaremos a cabo los siguientes pasos
		if (this.spritesDeAnimacion != null && this.spritesDeAnimacion.size() > 0) {
			unidadDeTiempo++;
			if (unidadDeTiempo % velocidadDeCambioDeSprite == 0){
				unidadDeTiempo = 0;
				int indiceSpriteActual = spritesDeAnimacion.indexOf(this.spriteActual);
				int indiceSiguienteSprite = (indiceSpriteActual + 1) % spritesDeAnimacion.size();
				this.spriteActual = spritesDeAnimacion.get(indiceSiguienteSprite);
			}
		}
	}
	
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
	
	public BufferedImage getSpriteActual() {
		return this.spriteActual;
	}

	/**
	 * @param img the img to set
	 */
	public void setSpriteActual(BufferedImage spriteActual) {
		
		try {
		this.spriteActual = spriteActual;
		this.ancho = this.spriteActual.getWidth();
		this.largo = this.spriteActual.getHeight();
		} catch (Exception e) {
			System.out.println("Hubo un problema.");
			e.printStackTrace();
		}
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
	
	public List<BufferedImage> getSpritesDeAnimacion() {
		return spritesDeAnimacion;
	}

	/**
	 * @param spritesDeAnimacion the spritesDeAnimacion to set
	 */
	public void setSpritesDeAnimacion(List<BufferedImage> spritesDeAnimacion) {
		this.spritesDeAnimacion = spritesDeAnimacion;
	}

	
	

}
