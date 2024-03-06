package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Models.Translator;
import Utils.Calculator;

public class TranslateController {
	
	/**
	 * Este metodo esta en desarrollo 
	 * Temporalmente es sustituido por  @dictionaryTest()
	 */
	public static Translator readDataTypeScript() {
		return dictionaryTest();
	}
	/**
	 * Lee los datos que funcionaran como diccionario 
	 */
	public static Translator readDataTypeGuided() {
		Map<String, Character> symbols = new HashMap<>();
		Map<String, Double> valueMetals = new HashMap<>();
		System.out.println("Para insertar diccionario test esciba ok de lo contrario escriba no");
		Scanner readtext = new Scanner (System.in);
		String text = readtext.next();	
		if(text.equalsIgnoreCase("ok")) {
			return dictionaryTest();
		}
		Character[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		for(Character c : roman) {// I, V, X, L, C, D, M
			System.out.println("Ingrese la traduccion de " + c + ": ");
			
				text = readtext.next();		
				symbols.put(text, c);
							
		
		}
		String[] metals = {"Gold", "Silver", "Iron"};
		for(String str : metals) {// I, V, X, L, C, D, M
			System.out.println("Ingrese el valor de " + str + ": ");
			try {
				Double textDoble = readtext.nextDouble();		
				valueMetals.put(str, textDoble);											
			}catch (Exception e) {
				System.out.println("Debe ser numerico");				
			}			
		}
		System.out.println(symbols);
		System.out.println(valueMetals);
		
		return new Translator(symbols, valueMetals);
	}
	
	/**
	 * Lee la cadena de texto que se pretende traducir 
	 */
	public static List<String> readTextToTranslate() {
		List<String> result = new ArrayList<>();
		System.out.println("para salir escriba exit");
		System.out.println("para insertar ejemplos escriba 'ok'");
		System.out.println("Cuánto es pish tegj glob glob");
		System.out.println("Cuántos créditos tiene Glob Prok Silver");
		System.out.println("Cuántos créditos tiene Glob Prok Gold");
		System.out.println("Cuántos créditos tiene Glob Prok Iron");
		String str = "";
		int cont = 0;
		do { 			
			System.out.println("Ingrese el texto a traducir");
			Scanner readtext = new Scanner (System.in);
			
			str = readtext.nextLine();
			
			if(str.equalsIgnoreCase("ok")) {
				result = textToTranslateTest();
				break;
			}
			if(str.length()>10 ) {
				if(str.substring(0, 10).equalsIgnoreCase("Cuánto es ") ) {								
					result.add(str);
				}else if( str.substring(0, 23).equalsIgnoreCase("Cuántos créditos tiene ") ) {			
					result.add(str);
				}else{
					result.add(str);
				}								
			}else{
				if(str.equalsIgnoreCase("exit")) {
					System.out.println("exit ok");
				}else {
					System.out.println("texto incompleto");
				}
				
			}
			cont++;
		}while(!str.equalsIgnoreCase("exit"));	
		
		
		return result;
	}
	/**
	 * 
	 * metodo para ejecutar el traductor 
	 */
	public static void translateText(Translator t ) {
		List<String> data = readTextToTranslate();		
		for(String str : data) {
			System.out.println(Calculator.valueData(str, t));
		}
	}
	/**
	 * datos de prueba para el traductor
	 */
	public static List<String> textToTranslateTest() {
		List<String> result = new ArrayList<>();
		result.add("Cuánto es pish tegj glob glob");
		result.add("Cuántos créditos tiene glob prok Silver");
		result.add("Cuántos créditos tiene glob prok Gold");
		result.add("Cuántos créditos tiene glob prok Iron");
		
		return result;
	}
	
	/**
	 * datos de prueba para el diccionario 
	 */
		public static Translator dictionaryTest() {
			Map<String, Character> symbols = new HashMap<>();
			Map<String, Double> valueMetals = new HashMap<>();
			
			symbols.put("glob", 'I');
			symbols.put("prok", 'V');
			symbols.put("pish", 'X');
			symbols.put("tegj", 'L');
			symbols.put("naC", 'C');
			symbols.put("naD", 'D');
			symbols.put("naM", 'M');
			
			valueMetals.put("Silver", 12.0);
			valueMetals.put("Gold", 14450.0);
			valueMetals.put("Iron", 195.5);
			
			System.out.println(symbols);
			System.out.println(valueMetals);
			
			return new Translator(symbols, valueMetals);
		}
}
