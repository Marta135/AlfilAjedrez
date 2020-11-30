package org.iesalandalus.programacion.alfilajedrez;

public class MainApp {

	/*******ATRIBUTOS******/
	private static Alfil alfil;
	
	
	/**********MÉTODOS********/
	
	/**
	 * Método mostrarAlfil
	 * Método que imprime por consola la representación del Alfil
	 */
	private static void mostrarAlfil() {
		
		System.out.println(alfil);
	}
	
	/**
	 * Método mostrarMenu
	 * Método que imprime por consola el menú con las distintas opciones
	 */
	private static void mostrarMenu() {
		
		System.out.println("");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("PROGRAMA QUE CONTROLA EL MOVIMIENTO DEL ALFIL EN EL TABLERO DE AJEDREZ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("");
		System.out.println("1.- Crear un alfil por defecto. ");
		System.out.println("2.- Crear un alfil de un color. ");
		System.out.println("3.- Crear un alfil de un color en una columna inicial dada. ");
		System.out.println("4.- Mover el alfil. ");
		System.out.println("");
		System.out.println("0.- Salir. ");
		System.out.println("");
		
	}
	
}
