package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	/*******ATRIBUTOS******/
	private static Alfil alfil;
	
	
	/**
	 * Método void main(String[])
	 * Método principal de nuestra aplicación.
	 */
	public static void main(String[] args) {
		
		int opcion;
		
		do {
			mostrarMenu();
			
			opcion = elegirOpcion();
			
			ejecutarOpcion(opcion);
			
		}while (opcion!=0);
		
		System.out.println("¡Hasta pronto!");
	}
	
	
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
	 * Método ejecutarOpcion
	 * Dependiendo de la opción pasada como parámetro, actuará en consecuencia y
	 * mostrará el estado del alfil.
	 */
	private static void ejecutarOpcion(int opcion) {
		
		switch (opcion) {
		
			case 1:
				crearAlfilDefecto(); 
				mostrarAlfil();      
				break;
			case 2:
				crearAlfilColor(); 
				mostrarAlfil();
				break;
			case 3:
				crearAlfilColorColumna(); 
				mostrarAlfil();
				break;
			case 4:
				mover(); 
				mostrarAlfil();
				break;
			default:
				break;
		}
	}
	
	/**
	 * Método crearAlfilDefecto
	 * Asigna al atributo alfil una nueva instancia de un alfil creado con el 
	 * constructor por defecto.
	 */
	private static void crearAlfilDefecto() {
		try {
			alfil=new Alfil();
			System.out.println("----------------------------");
			System.out.println("Alfil creado correctamente.");
			System.out.println("----------------------------");
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Método crearAlfilColor
	 * Asigna al atributo de clase alfil una nueva instancia de un alfil creado con 
	 * el constructor al que le pasamos el color.
	 */
	private static void crearAlfilColor() {
		
		try {
			alfil=new Alfil(elegirColor());
			System.out.println("----------------------------");
			System.out.println("Alfil creado correctamente.");
			System.out.println("----------------------------");
		}
		catch (NullPointerException | IllegalArgumentException e) {
			System.out.println("ERROR: El alfil no ha sido creado.");
			System.out.println(e.getMessage());  
		}
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
	 * Método crearAlfilColorColumna
	 * Asigna al atributo de clase alfil una nueva instancia de un alfil creado con 
	 * el constructor al que le pasamos el color y la columna inicial. 
	 */
	private static void crearAlfilColorColumna() {
		try {
			alfil=new Alfil(elegirColor(), elegirColumnaInicial());
			System.out.println("----------------------------");
			System.out.println("Alfil creado correctamente.");
			System.out.println("----------------------------");
		}
		catch (NullPointerException | IllegalArgumentException e) {
			System.out.println("ERROR: El alfil no ha sido creado.");
			System.out.println(e.getMessage());  
		}
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
	
	/**
	 * Método mover
	 * Mostrará el menú con las posibles direcciones, nos preguntará por la dirección 
	 * y la cantidad de pasos a mover y moverá el alfil.
	 */
	private static void mover() {
			
			mostrarMenuDirecciones();
			Direccion direccion=elegirDireccion();
			System.out.println("Introduce el número de pasos a dar: ");
			int pasos=Entrada.entero();
			
		try {
			alfil.mover(direccion, pasos);
			System.out.println("----------------------------------");
			System.out.println("Movimiento realizado correctamente");
			System.out.println("----------------------------------");
		} 
		catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("ERROR: El alfil no ha sido creado. ");
		}
	}
	
	/**
	 * Método mostrarMenuDirecciones
	 * Método que mostrará por consola las distintas direcciones que podemos elegir.
	 */
	private static void mostrarMenuDirecciones() {
		
		System.out.println("");
		System.out.println("Direcciones del alfil: ");
		System.out.println("------------------------");
		System.out.println("1.- ARRIBA_DERECHA");
		System.out.println("2.- ABAJO_DERECHA");
		System.out.println("3.- ABAJO_IZQUIERDA");
		System.out.println("4.- ARRIBA_IZQUIERDA");
		System.out.println("");	
	}
	
	/**
	 * Método elegirDireccion
	 * Método que permite elegir la dirección del menú de direcciones.
	 */
	private static Direccion elegirDireccion() {
		
		int direccionAlfil;
		Direccion direccion=Direccion.ARRIBA_DERECHA;
		
		do {
			System.out.println("Escoge la dirección del alfil (1-4): ");
			direccionAlfil=Entrada.entero();
		} while (direccionAlfil<1 || direccionAlfil>4);
		
		switch (direccionAlfil) {
			case 1:
				direccion=Direccion.ARRIBA_DERECHA;
				break;
			case 2:
				direccion=Direccion.ABAJO_DERECHA;
				break;
			case 3:
				direccion=Direccion.ABAJO_IZQUIERDA;
				break;
			case 4:
				direccion=Direccion.ARRIBA_IZQUIERDA;
				break;
			default:
				break;
		}
		
		return direccion;
	}
	
	
}
