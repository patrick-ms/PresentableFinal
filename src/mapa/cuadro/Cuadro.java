package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {
	public int x;
	public int y;
	
	public Sprite sprite;
	
	private boolean solido;
	
	public static final int LADO = 32;
	
	//Coleccion de cuadro
	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO, true);
	public static final Cuadro SUELOABAJOINICIO = new Cuadro(Sprite.SUELOABAJOINICIO, true);
	public static final Cuadro SUELOABAJOMEDIO = new Cuadro(Sprite.SUELOABAJOMEDIO, true);
	public static final Cuadro SUELOABAJOFINAL = new Cuadro(Sprite.SUELOABAJOFINAL, true);
	public static final Cuadro SUELOARRIBAINICIO = new Cuadro(Sprite.SUELOARRIBAINICIO);
	public static final Cuadro SUELOARRIBAMEDIO = new Cuadro(Sprite.SUELOARRIBAMEDIO);
	public static final Cuadro SUELOARRIBAFINAL = new Cuadro(Sprite.SUELOARRIBAFINAL);
	public static final Cuadro LATERALDERECHO = new Cuadro(Sprite.LATERALDERECHO, true);
	public static final Cuadro LATERALIZQUIERDO = new Cuadro(Sprite.LATERALIZQUIERDO, true);
	public static final Cuadro PLANTA3 = new Cuadro(Sprite.PLANTA3);
	public static final Cuadro PLANTA2 = new Cuadro(Sprite.PLANTA2);
	public static final Cuadro FLOR2 = new Cuadro(Sprite.FLOR2);
	public static final Cuadro FLOR3 = new Cuadro(Sprite.FLOR3);
	public static final Cuadro ARBOLSINHOJAINICIO = new Cuadro(Sprite.ARBOLSINHOJAINICIO);
	public static final Cuadro ARBOLSINHOJAMEDIO = new Cuadro(Sprite.ARBOLSINHOJAMEDIO);
	public static final Cuadro ARBOLSINHOJAFINAL = new Cuadro(Sprite.ARBOLSINHOJAFINAL);
	public static final Cuadro ARBOLCONHOJAINICIO = new Cuadro(Sprite.ARBOLCONHOJAINICIO);
	public static final Cuadro ARBOLCONHOJAMEDIO = new Cuadro(Sprite.ARBOLCONHOJAMEDIO);
	public static final Cuadro ARBOLCONHOJAFINAL1 = new Cuadro(Sprite.ARBOLCONHOJAFINAL1);
	public static final Cuadro ARBOLCONHOJAFINAL2 = new Cuadro(Sprite.ARBOLCONHOJAFINAL2);
	public static final Cuadro ARBOLCONHOJAFINAL3 = new Cuadro(Sprite.ARBOLCONHOJAFINAL3);
	public static final Cuadro ARBOLCONHOJAFINALRAMAIZQUIERDA = new Cuadro(Sprite.ARBOLCONHOJAFINALRAMAIZQUIERDA);
	public static final Cuadro ARBOLCONHOJAFINALRAMAMEDIA = new Cuadro(Sprite.ARBOLCONHOJAFINALRAMAMEDIA);
	public static final Cuadro ARBOLCONHOJAFINALRAMADERECHA = new Cuadro(Sprite.ARBOLCONHOJAFINALRAMADERECHA);
	public static final Cuadro ARBOLCONHOJAHOJAMEDIA = new Cuadro(Sprite.ARBOLCONHOJAHOJAMEDIA);
	public static final Cuadro ARBOLCONHOJAHOJAIZQUIERDA = new Cuadro(Sprite.ARBOLCONHOJAHOJAIZQUIERDA);
	public static final Cuadro ARBOLCONHOJAHOJADERECHA = new Cuadro(Sprite.ARBOLCONHOJAHOJADERECHA);
	public static final Cuadro ARBOLCONHOJAFINALIZQUIERDA = new Cuadro(Sprite.ARBOLCONHOJAFINALIZQUIERDA);
	public static final Cuadro ARBOLCONHOJAFINALMEDIO = new Cuadro(Sprite.ARBOLCONHOJAFINALMEDIO);
	public static final Cuadro ARBOLCONHOJAFINALDERECHA = new Cuadro(Sprite.ARBOLCONHOJAFINALDERECHA);
	public static final Cuadro CIELO1 = new Cuadro(Sprite.CIELO1);
	public static final Cuadro CIELO2 = new Cuadro(Sprite.CIELO2);
	public static final Cuadro CIELO3 = new Cuadro(Sprite.CIELO3);
	public static final Cuadro MEDIO1 = new Cuadro(Sprite.MEDIO1, true);
	public static final Cuadro MEDIO2 = new Cuadro(Sprite.MEDIO2, true);
	public static final Cuadro MEDIO3 = new Cuadro(Sprite.MEDIO3, true);
	public static final Cuadro MEDIO4 = new Cuadro(Sprite.MEDIO4, true);
	public static final Cuadro CIELO = new Cuadro(Sprite.CIELO);
	public static final Cuadro PIEDRA = new Cuadro(Sprite.PIEDRA);
	public static final Cuadro FUEGO = new Cuadro(Sprite.FUEGO);
	//Fin de la coleccion de cuadros
	
	public Cuadro(Sprite sprite) {
		this.sprite = sprite;
		solido = false;
	}

	public Cuadro(Sprite sprite, boolean solido) {
		this.sprite = sprite;
		this.solido = solido;
	}
	
	public void mostrar(int x, int y, Pantalla pantalla) {	
		pantalla.mostrarCuadro(x << 5, y << 5, this);
	}	
	
	public boolean esSolido() {
		return solido;
	}
	
}
