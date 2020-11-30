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

	
	/********MÉTODOS EQUALS Y HASHCODE********/
	/**
	 * Método hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
	}

	/**
	 * Método equals
	 * Método que compara si dos posiciones son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}
	
	
	

	
}
