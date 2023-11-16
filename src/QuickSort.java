import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import files.Files;

public class QuickSort {

    public static void imprimirArchivos(int[] arreglo) {
        for (int numero : arreglo) {
            System.out.println(numero);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        int[] datos;
        Files archivo = new Files();

        System.out.println("Ordenamiento Quick Sort");
        System.out.println("Escribe el nombre del archivo:");
        fileName = bufer.readLine();
        datos = archivo.archivoAint(fileName);

        System.out.println("Arreglo Original:");
        imprimirArchivos(datos);

        // Ordenar el array usando QuickSort
        System.out.println("Arreglo Ordenado:");
        datos = quickSort(datos, 0, datos.length - 1);
        imprimirArchivos(datos);

        // Guardar el arreglo ordenado en un archivo
        archivo.arregloArchivo("resultado", datos);
    }

    // Implementación de QuickSort
    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
        return array;
    }

    // Función de partición para QuickSort
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Intercambiar array[i] y array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambiar array[i+1] y array[high] (pivote)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Devolver la posición del pivote
        return i + 1;
    }
}
