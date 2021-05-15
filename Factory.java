/**
 * Clase Factory: Esta se usará para poder llamar al árbol que se desee.
 * 
 * 
 */

public class Factory {
   //Creando la interfaz para el patrón Factory. 
   public TInterfaz <String, String> obtenerArbol(int ele){
       
        if(ele == 1){
            return new SplayTree<>(); //Implementación del Splay Tree. 
        }else{
            return new SplayTree<>();//Agregar la segunda implementación del árbol.
        }
   }
}
