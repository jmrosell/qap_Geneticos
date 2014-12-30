package practica1.JoseMRosell;

import java.util.ArrayList;
import java.util.Random;

public class Mutacion {
	public static Individuos mutacion(Individuos ind, int cantidad){
		Random rnd = new Random();
		
		int posicion1 = rnd.nextInt(((cantidad-1) - 0) + 1) + 0;;
		int posicion2 = rnd.nextInt(((cantidad-1) - 0) + 1) + 0;;

		int valor1 = ind.getCromosoma().get(posicion1);
		int valor2 = ind.getCromosoma().get(posicion2);
		
		ind.getCromosoma().set(posicion1, valor2);
		ind.getCromosoma().set(posicion2, valor1);
		
		return ind;
	}
	
	public static ArrayList<Individuos> mutarPoblacion(ArrayList<Individuos> poblacion, ArrayList<ArrayList<Integer>> distancias,
												ArrayList<ArrayList<Integer>> pesos, int cantidad){
		ArrayList<Individuos> nueva_poblacion = new ArrayList<Individuos>();
		
		for(int i=0; i<poblacion.size(); i++){
			Individuos aux = new Individuos();
			
			aux = mutacion(poblacion.get(i), cantidad);
			
			//Calculamos el fitness del nuevo cromosoma
			Fitness.fitnessCromosoma(aux, distancias, pesos);
			//Añadimos el nuevo individuo a la poblacion
			nueva_poblacion.add(aux);
		}
		
		return nueva_poblacion;
	}
}
