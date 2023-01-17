package arkanoid;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import utils.Utils;

public class Arkanoid {

	private static int FPS = 60;
	private JFrame ventana = null;
	private List<Actor> actores = new ArrayList<Actor>();
	private MiCanvas canvas = null;
	static Nave nave = null;
	static Pelota pelota = null;
	private List<Actor> actoresParaEliminar = new ArrayList<Actor>();

	String colores[] = new String[] { "rojo", "verde", "azul", "naranja", "amarillo", "rojo" };

	private static Arkanoid instance = null;

	public static Arkanoid getInstance() {
		if (instance == null) { // Si no está inicializada, se inicializa
			instance = new Arkanoid();
		}
		return instance;
	}

	public Arkanoid() {
		
	

		ventana = new JFrame("Arkanoid");
		ventana.setBounds(0, 0, 555, 800);
		ventana.setLocationRelativeTo(null);

		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla)
		// al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());

		// Creo una lista de actores que intervendrá en el juego.
		actores = creaActores();

		canvas = new MiCanvas(actores);

		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				cerrarAplicacion();
			}
			
			
		});
		
		canvas.addKeyListener(new KeyAdapter() {
			

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				nave.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				nave.keyReleased(e);
			}
			
			
			
		});
		
		canvas.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				nave.mover(e.getX(),680);
			}
			
		});
		// Consigo que la ventana no se redibuje por los eventos de Windows
		ventana.setIgnoreRepaint(true);
		// Hago que la ventana sea visible
		ventana.setVisible(true);

		// Tras mostrar la ventana, consigo que el foco de la ventana vaya al
		// Canvas, para que pueda escuchar los eventos del teclado
		canvas.requestFocus();
	}

	public static void main(String[] args) {
		Arkanoid.getInstance().juego();
		
		

	}
	
	

	public void juego() {
		
		
		int millisPorCadaFrame = 1000 / FPS;
		do {
			
			if (ventana.getFocusOwner() != null && !ventana.getFocusOwner().equals(canvas)) {
				canvas.requestFocus();
			}
			// Redibujo la escena tantas veces por segundo como indique la variable FPS
			// Tomo los millis actuales
			long millisAntesDeProcesarEscena = new Date().getTime();

			// Redibujo la escena
			canvas.pintaEscena();

			// Recorro todos los actores, consiguiendo que cada uno de ellos actúe
			for (Actor a : actores) {
				a.actua();
			}
			
			detectaColisiones();
			actualizaActores();

			// Calculo los millis que debemos parar el proceso, generando 60 FPS.
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesDeProcesarEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0) ? 0 : millisPausa;
			// "Duermo" el proceso principal durante los milllis calculados.
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			
			if (terminarJuego(pelota) == true) {
				JOptionPane.showMessageDialog(null, "El juego ha acabado, has perdido.");
				System.exit(0);
				break;
			}
				
				
		} while (true);

	}

	public static List<Actor> creaActores() {

		List<Actor> actores = new ArrayList<Actor>();

		pelota = new Pelota(250, 400, 10, 10);
		nave = new Nave(230, 680, 50, 15);
		String colores[] = new String[] {"Rojo", "Verde", "Azul", "Naranja", "Plateado", "Dorado"};
		int movimientoAbajo = 0;
		for (int i = 0; i < 6; i++) {
			int movimientoDerecha = 0;
			for (int j = 0; j < 12; j++) {
				
				if (i == 5) {
				Ladrillo ladrillo = new Ladrillo(5 + movimientoDerecha, 10 + movimientoAbajo,36,
						20, colores[0],1);
				actores.add(ladrillo);
				}
				if (i == 4) {
					Ladrillo ladrillo = new Ladrillo(5 + movimientoDerecha, 10 + movimientoAbajo,36,
							20, colores[1],2);
					actores.add(ladrillo);
					}
				if (i == 3) {
					Ladrillo ladrillo = new Ladrillo(5 + movimientoDerecha, 10 + movimientoAbajo,36,
							20, colores[2],1);
					actores.add(ladrillo);
					}
				if (i == 2) {
					Ladrillo ladrillo = new Ladrillo(5 + movimientoDerecha, 10 + movimientoAbajo,36,
							20, colores[3],1);
					actores.add(ladrillo);
					}
				if (i == 1) {
					Ladrillo ladrillo = new Ladrillo(5 + movimientoDerecha, 10 + movimientoAbajo,36,
							20, colores[4],2);
					actores.add(ladrillo);
					}
				if (i == 0) {
					Ladrillo ladrillo = new Ladrillo(5 + movimientoDerecha, 10 + movimientoAbajo,36,
							20, colores[5],3);
					actores.add(ladrillo);
					}
				
				
				movimientoDerecha += 45;
			}
			movimientoAbajo += 30;
		}

		actores.add(nave);
		actores.add(pelota);

		return actores;

	}

	public MiCanvas getCanvas() {
		return canvas;
	}
	
	public void eliminaActor (Actor a) {
		this.actoresParaEliminar.add(a);
	}
	
	
	private void actualizaActores () {
		
		// Elimino los actores que se deben eliminar
		for (Actor a : this.actoresParaEliminar) {
			this.actores.remove(a);
		}
		this.actoresParaEliminar.clear(); // Limpio la lista de actores a eliminar, ya los he eliminado
	}
	
	public static boolean terminarJuego(Actor pelota) {
		
		if (pelota.getY() >= 750) {
			return true;
		}
		
		return false;
	}
	
	private void detectaColisiones() {
		// Una vez que cada actor ha actuado, intento detectar colisiones entre los actores y notificarlas. Para detectar
		// estas colisiones, no nos queda más remedio que intentar detectar la colisión de cualquier actor con cualquier otro
		// sólo con la excepción de no comparar un actor consigo mismo.
		// La detección de colisiones se va a baser en formar un rectángulo con las medidas que ocupa cada actor en pantalla,
		// De esa manera, las colisiones se traducirán en intersecciones entre rectángulos.
		for (Actor actor1 : this.actores) {
			// Creo un rectángulo para este actor.
			Rectangle rect1 = new Rectangle(actor1.getX(), actor1.getY(), actor1.getAncho(), actor1.getLargo());
			// Compruebo un actor con cualquier otro actor
			for (Actor actor2 : this.actores) {
				// Evito comparar un actor consigo mismo, ya que eso siempre provocaría una colisión y no tiene sentido
				if (!actor1.equals(actor2)) {
					// Formo el rectángulo del actor 2
					Rectangle rect2 = new Rectangle(actor2.getX(), actor2.getY(), actor2.getAncho(), actor2.getLargo());
					// Si los dos rectángulos tienen alguna intersección, notifico una colisión en los dos actores
					if (rect1.intersects(rect2)) {
						actor1.colisionaCon(actor2); // El actor 1 colisiona con el actor 2
						actor2.colisionaCon(actor1); // El actor 2 colisiona con el actor 1
					}
				}
			}
		}
	}
	
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
