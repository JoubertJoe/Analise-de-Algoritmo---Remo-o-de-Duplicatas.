import java.util.*;

public class dnqRemoveDuplicadas {

	static void merge(int[] A, int p, int q, int r) {
		int[] aux = new int[r - p + 1];
		int a = p;
		int b = q + 1;
		int h = 0;
		while (a <= q && b <= r) {
			if (A[a] < A[b]) {
				aux[h++] = A[a++];
			} else if (A[a] > A[b]) {
				aux[h++] = A[b++];
			} else {
				b++;
			}
		}
		while (a <= q) {
			aux[h++] = A[a++];
		}
		while (b <= r) {
			aux[h++] = A[b++];
		}
		for (h = 0; h < aux.length; h++) {
			A[p++] = aux[h];
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static void mergeSort(int[] A, int p, int r) {
		int q = (p + r) / 2;
		if (p < r) {
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	public static void main(String args[]) {
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int tamanhoVetor = 10000000;
		int vetor[] = new int[tamanhoVetor];
		for (int i = 0; i < vetor.length; i++) {
			int randomNum = 1 + (int) (Math.random() * tamanhoVetor / 2);
			vetor[i] = randomNum;
		}
		// printArray(vetor);
		long time = System.currentTimeMillis();
		mergeSort(vetor, 0, vetor.length - 1);
		long afterTime = System.currentTimeMillis();

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != 0) {
				lista.add(vetor[i]);
			}
		}
		// System.out.println(lista.toString());
		System.out.println("Quantidade de Elementos :" + tamanhoVetor);
		System.out.println("Inicio :" + time);
		System.out.println("FIM :" + afterTime);
		System.out.println("Tempo total:" + (afterTime - time) + " MiliSegundos");

	}
}
