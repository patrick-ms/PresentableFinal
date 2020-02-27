package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {
	protected int ancho;
	protected int alto;
	
	protected int[] cuadros;
	protected Cuadro[] cuadrosCatalogo;
	
	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		cuadros = new int[ancho * alto];
		generarMapa();
	}
	
	public Mapa(String ruta) {
		cargarMapa(ruta);
		generarMapa();
	}
	
	protected void generarMapa() {
	}
	
	protected void cargarMapa(String ruta) {		
	}
	
	public void actualizar() {
	}
	
	public void mostar(final int compensacionX, final int compensacionY, final Pantalla pantalla) {		
		//Bit shifting
		
		pantalla.setDiferencia(compensacionX, compensacionY);
		
		int oeste = compensacionX >> 5;// /32
		int este = (compensacionX + pantalla.getAncho() + Cuadro.LADO) >> 5;
		int norte = compensacionY >> 5;
		int sur = (compensacionY + pantalla.getAlto() + Cuadro.LADO) >> 5;
		
		for(int y = norte; y < sur; y++) {
			for(int x = oeste; x < este; x++) {
				//getCuadro(x, y).mostrar(x, y, pantalla);	
				if(x < 0 || y < 0 || x >= ancho || y >= alto) {
					Cuadro.VACIO.mostrar(x, y, pantalla);
				} else {
					cuadrosCatalogo[x + y * ancho].mostrar(x, y, pantalla);
				}
			}
		}
	}
	
	public Cuadro getCuadro(final int x, final int y) {
		if(x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Cuadro.VACIO;
		}
		switch(cuadros[x + y * ancho]) {
		case 0:
			return Cuadro.SUELO;
		case 1:
			return Cuadro.PLATAFORMA;
		case 2:
			return Cuadro.PARED;
		case 3:
			return Cuadro.CIELO;	
		default:
				return Cuadro.VACIO;
		}
	}
	
}
