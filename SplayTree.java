/**
 * 
 * @see https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
 */
public class SplayTree <Key extends Comparable <Key>, Value> implements TInterfaz<Key, Value>{
    /** Class Node **/

  private class Node {


    public Node root;   // Raíz para el SplayTree
    
    // Nodo que será de ayuda para poder trabajar los valores del árbol. 
    
        private Key key;            // Llave
        private Value value;        // Valor a trabajar dentro del árbol.
        private Node left, right;   // Ramas izquierda y derecha.
    
    //Constructor que recibirá los valores a trabajar en el árbol. 
    public Node(Key key, Value value) {
        this.key   = key;
        this.value = value;
    }
    
    //Método que se encarga de verificar si existe o no el valor a buscar.
    public boolean contains(Key key) {
        return get(key) != null;
    }
    
    //Retorno del valor asociado con su correspondiente llave.
    //Si en caso no existe la llave, entonces se regresa nulo.
    public Value get(Key key) {
        root = splay(root, key);
        
        int cmp = key.compareTo(root.key); //Verificando la llave.
        
        if (cmp == 0){
        
            return root.value; //Si en caso existe el valor asociado, entonces se regresa el valor de la llave.
        } 
        
        else{
        
            return null;  //En caso de que no exista la llave, se regresa null como valor. 
        } 
    }      
}

    @Override
    public void put(Key key, Value valor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean containsKey(Key key) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Value getKey(Key key) {
        // TODO Auto-generated method stub
        return null;
    }
         

}