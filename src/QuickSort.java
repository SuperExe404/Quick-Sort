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

    public static int[] bubbleSort(int[] arreglo) {
        boolean cambios = false;
        int auxiliar;
        do {
            cambios = false;
            for (int i = 0; i < arreglo.length - 1; i++) {
                if (arreglo[i] > arreglo[i + 1]) {
                    // Hacer el intercambio
                    auxiliar = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = auxiliar;
                    cambios = true;
                }
            }
        } while (cambios);

        return arreglo;
    }

    // Método de búsqueda binaria
    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == key) {
                return mid; // Elemento encontrado
            } else if (array[mid] < key) {
                low = mid + 1; // Buscar en la mitad derecha
            } else {
                high = mid - 1; // Buscar en la mitad izquierda
            }
        }

        return -1; // Elemento no encontrado
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

        // Búsqueda binaria
        System.out.println("Ingrese el número a buscar:");
        int numeroABuscar = Integer.parseInt(bufer.readLine());
        int resultadoBusqueda = binarySearch(datos, numeroABuscar);

        if (resultadoBusqueda != -1) {
            System.out.println("El número " + numeroABuscar + " fue encontrado en la posición " + resultadoBusqueda);
        } else {
            System.out.println("El número " + numeroABuscar + " no fue encontrado en el arreglo.");
        }

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
