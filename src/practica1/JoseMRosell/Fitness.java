package practica1.JoseMRosell;

import java.util.ArrayList;

public class Fitness {
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
}
