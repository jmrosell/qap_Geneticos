package practica1.JoseMRosell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> distancias = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> pesos = new ArrayList<ArrayList<Integer>>();
		int cantidad = 0;
		
		try {
			Scanner sc = new Scanner(new File("tai256c.dat"));
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
		
		//el tamaño de la poblacion tiene que ser par para que el operador de cruce funcione bien
		int tam_poblacion = 10;
		int num_poblaciones = 10;
		ArrayList<Individuos> poblacion = new ArrayList<Individuos>();
		
		/*
		 * Genero una poblacion inicial aleatoria
		 */
		for(int i=0; i<tam_poblacion; i++){
			Individuos ind = new Individuos(cantidad);
			Fitness.fitnessCromosoma(ind, distancias, pesos);
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
			poblacion = Cruce.cruzar(poblacion, distancias, pesos, cantidad);

			/*
			 * Operador de mutacion
			 */
			poblacion = Mutacion.mutarPoblacion(poblacion, distancias, pesos, cantidad);
		}
		
		Individuos min_fitness;
		min_fitness = poblacion.get(0);
		for(int ii=0; ii<poblacion.size();ii++){
			Individuos aux = poblacion.get(ii);
			if(aux.getFitnes()<min_fitness.getFitnes()){
				min_fitness = aux;
			}
			//System.out.println(aux.getCromosoma());
			//System.out.println(aux.getFitnes()+"\n");
		}
		System.out.println(min_fitness.getCromosoma());
		System.out.println(min_fitness.getFitnes());
	}

}
