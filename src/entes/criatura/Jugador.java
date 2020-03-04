package entes.criatura;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;

public class Jugador extends Criatura{
	private Teclado teclado;
	
	private int animacion;
	
	public Jugador(Teclado teclado,Sprite sprite) {
		this.teclado = teclado;
		this.sprite = sprite;
	}
	public Jugador(Teclado teclado, Sprite sprite,int posicionX, int posicionY) {
		this.teclado = teclado;
		this.sprite = sprite;
		this.x = posicionX;
		this.y = posicionY;
	}
	
	public void actualizar() {
		int desplazamientoX = 0;
		int desplazamientoY = 0;
		
		if(animacion < Integer.MAX_VALUE) {
			animacion++;
		} else {
			animacion = 0;
		}			
		
		if(teclado.arriba) {
			desplazamientoY--;
		}	
		if(teclado.abajo) {
			desplazamientoY++;
		}
		if(teclado.izquierda) {
			desplazamientoX--;;
		}
		if(teclado.derecha) {
			desplazamientoX++;
		}
		
		if(desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		} else {
			enMovimiento = false;
		}
		
		if(direccion !=0 || desplazamientoY != 0) {
			if(direccion == 'n') {
				
			}
			if(direccion == 's') {
			
			}
			if(direccion == 'w') {
				sprite = Sprite.PARADOPIZQUIERDA;
				if(enMovimiento) {
					if(animacion % 30 > 15) {
						sprite = Sprite.CORRERIZQUIERDA1;
					} else {
						sprite = Sprite.CORRERIZQUIERDA2;
					}
				}
			}
			if(direccion == 'e') {
				sprite = Sprite.PARADODERECHA;
				if(enMovimiento) {
					if(animacion % 30 > 15) {
						sprite = Sprite.CORRERDERECHA1;
					} else {
						sprite = Sprite.CORRERDERECHA2;
					}
				}
			}
		} 
	}
	
	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}
	
}
