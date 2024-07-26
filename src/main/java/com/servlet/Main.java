package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	RequestDispatcher dispacher = null;
    	
    	//DEFINICION DEL ABECEDARIO
    	String letters = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int alphSize = letters.length();
		System.out.println("LETTERS SIZE: " + alphSize);
		
		//INGRESO DE DATOS
    	String textOrigin = request.getParameter("textOrigin");
    	//CALCULO DE PALABRAS
    	int wordCount = textOrigin.split("\\s+|\n|,").length;
    	System.out.println("WORDS SIZE: " + wordCount);
    	
    	//VALIDAMOS LOS DATOS DE ENTRADA QUE SEAN MAYOR A 100 PALABRAS
    	if (wordCount < 100) {
    		//ERROR EN CASO DE SER MENOR A 100
    		dispacher = request.getRequestDispatcher("error.jsp");
        	dispacher.forward(request, response);
    	} else {
    		//SI ES MAYOR A 100
    		textOrigin = textOrigin.toUpperCase();
    		int textSize = textOrigin.length();
    		System.out.println("TEXT: " + textOrigin);
    		System.out.println("TEXT SIZE: " + textSize);
    		char alphabet[] = new char[alphSize];
    		int frequency[] = new int[alphSize];
    		
    		//CALCULO CARACTERES
    		char c = 'A';
    		for (int i = 0; i < alphSize; i++) {
    			System.out.println("LETTER: " + c + " -> " + i);
    			alphabet[i] = c;
    			frequency[i] = 0;
    			//VALIDACION PARA AGREGAR Ñ EN MAPEO
    			if (i == 13) {
    				c = 'Ñ';
    			} else if (i == 14) {
    				//REGRESO EL VALOR DEL CHAR A LA SIGUIENTE LETRA DESPUES DE Ñ
    				c = 'O';
    			} else {
    				c++;
    			}
    		}
    		
            //CÁLCULO DE LA FRECUENCIA
            char ch = 'A';
            for (int i = 0; i < alphSize; i++) {
            	for (int j = 0; j < textSize; j++) {
            		ch = textOrigin.charAt(j);
            		if (ch == alphabet[i]) {
            			frequency[i]++;
            		}
            	}
            }
            
            System.out.println("OUTPUT:");
            System.out.println("==========================");
            System.out.println("ALPHABET\tFREQUENCY");
            System.out.println("==========================");
            
            Map<String, Integer> newMap = new HashMap<String, Integer>();
            //IMPRIMO CON FORMATO EL MAPA
            for (int i = 0; i < alphSize; i++) {
            	if (frequency[i] != 0) {
            		int d = frequency[i];
    				newMap.put(String.valueOf(alphabet[i]), d);
            		System.out.println(" " + alphabet[i] + "\t\t   " + frequency[i]);
            	}
            }
            
            //CALCULO LA FRECUENCIA MAYOR DEL MAPA
            int mayor = frequency[0];
            int indiceMayorFreq = 0;
            char letra = 0;
            for (int x = 1; x < frequency.length; x++) {
    			if (frequency[x] > mayor) {
    				mayor = frequency[x];
    				letra = alphabet[x];
    				indiceMayorFreq = x;
    			}
    		}
            
            int intIndex = letters.indexOf(letra);
        	
            //DATOS INGRESADOS PARA EVALUAR
            //TABLA DE FRECUENCIA
            Map<String, Double> map = new HashMap<String, Double>();
    		map.put("A", 12.53);map.put("B", 1.42);map.put("C", 4.68);
    		map.put("D", 5.86);map.put("E", 13.68);map.put("F", 0.69);
    		map.put("G", 1.01);map.put("H", 0.70);map.put("I", 6.25);
    		map.put("J", 0.44);map.put("K", 0.02);map.put("L", 4.97);
    		map.put("M", 3.15);map.put("N", 6.71);map.put("Ñ", 0.31);
    		map.put("O", 8.68);map.put("P", 2.51);map.put("Q", 0.88);
    		map.put("R", 6.87);map.put("S", 7.98);map.put("T", 4.63);
    		map.put("U", 3.93);map.put("V", 0.90);map.put("W", 0.01);
    		map.put("X", 0.22);map.put("Y", 0.90);map.put("Z", 0.52);
            
    		double valorMax = -1;
    		String key = "";
    		
    		//DEL DICCIONARIO OBTENGO EL VALOR CON MAYOR PORCENTAJE
    		for (Map.Entry<String, Double> entry : map.entrySet()) {
    			final double valorActual = entry.getValue();
    			String keyItem = entry.getKey();
    			if(valorActual > valorMax) {					
    				valorMax = valorActual;
    				key = keyItem; 
    			}
    		}
    		//CREO EL ABECEDARIO EN TIPO ARRAY PARA SACAR VALOR VAR = letters
    		int indexAbecedario = letters.indexOf(key);
    		System.out.println("indexAbecedario: " + indexAbecedario);
    		System.out.println("indiceMayorFreq: " + indiceMayorFreq);
    		int transformacion = 0;
    		//CALCULO LA DIFERENCIA PARA OBTENER RESULTADO
    		if (indiceMayorFreq < indexAbecedario) {
    			indiceMayorFreq = (indiceMayorFreq + 1) + 26;
    			transformacion = indiceMayorFreq - indexAbecedario;
    			intIndex = (indiceMayorFreq + 1) + 26;
    		} else {
	    		transformacion = indiceMayorFreq - indexAbecedario;
    		}
    		System.out.println("transformacion: " + transformacion);
    		
    		//RESULTADOS
    		String result = "";
    		System.out.println("INDICE: " + intIndex);
    		System.out.println("TEXTO DECODIFICADO");
    		    		
            for (int x = 1; x <= intIndex; x++) {
            	if (x == transformacion) {
            		System.out.println(decodificar(textOrigin.toUpperCase(), transformacion));
            		result += decodificar(textOrigin.toUpperCase(), x) + "/";
            	}
    		}
            System.out.println("==========================");
    		
    		session.setAttribute("map", map.entrySet());
    		session.setAttribute("letterMaxFreq", key);
    		session.setAttribute("indexAbecedario", indexAbecedario + 1);
    		session.setAttribute("perMaxFreq", valorMax);
            
        	session.setAttribute("textOrigin", textOrigin);
        	session.setAttribute("wordCount", wordCount);
        	session.setAttribute("newMap", newMap.entrySet());
        	session.setAttribute("mayor", mayor);
        	session.setAttribute("letra", letra);
        	session.setAttribute("indiceMayorFreq", indiceMayorFreq + 1);
        	session.setAttribute("intIndex", intIndex);
        	
        	session.setAttribute("transformacion", transformacion);
        	
        	session.setAttribute("result", result);
        	request.setAttribute("result2", result);
        	
        	dispacher = request.getRequestDispatcher("result.jsp");
        	dispacher.forward(request, response);
    	}
	}
    
    public static String decodificar(String texto, int tr) {
		String textoCodificado = "";
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		texto = texto.toUpperCase();
		char caracter;
		for (int i = 0; i < texto.length(); i++) {
			caracter = texto.charAt(i);
			int pos = letras.indexOf(caracter);
			if (pos == -1) {
				textoCodificado += caracter;
			} else {
				if (pos - tr < 0) {
					textoCodificado += letras.charAt(letras.length() + (pos - tr));
				} else {					
					textoCodificado += letras.charAt((pos - tr) % letras.length());
				}
			}
		}
		return textoCodificado.toString();
	}

}
