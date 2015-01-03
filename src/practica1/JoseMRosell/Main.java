package practica1.JoseMRosell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal que ejecuta el algoritmo genetico.
 * @author Jose Manuel Rosell Sanchez
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> distancias = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> pesos = new ArrayList<ArrayList<Integer>>();
		int cantidad = 0;
		
		try {
			Scanner sc = new Scanner(new File("chr12a.dat"));
			if (sc.hasNextInt()) {
				cantidad = sc.nextInt();
			}
			for (int i = 0; i < cantidad; i++) {
				distancias.add(new ArrayList<Integer>());
				for (int j = 0; j < cantidad; j++) {
					distancias.get(i).add(sc.nextInt());
				}
			}
			for (int i = 0; i < cantidad; i++) {
				pesos.add(new ArrayList<Integer>());
				for (int j = 0; j < cantidad; j++) {
					pesos.get(i).add(sc.nextInt());
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int tam_poblacion = 10;
		int num_poblaciones = 10;
		int tipo = 1;
		
		try{
			Scanner in = new Scanner ( System.in );
			
			System.out.print("Introduzca el tamaño de la poblacion: ");
			tam_poblacion = in.nextInt();
			//el tamaño de la poblacion tiene que ser par para que el operador de cruce funcione bien
			while(tam_poblacion%2!=0){
				System.out.print("El tamaño de la población debe ser par. Introduzca el tamaño de la población: ");
				tam_poblacion = in.nextInt();
			}
			System.out.print("Introduzca el número de iteraciones: ");
			num_poblaciones = in.nextInt();
			System.out.print("Tipos de ejecución: \n");
			System.out.print("\t 1 - Estandar \n");
			System.out.print("\t 2 - Baldwiniana \n");
			System.out.print("\t 3 - Lamarckiana \n");
			System.out.print("Elija el tipo de ejecución (1, 2, 3): ");
			tipo = in.nextInt();
			while (tipo!=1 && tipo!=2 && tipo!=3){
				System.out.print("Tipo de ejecución incorrecta. Elija el tipo de ejecución (1, 2, 3): ");
				tipo = in.nextInt();
			}
			in.close();
		}catch (InputMismatchException e){
			System.out.println("El dato introducido debe ser entero...");
		}

		ArrayList<Individuos> poblacion = new ArrayList<Individuos>();
		
		/*
		 * Genero una poblacion inicial aleatoria
		 */
		for(int i=0; i<tam_poblacion; i++){
			Individuos ind = new Individuos(cantidad);
			switch (tipo) {
			case 1: //Estandar
				Fitness.fitnessCromosoma(ind, distancias, pesos);
				break;
			case 2: //Baldwiniana
				Fitness.fitnessGreedy(ind, distancias, pesos);
				break;
			case 3: //Lamarckiana
				Fitness.fitnessGreedyModifica(ind, distancias, pesos);
				break;
			default:
				break;
			}
			
			poblacion.add(ind);
		}
		 
		for(int j=0; j<num_poblaciones; j++){
			/*
			 * Metodo de seleccion
			 */
			poblacion = Seleccion.porTorneo(poblacion);
			
			/*
			 * Operador de cruce
			 */
			switch (tipo) {
			case 1: //Estandar
				poblacion = Cruce.cruzarEstandar(poblacion, distancias, pesos, cantidad);
				break;
			case 2: //Baldwiniana
				poblacion = Cruce.cruzarBaldwin(poblacion, distancias, pesos, cantidad);
				break;
			case 3: //Lamarckiana
				poblacion = Cruce.cruzarLamarck(poblacion, distancias, pesos, cantidad);
				break;
			default:
				break;
			}

			/*
			 * Operador de mutacion
			 */
			poblacion = Mutacion.mutarPoblacion(poblacion, distancias, pesos, cantidad);
		}
		
		Imprimir.mejorSolucion(poblacion);
	}
}
