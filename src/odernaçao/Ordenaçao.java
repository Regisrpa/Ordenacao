package odernaçao;

import java.util.Arrays;
import java.util.Random;

public class Ordenaçao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("Aleatorio");
        int[] v = aleatorio(1000);
        System.out.println("" + Arrays.toString(v));

       
        System.out.println("Bubble Sort");
        bubbleSort(v);
        System.out.println("" + Arrays.toString(v));

       
        System.out.println("Quick Sort");
        Ordenaçao ord = new Ordenaçao();
        ord.quickSort(v, 0, v.length - 1);
        System.out.println("" + Arrays.toString(v));

      
        System.out.println("Merge Sort");
        int[] aux = new int[v.length];
        mergeSort(v, aux, 0, v.length - 1);
        System.out.println("" + Arrays.toString(v));

    }

    public static int[] aleatorio(int n) {
        Random random = new Random();
        int[] vetor = new int[n];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(n);
        }
        return vetor;
    }

    public static void bubbleSort(int v[]) {

        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
    }

    public void quickSort(int arr[], int inicio, int fim) {
        if (inicio < fim) {
            int particionarIndex = particionar(arr, inicio, fim);

            quickSort(arr, inicio, particionarIndex - 1);
            quickSort(arr, particionarIndex + 1, fim);
        }
    }

    private int particionar(int arr[], int inicio, int fim) {
        int pivot = arr[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int aux = arr[i + 1];
        arr[i + 1] = arr[fim];
        arr[fim] = aux;

        return i + 1;
    }

    public static void mergeSort(int[] v, int[] arr, int inicio, int fim) {

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(v, arr, inicio, meio);
            mergeSort(v, arr, meio + 1, fim);
            intercalar(v, arr, inicio, meio, fim);
        }
    }

    private static void intercalar(int[] v, int[] arr, int inicio, int meio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            arr[i] = v[i];
        }
        int aux = inicio;
        int temp = meio + 1;

        for (int j = inicio; j <= fim; j++) {
            if (aux > meio) {
                v[j] = arr[temp++];
            } else if (temp > fim) {
                v[j] = arr[aux++];
            } else if (arr[aux] < arr[temp]) {
                v[j] = arr[aux++];
            } else {
                v[j] = arr[j++];
            }
        }

    }

}
