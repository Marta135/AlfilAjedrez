package org.iesalandalus.programacion.alfilajedrez;

public class Alfil {

	/*********ATRIBUTOS*********/
	private Color color;
	private Posicion posicion;
	
	
	/*********GETTERS Y SETTERS**********/
	
	private void setPosicion(Posicion posicion) {
		
		if (posicion==null)
			throw new NullPointerException ("ERROR: La posición pasada como parámetro es null.");
		else
			this.posicion = new Posicion(posicion);
	}
	
	public Posicion getPosicion() {
		return new Posicion(posicion);
	}
	
	private void setColor(Color color) {
		
		if (color==null)
			throw new NullPointerException ("ERROR: El color pasado como parámetro es null.");
		else
			this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
}

