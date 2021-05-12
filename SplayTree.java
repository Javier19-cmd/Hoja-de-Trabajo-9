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
    
    private Node splay(Node h, Key key) {
    
       //Si en caso la llave está vacía, entonces se regresa nulo.
       if (h == null){
          return null;
       } 

        int cmp1 = key.compareTo(h.key);

        if (cmp1 < 0) {
            
            //En este caso, la llave no está en el árbol, entonces se regresa la llave en sí.
            if (h.left == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.left.key);
            if (cmp2 < 0) {
                //Realizando rotación hacia la derecha para poder acomodar el árbol.
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null){
                    //En caso de que tanto las ramas izquierda como derecha estén llenas, se hace una rotación hacia la izquierda.
                    h.left = rotateLeft(h.left);
                }
            }
            
            //Si en caso la izquierda está nula, entonces se regresa el nodo. 
            if (h.left == null) {
                return h;
            }else{ //Si en caso no está vacía, se rota hacia la derecha.
                return rotateRight(h);
            }                
        }

        else if (cmp1 > 0) { 
            //Si la comparación resultó ser mayor a 1, entonces la llave no está en el árbol.
            if (h.right == null) {
                return h;
            }

            int cmp2 = key.compareTo(h.right.key);
            if (cmp2 < 0) {
                h.right.left  = splay(h.right.left, key);
                if (h.right.left != null){ //Si en caso las ramas izquierda y derecha no están vacías, entonces se hace una rotación hacia la derecha.
                    h.right = rotateRight(h.right);
                }
                    
            }
            else if (cmp2 > 0) {//Si en caso la comparación es mayor a 0, entonces se hace una rotación hacia la izquierda.
                h.right.right = splay(h.right.right, key);
                h = rotateLeft(h);
            }
            
            if (h.right == null) { //Si en caso el nodo está vacío, entonces se regresa dicho nodo.
                return h;
            
            }else{ //En caso de no estar nulo, se hace una rotación hacia la izquierda.

                return rotateLeft(h);
            }
        }

        else return h;
    }

    
    //Método para devolver la altura del árbol: este retorna la raíz del mismo.
    public int height() { 
        
        return height(root); 
    
    }

    //Método de tipo int que se encarga de medir la altura del árbol.
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    //Método que se encarga de devolver el tamaño del árbol.
    public int size() {
        return size(root);
    }
    
    //Método de tipo entero que se encarga de medir el tamaño en si del árbol.
    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }
    
    // Método encargado de hacer la rotación del árbol hacia la derecha. 
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    //  Método que se encarga de hacer la rotación hacia la izquierda del árbol.
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }
    
}