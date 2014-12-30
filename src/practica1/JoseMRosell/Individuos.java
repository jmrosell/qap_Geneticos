package practica1.JoseMRosell;

import java.util.ArrayList;
import java.util.Random;

public class Individuos {
	private int fitnes;
	private ArrayList<Integer> cromosoma;
	
	public Individuos(){
		fitnes = 0;
		cromosoma = new ArrayList<Integer>();
	}
	
	public Individuos(int size){
		fitnes = 0;
		cromosoma = new ArrayList<Integer>();
		
		Random rnd = new Random();

		for(int i=0; i<size; i++){
			int number = rnd.nextInt(((size-1) - 0) + 1) + 0;
			while(cromosoma.contains(number)){
				number = rnd.nextInt(((size-1) - 0) + 1) + 0;
			}
			cromosoma.add(number);
		}
	}
	
	public int getFitnes() {
		return fitnes;
	}

	public void setFitnes(int fitnes) {
		this.fitnes = fitnes;
	}

	public ArrayList<Integer> getCromosoma() {
		return cromosoma;
	}

	public void setCromosoma(ArrayList<Integer> cromosoma) {
		this.cromosoma = cromosoma;
	}
}
