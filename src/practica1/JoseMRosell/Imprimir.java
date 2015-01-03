package practica1.JoseMRosell;

import java.util.ArrayList;

/**
 * Clase para mostrar por pantalla las poblaciones generadas.
 * @author Jose Manuel Rosell Sanchez
 */
public class Imprimir {
	
	/**
	 * Imprime la poblacion completa. Imprime el cromosoma y el fitness de todos
	 * los indiviudos de la poblacion.
	 *
	 * @param poblacion la poblacion actual
	 */
	public static void imprimirPoblacion(ArrayList<Individuos> poblacion){
		for(int i=0; i<poblacion.size();i++){
			for(int j=0; j<poblacion.get(i).getCromosoma().size();j++){
				System.out.print(poblacion.get(i).getCromosoma().get(j)+" ");
			}
			System.out.println("\n"+poblacion.get(i).getFitnes()+"\n");
		}
	}
	
	/**
	 * Busca la mejor solucion, es decir, la que tiene el menor fitness
	 * dentro de toda la poblacion. Imprime el cromosoma y el fitness del
	 * mejor individuo de la poblacion.
	 *
	 * @param poblacion la poblacion actual
	 */
	public static void mejorSolucion(ArrayList<Individuos> poblacion){
		Individuos min_fitness;
		min_fitness = poblacion.get(0);
		for(int ii=0; ii<poblacion.size();ii++){
			Individuos aux = poblacion.get(ii);
			if(aux.getFitnes()<min_fitness.getFitnes()){
				min_fitness = aux;
			}
		}
		
		for(int j=0; j<min_fitness.getCromosoma().size(); j++){
			System.out.print(min_fitness.getCromosoma().get(j)+" ");
		}
		System.out.println("\n"+min_fitness.getFitnes());
	}
}
