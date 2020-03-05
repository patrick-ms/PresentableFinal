package entes.criatura;

import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;


public class Enemigo extends Criatura{
	
	private int animacion;
	private boolean solid = true;
	
	private boolean derecha =false;
	private boolean abajo =false;
	
	public Enemigo(Mapa mapa, Sprite sprite) {
		this.mapa = mapa;
		this.sprite = sprite;
	}
	
	public Enemigo(Mapa mapa,  Sprite sprite,int posicionX, int posicionY) {
		this(mapa,  sprite);
		this.x = posicionX;
		this.y = posicionY;
	}
	
	public void mostrar(Pantalla pantalla,Jugador jugador) {
		pantalla.mostrarEnemigo(x, y, this);
	}
	
	public void actualizarIA(int i, Jugador jugador) {
		if(jugador.direccion == 'n') this.modificarPosicionX(-i);
			
		if(jugador.direccion == 'w') this.modificarPosicionX(i);
	}
	
	public void moverArriba(int i, int limiteSup, int limiteInf) {
		if(this.getposicionY() == limiteSup) {
			abajo = true;
		}
		if(this.getposicionY() == limiteInf) {
			abajo = false;
		}
		if(abajo) {
			this.modificarPosicionY(i);
		} else {
			this.modificarPosicionY(-i);
		}
	
	}
	
	public void moverCostado(int i, int limiteIzq, int limiteDerecha) {
		if(this.getposicionX() == limiteIzq) {
			derecha = true;
		}
		if(this.getposicionX() == limiteDerecha) {
			derecha = false;
		}
		if(derecha) {
			this.modificarPosicionX(i);
		} else {
			this.modificarPosicionX(-i);
		}
	}
	
	public boolean esSolid() {
		return solid;
	}
}
