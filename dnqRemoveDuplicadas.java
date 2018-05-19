package analise.dnq;
import java.util.*;
 

 
public class dnqRemoveDuplicadas {
 

 
  static void merge(long[] vetor, int p, int q, int r) {
 
    long[] aux = new long[r - p + 1];
 
    int a = p;
 
    int b = q + 1;
 
    int h = 0;
 
    while (a <= q && b <= r) {
 
      if (vetor[a] < vetor[b]) {
 
        aux[h++] = vetor[a++];
 
      } else if (vetor[a] > vetor[b]) {
 
        aux[h++] = vetor[b++];
 
      } else {
 
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
 

 
  static void printArray(int arr[]) {
 
    int n = arr.length;
 
    for (int i = 0; i < n; ++i)
 
      System.out.print(arr[i] + " ");
 
    System.out.println();
 
  }
 

 
  static void mergeSort(long[] vetor, int p, int r) {
 
    int q = (p + r) / 2;
 
    if (p < r) {
 
      mergeSort(vetor, p, q);
 
      mergeSort(vetor, q + 1, r);
 
      merge(vetor, p, q, r);
 
    }
 
  }
 

 
  public static void main(String args[]) {
 
    
 
    ArrayList<Long> lista = new ArrayList<Long>();
 
    int tamanhoVetor = 150000000;
 
    long vetor[] = new long[tamanhoVetor];
 
    for (int i = 0; i < vetor.length; i++) {
 
      int randomNum = 1 + (int) (Math.random() * tamanhoVetor / 10);
 
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
 
   // System.out.println("Inicio :" + time);
 
 //   System.out.println("FIM :" + afterTime);
 
    System.out.println("Tempo total:" + (afterTime - time) + " MiliSegundos");
    System.out.println("--------------------------------");
 

 
  }
 
}
 