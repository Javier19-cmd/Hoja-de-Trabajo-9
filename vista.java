//Imports necesarios para poder trabajar con el archivo.
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class vista {
//Creando variables de utilidad.

//Variables para el inicio.
static Scanner iniciar = new Scanner(System.in);
static int inic; 

    //Método que servirá para el menú del usuario.
    public static void menu(){
        
        Factory f = new Factory(); //Instancia del patrón Factory.
        TInterfaz arb;             //Instancia de la interfaz del árbol.
        String l = "";             //Variable para recorrer las líneas del archivo.

        //Creando menú de inicio.
        System.out.println("Bienvenido al traductor......");
        System.out.println("¿Qué implementación desea utilizar?");
        System.out.println("1. SplayTree");
        System.out.println("2.");//Agregar la segunda implementación.
        System.out.println("3. Salir");

            //Progra defensiva.
            try {
                //Ingresando la opción.
                inic = iniciar.nextInt(); 

            } catch (Exception OpcionNoNumerica) {
                //Opción no numérica seleccionada.
                iniciar.nextLine(); 
                
                System.out.println("Opción no numérica seleccionada.");

            }
            
            arb = f.obtenerArbol(inic); //Enviando la elección a la clase Factory.

            //Se procede a leer el archivo que contiene las palabras del diccionario.
            try {
                FileReader lecura = new FileReader("Spanish.txt");
                BufferedReader buf = new BufferedReader(lecura);
                
                while((l = buf.readLine()) != null)
                {   
                    //Quitando caracteres y tabulaciones que podrían afectar.
                    l = l.replaceAll(";", "");
                    l = l.replaceAll(",", " ");
                    l = l.replaceAll("\t", " ");
            
                    String[] traducciones = l.split(" "); //Array para almacenar las palabras y sus traducciones.
                    
                    String ingles = traducciones[0];  //Variable que almacenará las palabras en inglés en el Array.
                    String espanol = traducciones[0]; //Variable que almacenará las palabras en español en el Array.
                    
                    //System.out.println(ingles);

                    //System.out.println(espanol);
                    
                    arb.put(ingles, espanol); //Guardando la palabra en inglés con su significado en español.
                }
                buf.close();
            } catch (IOException ArchivoNoEncontrado) {
                //El archivo no se encontró.
                System.out.println("El archivo no existe en el directorio.");
            }

            
    }
}
