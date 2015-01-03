package practica1.JoseMRosell;

import java.util.ArrayList;

/**
 * Algoritmo Greedy para realizar busquedas locales a partir de un individuo.
 */
public class HeuristicaGreedy {
	
	/**
	 * Busca la mejor solucion a partir de un individuo de la poblacion.
	 *
	 * @param individuo el individuo inicial
	 * @param distancias distancias entre las fabricas
	 * @param pesos los pesos entre las fabricas
	 * @return el nuevo individuo
	 */
	public static Individuos twoOpt(Individuos individuo, ArrayList<ArrayList<Integer>> distancias, ArrayList<ArrayList<Integer>> pesos){
		Individuos resultado = new Individuos();
		Individuos mejor = new Individuos();

		resultado.setFitnes(individuo.getFitnes());
		resultado.setCromosoma(individuo.getCromosoma());

		mejor.setFitnes(individuo.getFitnes());
		mejor.setCromosoma(individuo.getCromosoma());

		for(int i=0; i<resultado.getCromosoma().size(); i++){
			for(int j=i+1; j<resultado.getCromosoma().size(); j++){
				//Intercambiamos el alelo i por el alelo j
				int valor1 = resultado.getCromosoma().get(i);
				int valor2 = resultado.getCromosoma().get(j);
				
				resultado.getCromosoma().set(i, valor2);
				resultado.getCromosoma().set(j, valor1);
				
				//calculamos el nuevo fitness
				Fitness.fitnessCromosoma(resultado, distancias, pesos);

				if(resultado.getFitnes()<mejor.getFitnes()){
					mejor.setCromosoma(resultado.getCromosoma());
					mejor.setFitnes(resultado.getFitnes());
				}
			}
		}

		return mejor;
	}
}
