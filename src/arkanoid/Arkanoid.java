package arkanoid;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import utils.Utils;

public class Arkanoid {

	private static int FPS = 60;
	private JFrame ventana = null;
	private List<Actor> actores = new ArrayList<Actor>();
	private MiCanvas canvas = null;
	static Nave nave = null;

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

		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla)
		// al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());

		// Creo una lista de actores que intervendrá en el juego.
		actores = creaActores();

		canvas = new MiCanvas(actores);

		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		
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
		
		canvas.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				nave.mover(e.getX());
				System.out.println(e.getX());
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
			// Redibujo la escena tantas veces por segundo como indique la variable FPS
			// Tomo los millis actuales
			long millisAntesDeProcesarEscena = new Date().getTime();

			// Redibujo la escena
			canvas.repaint();

			// Recorro todos los actores, consiguiendo que cada uno de ellos actúe
			for (Actor a : actores) {
				a.actua();
			}

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
		} while (true);

	}

	public static List<Actor> creaActores() {

		List<Actor> actores = new ArrayList<Actor>();

		Pelota pelota = new Pelota(250, 700, 10, 10);
		nave = new Nave(230, 730, 50, 15);
		int movimientoAbajo = 0;
		for (int i = 0; i < 6; i++) {
			int movimientoDerecha = 0;
			for (int j = 0; j < 12; j++) {
				Ladrillo ladrillo = new Ladrillo(5 + movimientoDerecha, 10 + movimientoAbajo, 36, 20);
				actores.add(ladrillo);
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

}
