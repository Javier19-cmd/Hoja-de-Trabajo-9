import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Clase que se encargara de traducir
 */
public class Diccionario {
	
	/**
	 * Traducir si es la implementacion de HashMap
	 * @param map
	 */
	public void transeHash(TInterfaz<String, String> map) {
		Scanner entrada = new Scanner(System.in);
		String palabra = "";
		String oracion = "";
		Scanner inputScan;
		try {
			String direcNuevo = System.getProperty("user.dir");
	        
			
			if(direcNuevo.contains("src")) {
            	inputScan = new Scanner(new File(direcNuevo + "\\texto.txt"));
            }else {
            	inputScan = new Scanner(new File(direcNuevo + "\\src\\texto.txt"));
            }
			
			while (inputScan.hasNextLine()) {
	            String linea = inputScan.nextLine();
	            String[] tranlatelinea = linea.split(" ");
	            String translatepalabra = "";
	            for (int i = 0; i < tranlatelinea.length; i++) {
	            	palabra = tranlatelinea[i].toLowerCase();
					if(palabra.indexOf(",") > -1) {
						palabra = palabra.substring(0, palabra.indexOf(","));
						translatepalabra = map.get(palabra);
						if (translatepalabra == null) {
							translatepalabra = "*" + palabra+ "*";
						} else {
							translatepalabra = map.get(palabra);
						}
	                } else {
	                	translatepalabra = map.get(palabra);
	                	if (translatepalabra == null) {
	                		translatepalabra = "*" + palabra + "*";
						} else {
							translatepalabra = map.get(palabra);
						}
	                }
					oracion = (oracion + " " + translatepalabra).trim();
				}
	            oracion = oracion + "\n";         
	        }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(oracion); 
	}
	
	/**
	 * Traduccion si lamplementacion de splay tree
	 * @param map
	 */
	public void translateSplay(TInterfaz<String, String> map) {
		Scanner entrada = new Scanner(System.in);
		String palabra = "";
		String oracion = "";
		Scanner inputScan;
		try {
			String direcNuevo = System.getProperty("user.dir");
	        
			if(directorioNuevo.contains("src")) {
            	inputScan = new Scanner(new File(directorioNuevo + "\\texto.txt"));
            }else {
            	inputScan = new Scanner(new File(directorioNuevo + "\\src\\texto.txt"));
            }
			while (inputScan.hasNextLine()) {
	            String linea = inputScan.nextLine();
	            String[] tranlatelinea = linea.split(" ");
	            String translatepalabra = "";
	            for (int i = 0; i < tranlatelinea.length; i++) {
	            	palabra = tranlatelinea[i].toLowerCase();
					if(palabra.indexOf(",") > -1) {
						palabra = palabra.substring(0, palabra.indexOf(","));
						translatepalabra = map.get(palabra);
						if (translatepalabra == null) {
							translatepalabra = "*" + palabra+ "*";
						} else {
							translatepalabra = map.get(palabra);
						}
	                } else {
	                	translatepalabra = map.get(palabra);
	                	if (translatepalabra == null) {
	                		translatepalabra = "*" + palabra + "*";
						} else {
							translatepalabra = map.get(palabra);
						}
	                }
					oracion = (oracion + " " + translatepalabra).trim();
				}
	            oracion = oracion + "\n";         
	        }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(oracion); 
	}
	
}
