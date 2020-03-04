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
			case 0xffb8f3bb: 
				cuadrosCatalogo[i] = Cuadro.SUELOABAJOINICIO;
				continue;
			
			case 0xff7af080:
				cuadrosCatalogo[i] = Cuadro.SUELOABAJOMEDIO;
				continue;
			
			case 0xff38ec42: 
				cuadrosCatalogo[i] = Cuadro.SUELOABAJOFINAL;
				continue;	
			
			case 0xff02fc0f: 
				cuadrosCatalogo[i] = Cuadro.SUELOARRIBAINICIO;
				continue;	
				
			case 0xff9cb69e: 
				cuadrosCatalogo[i] = Cuadro.SUELOARRIBAMEDIO;
				continue;
				
			case 0xff79b67c: 
				cuadrosCatalogo[i] = Cuadro.SUELOARRIBAFINAL;
				continue;
				
			case 0xff4cb251: 
				cuadrosCatalogo[i] = Cuadro.LATERALDERECHO;
				continue;
				
			case 0xff1ca823: 
				cuadrosCatalogo[i] = Cuadro.LATERALIZQUIERDO;
				continue;
				
			case 0xff556a56: 
				cuadrosCatalogo[i] = Cuadro.PLANTA3;
				continue;
				
			case 0xff406742: 
				cuadrosCatalogo[i] = Cuadro.PLANTA2;
				continue;
				
			case 0xffc9f1f2: 
				cuadrosCatalogo[i] = Cuadro.FLOR2;
				continue;
				
			case 0xff7bebef: 
				cuadrosCatalogo[i] = Cuadro.FLOR3;
				continue;
				
			case 0xff02f2fb: 
				cuadrosCatalogo[i] = Cuadro.ARBOLSINHOJAINICIO;
				continue;
				
			case 0xff639c9e: 
				cuadrosCatalogo[i] = Cuadro.ARBOLSINHOJAMEDIO;
				continue;
				
			case 0xff3e9295: 
				cuadrosCatalogo[i] = Cuadro.ARBOLSINHOJAFINAL;
				continue;
				
			case 0xff12878b: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAINICIO;
				continue;
				
			case 0xff192d2e: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAMEDIO;
				continue;
				
			case 0xff13393a: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINAL1;
				continue;
				
			case 0xff054345: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINAL2;
				continue;
				
			case 0xfff1aaaa: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINAL3;
				continue;
				
			case 0xfff06060: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINALRAMAIZQUIERDA;
				continue;
				
			case 0xffee1818: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINALRAMAMEDIA;
				continue;
				
			case 0xfff1a0f0: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINALRAMADERECHA;
				continue;
				
			case 0xfff063ee: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAHOJAIZQUIERDA;
				continue;
				
			case 0xfffb03f8: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAHOJAMEDIA;
				continue;
				
			case 0xff825081: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAHOJADERECHA;
				continue;
				
			case 0xff823081: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINALIZQUIERDA;
				continue;
				
			case 0xff7a0478: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINALMEDIO;
				continue;
				
			case 0xff503d50: 
				cuadrosCatalogo[i] = Cuadro.ARBOLCONHOJAFINALDERECHA;
				continue;
				
			case 0xff461d45: 
				cuadrosCatalogo[i] = Cuadro.CIELO1;
				continue;
				
			case 0xffdfe281: 
				cuadrosCatalogo[i] = Cuadro.CIELO2;
				continue;
				
			case 0xffdde427: 
				cuadrosCatalogo[i] = Cuadro.CIELO3;
				continue;
				
			case 0xff5b5b39: 
				cuadrosCatalogo[i] = Cuadro.MEDIO1;
				continue;
				
			case 0xff575813: 
				cuadrosCatalogo[i] = Cuadro.MEDIO2;
				continue;
				
			case 0xff333403: 
				cuadrosCatalogo[i] = Cuadro.MEDIO3;
				continue;
				
			case 0xff3218a3: 
				cuadrosCatalogo[i] = Cuadro.MEDIO4;
				continue;
			
			default:
				cuadrosCatalogo[i] = Cuadro.VACIO;
			}
		}
	}
}
