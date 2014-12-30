package practica1.JoseMRosell;

import java.util.ArrayList;
import java.util.Random;

public class Cruce {
	public static ArrayList<Integer> subArray(ArrayList<Integer> array, int pos_ini, int pos_fin){
		ArrayList<Integer> sub = new ArrayList<Integer>();

		for(int i=pos_ini; i<pos_fin; i++){
			sub.add(array.get(i));
		}
		
		return sub;
	}
	public static ArrayList<Individuos> cruzar(ArrayList<Individuos> poblacion, ArrayList<ArrayList<Integer>> distancias,
											ArrayList<ArrayList<Integer>> pesos, int cantidad){
		ArrayList<Individuos> nueva_poblacion = new ArrayList<Individuos>();
		int tam = poblacion.size();
		Random rnd = new Random();

		while(!poblacion.isEmpty()){
			int c1 = rnd.nextInt(((tam-1) - 0) + 1) + 0;
			int c2 = rnd.nextInt(((tam-1) - 0) + 1) + 0;
			while(c1==c2){
				c2 = rnd.nextInt(((tam-1) - 0) + 1) + 0;
			}
			
			Individuos aux1 = poblacion.get(c1);
			Individuos aux2 = poblacion.get(c2);
			
			int pos = rnd.nextInt(((cantidad-2) - 1) + 1) + 1;
			
			ArrayList<Integer> p1 = subArray(aux1.getCromosoma(), 0, pos);
			ArrayList<Integer> p2 = subArray(aux2.getCromosoma(), 0, pos);

			for(int z=pos; z<cantidad; z++){
				if(p1.contains(aux2.getCromosoma().get(z)) == false){
					p1.add(aux2.getCromosoma().get(z));
				}
				if(p2.contains(aux1.getCromosoma().get(z)) == false){
					p2.add(aux1.getCromosoma().get(z));
				}
			}
			
			for(int i=0; i<cantidad; i++){
				if(p1.contains(aux2.getCromosoma().get(i)) == false){
					p1.add(aux2.getCromosoma().get(i));
				}
				if(p2.contains(aux1.getCromosoma().get(i)) == false){
					p2.add(aux1.getCromosoma().get(i));
				}
			}
			
			ArrayList<Integer> cromosoma1 = new ArrayList<>(p1);
			ArrayList<Integer> cromosoma2 = new ArrayList<>(p2);
			aux1.setCromosoma(cromosoma1);
			aux2.setCromosoma(cromosoma2);
			//Calculamos el fitness del nuevo cromosoma
			Fitness.fitnessCromosoma(aux1, distancias, pesos);
			Fitness.fitnessCromosoma(aux2, distancias, pesos);
			
			//Añadimos los dos nuevos individuos a la poblacion
			nueva_poblacion.add(aux1);
			nueva_poblacion.add(aux2);
			
			if(c1>c2){
				poblacion.remove(c1);
				poblacion.remove(c2);
			}else{
				poblacion.remove(c2);
				poblacion.remove(c1);
			}
			
			tam-=2;
		}
		
		return nueva_poblacion;
	}
}
