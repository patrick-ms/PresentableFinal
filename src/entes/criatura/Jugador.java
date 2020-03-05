package entes.criatura;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Jugador extends Criatura{
	private Teclado teclado;
	
	private int animacion;
	private boolean vivo = true;

	public Jugador(Mapa mapa, Teclado teclado,Sprite sprite) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
	}
	
	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite,int posicionX, int posicionY) {
		this(mapa, teclado, sprite);
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
					} 
				}
			}
		}
			if(direccion == 'e') {
				sprite = Sprite.PARADODERECHA;
				if(enMovimiento) {
					if(animacion % 30 > 15) {
						sprite = Sprite.CORRERDERECHA1;		
					}
				}
			} 
	}
	
	public void mostrar(Pantalla pantalla, Enemigo enemigo, Enemigo enemigo2, Enemigo enemigo3, Enemigo enemigo4, Enemigo enemigo5, Enemigo enemigo6, Enemigo enemigo7) {
		
		if(enemigo.getLimite().intersects(getLimite()) || enemigo2.getLimite().intersects(getLimite())
				|| enemigo3.getLimite().intersects(getLimite())||enemigo5.getLimite().intersects(getLimite()) ||
				enemigo6.getLimite().intersects(getLimite()) || enemigo7.getLimite().intersects(getLimite())) {
			vivo = false;
		}
		if(vivo) {
			pantalla.mostrarJugador(x, y, this);
		}
	}	

}
