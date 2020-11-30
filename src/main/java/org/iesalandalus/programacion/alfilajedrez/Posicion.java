package org.iesalandalus.programacion.alfilajedrez;

public class Posicion {

	/*********ATRIBUTOS*********/
	private int fila;
	private char columna;
	
	
	/*******CONSTRUCTORES*******/
	
	/**
	 * Constructor que inicializa los atributos a través de parámetros
	 */
	public Posicion (int fila, char columna) {
		
		setFila(fila);
		setColumna(columna);
	}
	
	/**
	 * Constructor copia
	 */
	public Posicion (Posicion p) {
		
		if(p==null)
			throw new NullPointerException ("ERROR: No es posible copiar una posición nula.");
		
		setFila(p.getFila());
		setColumna(p.getColumna());
	}
	
	
	/*********GETTERS Y SETTERS**********/
	private void setFila(int fila) {
		
		if (fila<1 || fila>8)
			throw new IllegalArgumentException ("ERROR: Fila no válida.");
		
		this.fila = fila;
	}
	
	public int getFila() {
		return fila;
	}
	
	private void setColumna(char columna) {
		
		if (columna<'a' || columna>'h') 
			throw new IllegalArgumentException ("ERROR: Columna no válida.");

		this.columna = columna;
	}
	
	public char getColumna() {
		return columna;
	}

	
}
