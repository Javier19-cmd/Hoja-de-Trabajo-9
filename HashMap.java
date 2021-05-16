import java.util.HashMap;

/**
 * Clase donde se implementa la opción del HashMap
 **/
public class HashMapImp< Key , Value> implements TInterfaz< Key , Value> {
	
	/**
	 * Mapa interno donde se usa hashMap de java
	 */
  HashMap<Key,Value> interno = new HashMap<Key,Value>();
	
	/**
	 * Se implementan los metodos
	 */
	public void put (Key key, Value value) {
		interno.put(key, value);
	}
	
	public Value get(Key key) {
		if(interno.containsKey(key)) return interno.get(key);
        else return null ;
	}
	
	public int size () {
		return mapa.size();
	}
}
