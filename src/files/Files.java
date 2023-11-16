package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Files {
    public  int contarLineas(String name){
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        int numLineas = 0;
        
        try{
            archivo = new File ("C:\\Users\\diego\\Downloads\\Numeros\\"+ name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            
            while ((bufer.readLine()) != null) {
                numLineas++;
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error al abrir/leer el archivo: " + e.toString());
        }
        return numLineas;
    }
    

    public  String[] archivoAstring(String name){
        File archivo;//apuntar a un archivo fisico en el DD
        FileReader reader; //Para abrir el archivo
        BufferedReader bufer; //para leer la info del archivo
        String linea;
        String[] arreglo = null;
        int t; // Tamaño del aricho, que sera el tamaño del arreglo
        int i = 0; //indice del arreglo
        try{
            t = contarLineas(name); // Saber cuantos elementos son
            arreglo = new String[t];//Construit el arreglo con el valor de t
            archivo = new File ("C:\\Users\\diego\\Downloads\\Numeros\\"+ name + ".txt");  //apunta al archivomas
            reader = new FileReader(archivo); // Abrir el archivo para su lectura
            bufer = new BufferedReader(reader);

            while ((linea = bufer.readLine()) != null) {
                arreglo[i]= linea;
                i++;
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error al abrir/leer el archivo: " + e.toString());
        }
        return arreglo;
    }


        public  int[] archivoAint(String name){
        File archivo;//apuntar a un archivo fisico en el DD
        FileReader reader; //Para abrir el archivo
        BufferedReader bufer; //para leer la info del archivo
        String linea;
        int[] arreglo = null;
        int t; // Tamaño del aricho, que sera el tamaño del arreglo
        int i = 0; //indice del arreglo
        try{
            t = contarLineas(name); // Saber cuantos elementos son
            arreglo = new int[t];//Construit el arreglo con el valor de t
            archivo = new File ("C:\\Users\\diego\\Downloads\\Numeros\\"+ name + ".txt");  //apunta al archivomas
            reader = new FileReader(archivo); // Abrir el archivo para su lectura
            bufer = new BufferedReader(reader);

            while ((linea = bufer.readLine()) != null) {
                arreglo[i]= Integer.parseInt(linea);
                i++;
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error al abrir/leer el archivo: " + e.toString());
        }
        return arreglo;
    }

    public  void escribirArchivo(String name){
        // Apuntadore a la seccion del dd donde se creo
        FileWriter archivo;
        // LLave para acceso en modo escritura
        PrintWriter writer;
        BufferedReader bufer = new BufferedReader(
            new InputStreamReader(System.in));
        String entrada;
        char respuesta;

        try{
            archivo =  new FileWriter("C:\\Users\\diego\\Downloads\\Numeros\\" + name + ".txt");
            writer = new PrintWriter(archivo);
            do{
                System.out.println("Escribe datos para el archivo: ");
                entrada = bufer.readLine();
                writer.println(entrada);
                System.out.println("Escribe x para parar: ");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            } while (respuesta != 'x');
            archivo.close();
        } catch (Exception e){
            System.out.println("Error al crear el archivo: " + e.toString());
        }
    }

    public  void arregloArchivo(String name, int[] array){
        FileWriter archivo;
        PrintWriter writer;
        try{
            archivo =  new FileWriter("C:\\Users\\diego\\Downloads\\Numeros\\" + name + ".txt");
            writer = new PrintWriter(archivo);
            for( int unDato : array ){
                writer.println(unDato);
            }
            archivo.close();
        } catch (Exception e){
            System.out.println("Error al crear el archivo: " + e.toString());
        }
    }
    
}