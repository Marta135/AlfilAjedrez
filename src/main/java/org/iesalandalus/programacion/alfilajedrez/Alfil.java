package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

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
	
	/**
	 * Constructor con parámetros (color y columna). 
	 * @param color, BLANCO (posicion fila=1) o NEGRO (posicion fila=8).
	 * @param columna ('c' o 'f').
	 */
	public Alfil(Color color, char columna) throws IllegalArgumentException {
		
		if (color==null)
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		
		if (columna!='c' && columna!='f')
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		
		setColor(color);
		if (color.equals(Color.BLANCO))
			posicion=new Posicion (1,columna);
		else
			posicion=new Posicion(8,columna);
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
	
	
	/********OTROS MÉTODOS********/
	
	/**
	 * Método mover
	 * Método para mover el alfil por el tablero.
	 */
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException  {
		
		if(direccion==null)
			throw new NullPointerException ("ERROR: La dirección no puede ser nula.");
		
		if(pasos<=0)
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
	
			
		int nuevaFila = posicion.getFila();
		char nuevaColumna = posicion.getColumna();
		
				
		switch (direccion) {
			
			case ARRIBA_DERECHA:
				nuevaFila += pasos;
				nuevaColumna += pasos;
				break;
		
			case ARRIBA_IZQUIERDA:
				nuevaFila += pasos;
				nuevaColumna -= pasos;
				break;
		
			case ABAJO_DERECHA:
				nuevaFila -= pasos;
				nuevaColumna += pasos;
				break;
		
			case ABAJO_IZQUIERDA:
				nuevaFila -= pasos;
				nuevaColumna -= pasos;
				break;
		
			default:
				break;	
				
		}
		
		try {
			
			setPosicion(new Posicion(nuevaFila, nuevaColumna));
		} 
		catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
		}

	}

	
	
}

