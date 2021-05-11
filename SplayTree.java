/**
 * 
 * @see https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
 */
public class SplayTree <Key extends Comparable <Key>, Value> implements TInterfaz<Key, Value>{
    
    public Node root;   // Raíz para el SplayTree
    
    /** Class Node **/

  private class Node {

    
    // Nodo que será de ayuda para poder trabajar los valores del árbol. 
    
        private Key key;            // Llave
        private Value value;        // Valor a trabajar dentro del árbol.
        private Node left, right;   // Ramas izquierda y derecha.
    
    //Constructor que recibirá los valores a trabajar en el árbol. 
    public Node(Key key, Value value) {
        this.key   = key;
        this.value = value;
    }
    
    
    
           
}

    /**
     * Método 
     * @param key llave del valor a ingresar al árbol.
     * @param value valor a ingresar 
     * 
    */
    @Override
    public void put(Key key, Value value) {
        
        if(root == null){//Si la raíz está vacía, entonces se crea una nueva raíz usando la clase de Nodo.

            root = new Node(key, value); //Creando la raíz.
            return;
        }

        root = splay(root, key); //Usando el método splay para la raíz.

        int cmp = key.compareTo(root.key); //Comparando la llave con la raíz.

        //Insertando un nuevo nodo en la parte izquierda si en caso la comparación es menor a cero.
        if(cmp < 0){
            
            //Insertando el nodo a la izquierda del árbol.
            Node n = new Node(key, value);
            n.left = root.left; 
            n.right = root; 
            root.left = null; 
            root = n; 
        
        //Insertando un nuevo nodo en la parte derecha, en caso la comparación es mayor a cero.    
        }else if(cmp > 0){

            //Insertando el nodo a la derecha del árbol.
            Node n = new Node(key, value); //Creando el nodo.
            n.right = root.right;
            root.left = null; 
            root = n; 
        
        }else{//Si en caso hay un valor duplicado, entonces se reemplaza ese valor en donde sea que esté.

            root.value = value; 
        }
        
    }

    //Método que se encarga de verificar si existe o no el valor a buscar.
    @Override
    public boolean contains(Key key) {
        return get(key) != null; //Retornando el valor a buscar.
    }

    //Retorno del valor asociado con su correspondiente llave.
    //Si en caso no existe la llave, entonces se regresa nulo.
    @Override
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