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
	
		pantalla.setDiferencia(compensacionX, compensacionY);
		
		int oeste = compensacionX >> 5;
		int este = (compensacionX + pantalla.getAncho() + Cuadro.LADO) >> 5;
		int norte = compensacionY >> 5;
		int sur = (compensacionY + pantalla.getAlto() + Cuadro.LADO) >> 5;
		
		for(int y = norte; y < sur; y++) {
			for(int x = oeste; x < este; x++) {
				if(x < 0 || y < 0 || x >= ancho || y >= alto) {
					Cuadro.VACIO.mostrar(x, y, pantalla);
				} else {
					cuadrosCatalogo[x + y * ancho].mostrar(x, y, pantalla);
				}
			} 
		}
	}
	
	public Cuadro getCuadroCatalogo(int posicion) {
		return cuadrosCatalogo[posicion];
	}
	
	public int getAncho() {
		return ancho;
	}
	
}
