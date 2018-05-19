package analise.algoritmosLimpos;

import java.util.*;

public class dnqRemoveDuplicadas {

	static void merge(long[] vetor, int p, int q, int r) { // Método Merge MODIFICADO para remover as duplicatas
		long[] aux = new long[r - p + 1];
		int a = p;
		int b = q + 1;
		int h = 0;
		while (a <= q && b <= r) {
			if (vetor[a] < vetor[b]) {
				aux[h++] = vetor[a++];
				// Antes era apenas um Else, agora foi adicionado uma condição para evitar
				// que numeros iguais sejam copiados de um vetor ao outro.
			} else if (vetor[a] > vetor[b]) {
				aux[h++] = vetor[b++];
			} else {
				// Dentro desse else, os itens são iguais, isso faz
				// Nesse momento incrementamos o index da direita
				// Porém, não passamos nada pra essa posição
				b++;
			}
		}
		while (a <= q) {
			aux[h++] = vetor[a++];
		}
		while (b <= r) {
			aux[h++] = vetor[b++];
		}
		for (h = 0; h < aux.length; h++) {
			vetor[p++] = aux[h];
		}
	}

	static void mergeSort(long[] vetor, int p, int r) { // Método MergeSort sem modificações.
		int q = (p + r) / 2;
		if (p < r) {
			mergeSort(vetor, p, q);
			mergeSort(vetor, q + 1, r);
			merge(vetor, p, q, r);
		}
	}

	static void printArray(long[] vetor) { // Método simples para imprimir vetores.
		int n = vetor.length;
		for (int i = 0; i < n; ++i)
			System.out.print(vetor[i] + " ");
		System.out.println();

	}

	public static void main(String args[]) {

		int tamanhoVetor = 1000;
		long vetor[] = new long[tamanhoVetor];
		for (int i = 0; i < vetor.length; i++) {
			int randomNum = 1 + (int) (Math.random() * tamanhoVetor / 10);
			vetor[i] = randomNum;
		}
		printArray(vetor);
		long time = System.currentTimeMillis();
		mergeSort(vetor, 0, vetor.length - 1);
		long afterTime = System.currentTimeMillis();
		printArray(vetor);
		System.out.println("Quantidade de Elementos :" + tamanhoVetor);
		System.out.println("Tempo total:" + (afterTime - time) + " MiliSegundos");

	}
}
