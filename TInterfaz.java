/**
 * 
 * Interfaz TInterfaz: Esta será la encargada de contener los métodos generales para poder trabajar con una parte de los árboles.
 * 
 * @see https://www.programiz.com/java-programming/map
 * 
 * @param Key
 * @param Value
 * 
 */
public interface TInterfaz <Key extends Comparable<Key>, Value>{
     
    public void put(Key key, Value value); //Método de tipo void que será el encargado de ingresar los valores al árbol.
    public boolean contains(Key key);   //Método booleano que será el encargado de verificar que cada valor tenga una llave. 
    public Value get(Key key);          //Método de tipo value que será el encargado de obtener la llave del valor.
}