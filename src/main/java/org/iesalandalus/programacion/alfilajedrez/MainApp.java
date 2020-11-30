package org.iesalandalus.programacion.alfilajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

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
	
	/**
	 * Método elegirOpcion
	 * Método que nos pedirá que escojamos una de las opciones del menú
	 */
	private static int elegirOpcion() {
		
		int opcion;
		
		do {
			System.out.println("Elige una opción (0-4): ");
			opcion=Entrada.entero();
		} while (opcion<0 || opcion>4);
		
		return opcion;
		
	}
	
	/**
	 * Método elegirColor
	 * Método que nos pide que escojamos un color para el alfil
	 */
	private static Color elegirColor() {
		
		int colorAlfil;
		Color color=Color.BLANCO;
		
		do {
			System.out.println("");
			System.out.println("Escoge el color del alfil: ");
			System.out.println("0.- Color Blanco");
			System.out.println("1.- Color Negro");
			System.out.println("");
			colorAlfil=Entrada.entero();
		} while (colorAlfil!=0 && colorAlfil!=1);
		
		switch (colorAlfil) {
			case 0:
				color=Color.BLANCO;
				break;
			case 1:
				color=Color.NEGRO;
				break;
			default:
				break;
		}
		
		return color;
	}
	
	/**
	 * Método elegirColumnaInicial
	 * Método que pide al usuario que escoja una columna inicial para el alfil
	 */
	private static char elegirColumnaInicial() {
		
		int columnaInicial;
		char columna='f';
		
		do {
			System.out.println("");
			System.out.println("Escoge la columna inicial del alfil: ");
			System.out.println("0.- 'c'");
			System.out.println("1.- 'f'");
			System.out.println("");
			columnaInicial=Entrada.entero();
		} while (columnaInicial!=0 && columnaInicial!=1);
		
		switch (columnaInicial) {
		case 0:
			columna='c';
			break;
		case 1:
			columna='f';
			break;
		default:
			break;
		}
	
		return columna;
	}
	
	
}
