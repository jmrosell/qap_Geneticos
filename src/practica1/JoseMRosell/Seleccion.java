package practica1.JoseMRosell;

import java.util.ArrayList;
import java.util.Random;

public class Seleccion {
	public static ArrayList<Individuos> porTorneo(ArrayList<Individuos> poblacion){
		Random rnd = new Random();
		ArrayList<Individuos> nueva_poblacion = new ArrayList<Individuos>();
		
		for(int i=0; i<poblacion.size(); i++){
			int cromosoma1 = rnd.nextInt(((poblacion.size()-1) - 0) + 1) + 0;
			int cromosoma2 = rnd.nextInt(((poblacion.size()-1) - 0) + 1) + 0;
			while(cromosoma2==cromosoma1){
				cromosoma2 = rnd.nextInt(((poblacion.size()-1) - 0) + 1) + 0;
			}

			Individuos aux1 = poblacion.get(cromosoma1);
			Individuos aux2 = poblacion.get(cromosoma2);
			
			if(aux1.getFitnes() < aux2.getFitnes()){
				nueva_poblacion.add(aux1);
			}else{
				nueva_poblacion.add(aux2);
			}
		}
		return nueva_poblacion;
	}
}
