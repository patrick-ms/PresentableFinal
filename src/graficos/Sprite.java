package graficos;

public final class Sprite {
	private final int lado;
	
	private int x;
	private int y;
	
	public int[] pixeles;
	private HojaSprites hoja;
	
	//Coleccion de sprites del personaje
	public static final Sprite PARADO = new Sprite(32, 0, 0, HojaSprites.jugador);
	public static final Sprite CORRERDERECHA1 = new Sprite(32, 1, 0, HojaSprites.jugador);
	public static final Sprite CORRERDERECHA2 = new Sprite(32, 2, 0, HojaSprites.jugador);	
	//Fin de la coleccion
	
	//Coleccion de sprites del mapa
	public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite SUELO = new Sprite(32, 0, 0, HojaSprites.mapa01);
	public static final Sprite PLATAFORMA =new Sprite(32, 1, 0, HojaSprites.mapa01);
	public static final Sprite PARED =new Sprite(32, 2, 0, HojaSprites.mapa01);
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
		
		for(int i=0; i < pixeles.length; i++) {
			pixeles[i] = color;
		}
	}
	
	public int getLado() {
		return lado;
	}
	
}
