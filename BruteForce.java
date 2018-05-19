package analise.brute;


import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JList;

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
	
	public static long automacao(int n) {
		
		int vetorComDup[] = new int[n];
		LinkedList<Integer> listaSemDup = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			int randomNum = 1 + (int)(Math.random() * n/2);
			vetorComDup[i] = randomNum;
		}
		
		//long time = System.currentTimeMillis();
		long time = System.nanoTime();
		
		bruteForce(vetorComDup, listaSemDup, n);
		
		//long afterTime = System.currentTimeMillis();
		long afterTime = System.nanoTime();
		
		
		return afterTime - time;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Inicio 1, final 30 mil, passos de 1mil, repetições : 10 || Médias :");
		for (int i = 0; i <= 20;) {
			long media = 0;
			for (int j = 0; j < 200; j++) {
				media = media + automacao(i);	
			}			
			System.out.print(media/200 + "\t");
			//System.out.print(i + "\t");
			i=i+1;
			
		}
		
		
		
	}
}