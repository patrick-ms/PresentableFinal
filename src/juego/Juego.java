package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import control.Teclado;
import entes.criatura.Enemigo;
import entes.criatura.Jugador;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;
import mapa.MapaCargado;

public class Juego extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private static final int ANCHO = 800;
	private static final int ALTO = 480; 
	private static boolean colisionEnemigo = false;
	private static volatile boolean enFuncionamiento = false;
	
	private static final String NOMBRE = "CowDog";
	
	private static String CONTADOR_APS = "";
	private static String CONTADOR_FPS = "";

	private static int aps = 0;
	private static int fps = 0;
	
	private static int x = 0;
	private static int y = 0;

	private static JFrame ventana;
	private static Thread thread;
	private static Teclado teclado;
	private static Pantalla pantalla;
	
	private static Mapa mapa;
	private static Jugador jugador;
	private static Enemigo enemigo;
	private static Enemigo enemigo2;
	private static Enemigo enemigo3;
	private static Enemigo enemigo4;
	private static Enemigo enemigo5;
	private static Enemigo enemigo6;
	private static Enemigo enemigo7;
	private static Enemigo enemigo8;
	
	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
	
	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		
		pantalla = new Pantalla(ANCHO, ALTO);

		teclado = new Teclado();
		addKeyListener(teclado);
		
		mapa = new MapaCargado("/mapas/mapaColor.png");
		jugador = new Jugador(mapa, teclado, Sprite.PARADODERECHA, 425,288);
		enemigo = new Enemigo(mapa,  Sprite.POLICIAPARADO, 850, 288);
		enemigo2 = new Enemigo(mapa, Sprite.POLICIAPARADO, 250, 380);
		enemigo3 = new Enemigo(mapa,  Sprite.POLICIAPARADO, 500,0);
		enemigo4 = new Enemigo(mapa,  Sprite.POLICIAPARADO, 1530,0);
		enemigo5 = new Enemigo(mapa,  Sprite.POLICIAPARADO, 1570,380);
		enemigo6 = new Enemigo(mapa,  Sprite.POLICIAPARADO, 2800,0);
		enemigo7 = new Enemigo(mapa,  Sprite.POLICIAPARADO, 2000,191);
		enemigo8 = new Enemigo(mapa,  Sprite.POLICIAPARADO, 2600,0);
		
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack(); 
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.iniciar();
		
	}
	
	private synchronized void iniciar() {
		enFuncionamiento = true;
		
		thread = new Thread(this, "Graficos");
		thread.start();
	}
	
	private synchronized void detener() {
		enFuncionamiento = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void actualizar() {
		teclado.actualizar();
		enemigo.moverCostado(2,800,1100);
		enemigo2.moverCostado(2,250 ,402);
		enemigo3.moverArriba(2,0,280);
		enemigo4.moverArriba(2,0,220);
		enemigo5.moverCostado(2,1570 ,1700);
		enemigo6.moverArriba(2,0,380);
		enemigo7.moverCostado(2,2000,2300);
		enemigo8.moverArriba(2,0,190);
		jugador.actualizar();
		
        if(teclado.salir) {
        	System.exit(0);
        }
        
        aps++;
	}
	
	private void mostrar () {
		BufferStrategy estrategia = getBufferStrategy();

		if(estrategia == null) {
			createBufferStrategy(3); 
			return;
		}

		mapa.mostar(jugador.getposicionX() - pantalla.getAncho() / 2 + jugador.getSprite().getLado() / 2, jugador.getposicionY() - pantalla.getAlto() / 2 + jugador.getSprite().getLado() / 2, pantalla);
		
		enemigo.mostrar(pantalla,jugador);
		enemigo2.mostrar(pantalla,jugador);
		enemigo3.mostrar(pantalla,jugador);	
		enemigo4.mostrar(pantalla,jugador);	
		enemigo5.mostrar(pantalla,jugador);	
		enemigo6.mostrar(pantalla,jugador);	
		enemigo7.mostrar(pantalla,jugador);	
		enemigo8.mostrar(pantalla,jugador);
		jugador.mostrar(pantalla,enemigo,enemigo2,enemigo3,enemigo4,enemigo5,enemigo6,enemigo7);
		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);

		Graphics g = estrategia.getDrawGraphics();
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.red);
		g.drawString(CONTADOR_APS, 10, 20);
		g.drawString(CONTADOR_FPS, 10, 35);
		g.drawString("X: " + jugador.getposicionX(), 10, 50);
		g.drawString("Y: " + jugador.getposicionY(), 10, 65);
		g.dispose();
		
		estrategia.show();
		
		fps++;
	}

	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		
		double tiempoTranscurrido;
		double delta = 0;
		
		requestFocus();
		

		while(enFuncionamiento) {
			final long inicioBucle = System.nanoTime();
			
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			
			while(delta >= 1) {
				actualizar();
				delta--;
			}
			
			mostrar();
			
			if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				CONTADOR_APS = "APS: " + aps;
				CONTADOR_FPS = "FPS: " + fps;
				
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}
}
