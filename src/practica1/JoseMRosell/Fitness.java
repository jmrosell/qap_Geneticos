package practica1.JoseMRosell;

import java.util.ArrayList;

/**
 * Clase para obtener el fitness de un cromosoma (o solucion).
 * @author Jose Manuel Rosell Sanchez
 */
public class Fitness {
	
	/**
	 * Obtiene el fitness de una solucion del problema.
	 *
	 * @param i1 el individuo del cual obtener el fitness
	 * @param distancias las distancias entre las fabricas
	 * @param pesos los pesos entre las fabricas
	 */
	public static void fitnessCromosoma(Individuos i1, ArrayList<ArrayList<Integer>> distancias,  ArrayList<ArrayList<Integer>> pesos){
		i1.setFitnes(0);
		for (int k = 0; k < i1.getCromosoma().size(); k++) {
			for (int l = k + 1; l < i1.getCromosoma().size(); l++) {
				int fabrica1 = i1.getCromosoma().get(k);
				int fabrica2 = i1.getCromosoma().get(l);
				int fitnes = i1.getFitnes() + (distancias.get(k).get(l) * pesos.get(fabrica1).get(fabrica2));
				i1.setFitnes(fitnes);
			}
		}
	}
	
	/**
	 * Calcular el fitness de una solucion obtienen el mejor fitness para el un cromosoma dado, utilizando para ello
	 * un algoritmo Greedy. Se calcula el mejor fitness pero no se modifica el cromosoma del individuo, unicamente se
	 * modifica el fitness.
	 *
	 * @param i1 el individuo del cual obtener el fitness
	 * @param distancias las distancias entre las fabricas
	 * @param pesos los pesos entre las fabricas
	 */
	public static void fitnessGreedy(Individuos i1, ArrayList<ArrayList<Integer>> distancias,  ArrayList<ArrayList<Integer>> pesos){
		fitnessCromosoma(i1, distancias, pesos);

		Individuos aux = new Individuos();
		aux = HeuristicaGreedy.twoOpt(i1, distancias, pesos);
		i1.setFitnes(aux.getFitnes());
	}
	
	/**
	 * Calcular el fitness de una solucion obtienen el mejor fitness para el un cromosoma dado, utilizando para ello
	 * un algoritmo Greedy. Se calcula el mejor fitness y se modifica el cromosoma del individuo, ademas de 
	 * modificar el fitness del individuo.
	 *
	 * @param i1 el individuo del cual obtener el fitness
	 * @param distancias las distancias entre las fabricas
	 * @param pesos los pesos entre las fabricas
	 */
	public static void fitnessGreedyModifica(Individuos i1, ArrayList<ArrayList<Integer>> distancias,  ArrayList<ArrayList<Integer>> pesos){
		fitnessCromosoma(i1, distancias, pesos);
	
		Individuos aux = new Individuos();
		aux = HeuristicaGreedy.twoOpt(i1, distancias, pesos);
		
		i1.setFitnes(aux.getFitnes());
		i1.setCromosoma(aux.getCromosoma());
	}
}
