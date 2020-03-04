package graficos;

public final class Sprite {
	private final int lado;
	
	private int x;
	private int y;
	
	public int[] pixeles;
	private HojaSprites hoja;
	
	//Coleccion de sprites del personaje
	public static final Sprite PARADODERECHA = new Sprite(32, 0, 0, HojaSprites.jugador);
	public static final Sprite CORRERDERECHA1 = new Sprite(32, 1, 0, HojaSprites.jugador);
	public static final Sprite CORRERDERECHA2 = new Sprite(32, 2, 0, HojaSprites.jugador);	
	public static final Sprite PARADOPIZQUIERDA = new Sprite(32, 3, 0, HojaSprites.jugador);
	public static final Sprite CORRERIZQUIERDA1 = new Sprite(32, 4, 0, HojaSprites.jugador);
	public static final Sprite CORRERIZQUIERDA2 = new Sprite(32, 5, 0, HojaSprites.jugador);
	//Fin de la coleccion
	
	//Coleccion de sprites del mapa
	public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite SUELOABAJOINICIO = new Sprite(32, 0, 0, HojaSprites.mapa01);
	public static final Sprite SUELOABAJOMEDIO = new Sprite(32, 1, 0, HojaSprites.mapa01);
	public static final Sprite SUELOABAJOFINAL = new Sprite(32, 2, 0, HojaSprites.mapa01);
	public static final Sprite SUELOARRIBAINICIO = new Sprite(32, 3, 0, HojaSprites.mapa01);
	public static final Sprite SUELOARRIBAMEDIO = new Sprite(32, 4, 0, HojaSprites.mapa01);
	public static final Sprite SUELOARRIBAFINAL = new Sprite(32, 5, 0, HojaSprites.mapa01);
	public static final Sprite LATERALDERECHO = new Sprite(32, 6, 0, HojaSprites.mapa01);
	public static final Sprite LATERALIZQUIERDO = new Sprite(32, 7, 0, HojaSprites.mapa01);
	public static final Sprite PLANTA3 = new Sprite(32, 8, 0, HojaSprites.mapa01);
	public static final Sprite PLANTA2 = new Sprite(32, 9, 0, HojaSprites.mapa01);
	public static final Sprite FLOR2 = new Sprite(32, 0, 1, HojaSprites.mapa01);
	public static final Sprite FLOR3 = new Sprite(32, 1, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLSINHOJAINICIO = new Sprite(32, 2, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLSINHOJAMEDIO = new Sprite(32, 3, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLSINHOJAFINAL = new Sprite(32, 4, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAINICIO = new Sprite(32, 5, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAMEDIO = new Sprite(32, 6, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINAL1 = new Sprite(32, 7, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINAL2 = new Sprite(32, 8, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINAL3 = new Sprite(32, 9, 1, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINALRAMAIZQUIERDA = new Sprite(32, 0, 2, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINALRAMAMEDIA = new Sprite(32, 1, 2, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINALRAMADERECHA = new Sprite(32, 2, 2, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAHOJAIZQUIERDA = new Sprite(32, 3, 2, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAHOJAMEDIA = new Sprite(32, 4, 2, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAHOJADERECHA = new Sprite(32, 5, 2, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINALIZQUIERDA = new Sprite(32, 6, 2, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINALMEDIO = new Sprite(32, 7, 2, HojaSprites.mapa01);
	public static final Sprite ARBOLCONHOJAFINALDERECHA = new Sprite(32, 8, 2, HojaSprites.mapa01);
	public static final Sprite CIELO1 = new Sprite(32, 9, 2, HojaSprites.mapa01);
	public static final Sprite CIELO2 = new Sprite(32, 0, 3, HojaSprites.mapa01);
	public static final Sprite CIELO3 = new Sprite(32, 1, 3, HojaSprites.mapa01);
	public static final Sprite MEDIO1 = new Sprite(32, 2, 3, HojaSprites.mapa01);
	public static final Sprite MEDIO2 = new Sprite(32, 3, 3, HojaSprites.mapa01);
	public static final Sprite MEDIO3 = new Sprite(32, 4, 3, HojaSprites.mapa01);
	public static final Sprite MEDIO4 = new Sprite(32, 5, 3, HojaSprites.mapa01);
	//Fin de la coleccion
	
	//Coleccion de sprites del enemigo
	
	//Fin de la coleccion
	
	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.lado = lado;
		
		pixeles = new int[lado * lado];
		
		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;
		
		for(int y = 0; y < lado; y++) {
			for(int x = 0; x <lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
	}
	
	public Sprite(final int lado, final int color) {
		this.lado = lado;
		pixeles = new int[lado * lado];
		
		for(int i = 0; i < pixeles.length; i++) {
			pixeles[i] = color;
		}
	}
	
	public int getLado() {
		return lado;
	}
	
}
