package arkanoid;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;



public class ImagesCache {

	public static String IMAGEN_PELOTA = "pelota.png";
	public static String IMAGEN_NAVE = "nave.png";
	public static String IMAGEN_LADRILLO = "clio.png";

	private HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();

	// Instancia Singleton
	private static ImagesCache instance = null;

	/**
	 * Getter Singleton
	 * 
	 * @return
	 */
	public static ImagesCache getInstance() {
		if (instance == null) {
			instance = new ImagesCache();
		}
		return instance;
	}
	
	private BufferedImage cargarImagen (String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) { // algo ha fallado, se acaba el programa si no podemos cargar alguna imagen
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	
	/**
	 * M�todo utilizado desde fuera de esta clase para permitir acceder a las im�genes. En primer lugar se 
	 * busca la imagen en el almac�n, si no se encuentra se busca en el sistema de ficheros.
	 * @param nombre
	 * @return
	 */
	public BufferedImage getImagen(String nombre) {
		BufferedImage img = sprites.get(nombre);
		if (img == null) {
			img = cargarImagen("resources/images/" + nombre);
			sprites.put(nombre,img);
		}
		return img;
	}

}
