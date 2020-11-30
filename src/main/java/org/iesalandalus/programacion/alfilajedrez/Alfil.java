package org.iesalandalus.programacion.alfilajedrez;

public class Alfil {

	/*********ATRIBUTOS*********/
	private Color color;
	private Posicion posicion;
	
	
	/*******CONSTRUCTORES*******/
	
	/**
	 * Constructor por defecto, que inicializa los atributos a unos valores 
     * por defecto establecidos por nosotros
	 */
	public Alfil() throws IllegalArgumentException {
		
		color=Color.NEGRO;
		posicion=new Posicion(8,'f');
	}
	
	/**
	 * Constructor con el parámetro color.
	 * @param color: si es BLANCO (posicion=1,f) si es NEGRO (posicion=8,f).
	 */
	public Alfil(Color color) throws IllegalArgumentException {
		
		if (color==null)
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		
		setColor(color);
		if (color.equals(Color.BLANCO))
			posicion=new Posicion(1,'f');
		else
			posicion=new Posicion(8,'f');
	}
	
	
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

