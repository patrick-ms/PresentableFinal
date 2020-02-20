package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa{
	
	private int[] pixeles;
	
	public MapaCargado(String ruta) {
		super(ruta);
	}
	
	protected void cargarMapa(String ruta) {
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
			//no se puede tener 1 mapa generado y cargado o 2 del mismo tipo
			ancho = imagen.getWidth();
			alto = imagen.getHeight();
			
			cuadrosCatalogo = new Cuadro[ancho * alto];
			pixeles = new int[ancho * alto];
			
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void generarMapa() {
		for(int i = 0; i < pixeles.length; i++) {
			switch(pixeles[i]) {
			//añadir 0xff al principio
			case 0xff694500: 
				cuadrosCatalogo[i] = Cuadro.SUELO;
				continue;
			
			case 0xff9ca14a:
				cuadrosCatalogo[i] = Cuadro.PLATAFORMA;
				continue;
			
			case 0xffdd986f: 
				cuadrosCatalogo[i] = Cuadro.PARED;
				continue;	
				
			default:
				cuadrosCatalogo[i] = Cuadro.VACIO;
			}
		}
	}
}
