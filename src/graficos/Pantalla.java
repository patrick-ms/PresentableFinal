package graficos;

import entes.criatura.Jugador;
import mapa.cuadro.Cuadro;

public final class Pantalla {
	
	private final int ancho;
	private final int alto;
	
	private int diferenciaX;
	private int diferenciaY;
	
	public final int[] pixeles;

	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		pixeles = new int[ancho * alto];
	}
	
	public void limpiar() {
		for(int i=0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}

	public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;
		
		for(int y = 0; y < cuadro.sprite.getLado(); y++) {
			int posicionY = y + compensacionY;
			for(int x = 0; x < cuadro.sprite.getLado(); x++) {
				int posicionX = x + compensacionX;

				if(posicionX < -cuadro.sprite.getLado() || posicionX >= ancho || posicionY < 0|| posicionY >= alto) {
					break;
				}
				if(posicionX < 0) {
					posicionX = 0;
				}
				
				int colorPixelCuadro = cuadro.sprite.pixeles[x + y * cuadro.sprite.getLado()];

				if(colorPixelCuadro != 0xffffffff) {
					pixeles[posicionX + posicionY * ancho] = colorPixelCuadro;
				} else {
					pixeles[posicionX + posicionY * ancho] = 0xff000000;
				}
			}
		}
	}
	
	public void mostrarJugador(int compensacionX, int compensacionY, Jugador jugador) {
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;
		
		for(int y = 0; y < jugador.getSprite().getLado(); y++) {
			int posicionY = y + compensacionY;
			for(int x = 0; x < jugador.getSprite().getLado(); x++) {
				int posicionX = x + compensacionX;
	
				if(posicionX < -jugador.getSprite().getLado() || posicionX >= ancho || posicionY < 0|| posicionY >= alto) {
					break;
				}
				if(posicionX < 0) {
					posicionX = 0;
				}
				
				int colorPixelJugador = jugador.getSprite().pixeles[x + y * jugador.getSprite().getLado()];
				if(colorPixelJugador != 0xffff00ff) {
					pixeles[posicionX + posicionY * ancho] = colorPixelJugador;
				}
			}
		}
	}
	
	public void setDiferencia(final int diferenciaX, final int diferenciaY) {
		this.diferenciaX = diferenciaX;
		this.diferenciaY = diferenciaY;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
}
