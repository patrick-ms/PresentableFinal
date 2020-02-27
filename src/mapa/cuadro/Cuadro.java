package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {
	public int x;
	public int y;
	
	public Sprite sprite;
	
	public static final int LADO = 32;
	
	//Coleccion de cuadro
	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
	public static final Cuadro SUELO = new Cuadro(Sprite.SUELO);
	public static final Cuadro PLATAFORMA = new Cuadro(Sprite.PLATAFORMA);
	public static final Cuadro PARED = new Cuadro(Sprite.PARED);
	public static final Cuadro CIELO = new Cuadro(Sprite.CIELO);
	//Fin de la coleccion de cuadros
	
	public Cuadro(Sprite sprite) {
		this.sprite = sprite;
	}

	public void mostrar(int x, int y, Pantalla pantalla) {	
		pantalla.mostrarCuadro(x << 5, y << 5, this);
	}	
	
	public boolean solido() {
		return false;
	}
	
}
