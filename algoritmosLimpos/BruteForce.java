package analise.algoritmosLimpos;

import java.util.LinkedList;

public class BruteForce {

	public static void bruteForce(int vetorComDup[], LinkedList<Integer> listaSemDup, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j != i) {
					if (vetorComDup[i] == vetorComDup[j])
						vetorComDup[j] = -1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (vetorComDup[i] != -1) {
				listaSemDup.add(vetorComDup[i]);
			}
		}
	}

	public static void main(String[] args) {
		int n = 10; // Numero de Elementos.

		int vetorComDup[] = new int[n];
		LinkedList<Integer> listaSemDup = new LinkedList<Integer>();
		// Gerando Números Aleatórios
		for (int i = 0; i < n; i++) {
			int randomNum = 1 + (int) (Math.random() * n / 2);
			vetorComDup[i] = randomNum;
		}
		long time = System.nanoTime(); 				//Tempo Inicial
		bruteForce(vetorComDup, listaSemDup, n);	//Rodando Algoritmo
		long afterTime = System.nanoTime();			//Tempo Final
		System.out.println("Tempo: " + (afterTime - time));
	}

}
