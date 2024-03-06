package utils;

import java.util.HashMap;
import java.util.Map;

import models.Translator;

public class Calculator {

	private static final Map<Character, Integer> valRoman = new HashMap<>();
	static {
		valRoman.put('I', 1);
		valRoman.put('V', 5);
		valRoman.put('X', 10);
		valRoman.put('L', 50);
		valRoman.put('C', 100);
		valRoman.put('D', 500);
		valRoman.put('M', 1000);
	}

	/**
	 * Metodo que combierte el numero romano a numero Arabic
	 * 
	 * @return number Arabic
	 */
	public static int numberArabic(String numberRoman) {
		int valorAnterior = 0;
		int suma = 0;
		// Recorre el número romano de derecha a izquierda
		for (int i = numberRoman.length() - 1; i >= 0; i--) {
			char simbolo = numberRoman.charAt(i);

			// Obtiene el valor decimal del símbolo romano
			int valor = valRoman.get(simbolo);

			// Verifica si el valor actual es menor que el anterior
			if (valor < valorAnterior) {
				suma -= valor;
			} else {
				suma += valor;
			}
			valorAnterior = valor;
		}
		return suma;
	}

	/**
	 * valida que el string sea un numero romano valido
	 * 
	 * @param
	 * @return boolean valid number Roman
	 */
	public static boolean esSyntaxRomanValid(String numberRoman) {

		String backRoman = "";
		char lastCharacter = ' ';
		int repet = 1;
		boolean restI = false;
		boolean restX = false;
		boolean restC = false;

		// número máximo de repeticiones permitidas
		Map<Character, Integer> symbolReps = new HashMap<>();
		symbolReps.put('I', 4);
		symbolReps.put('V', 1);
		symbolReps.put('X', 4);
		symbolReps.put('L', 1);
		symbolReps.put('C', 4);
		symbolReps.put('D', 1);
		symbolReps.put('M', 4);

		// Recorre el número romano
		for (int i = numberRoman.length() - 1; i >= 0; i--) {
			char symbol = numberRoman.charAt(i);
			// Verifica si la letra es válida
			if (!symbolReps.containsKey(symbol)) {
				return false;
			}

			// Verifica si se excede el número máximo de repeticiones permitidas
			if (symbol == lastCharacter) {
				repet++;
				if (symbolReps.get(symbol) < 1 || repet>3) {
					return false;
				}
			} else {
				repet = 1;
				lastCharacter = symbol;
				if (symbolReps.get(symbol) < 1) {
					return false;
				}
			}
			symbolReps.replace(symbol, symbolReps.get(symbol) - 1);

			// Verifica reglas de resta
			if (i < numberRoman.length() - 1) {
				char nextSymbol = numberRoman.charAt(i + 1);

				if ((symbol == 'V' || symbol == 'L' || symbol == 'D')
						&& valRoman.get(nextSymbol) > valRoman.get(symbol)) {
					return false;
				} else if (valRoman.get(nextSymbol) > valRoman.get(symbol)) {

					if ((restI && symbol == 'I' && (nextSymbol == 'V' || nextSymbol == 'X'))
							|| symbol == 'I' && !(nextSymbol == 'V' || nextSymbol == 'X')) {
						return false;
					} else if ((restX && symbol == 'X' && (nextSymbol == 'L' || nextSymbol == 'C'))
							|| symbol == 'X' && !(nextSymbol == 'L' || nextSymbol == 'C')) {
						return false;
					} else if ((restC && symbol == 'C' && (nextSymbol == 'D' || nextSymbol == 'M'))
							|| symbol == 'C' && !(nextSymbol == 'D' || nextSymbol == 'M')) {
						return false;
					}
				}

				if (!restI && symbol == 'I' && (nextSymbol == 'V' || nextSymbol == 'X')) {
					restI = true;
				} else if (!restX && symbol == 'X' && (nextSymbol == 'L' || nextSymbol == 'C')) {
					restX = true;
				} else if (!restC && symbol == 'C' && (nextSymbol == 'D' || nextSymbol == 'M')) {
					restC = true;
				}

				// verifica que la suma de las ultimas 2 letras no sea mayor a la actual
				if (numberRoman.length() > 2 && i < numberRoman.length() - 2) {
					Character towChar = numberRoman.charAt(i + 2);
					backRoman = String.valueOf(nextSymbol) + String.valueOf(towChar);
					int arabic = numberArabic(backRoman);
					int letra = valRoman.get(numberRoman.charAt(i));
					if (letra < arabic && symbol != nextSymbol && valRoman.get(symbol) >= valRoman.get(nextSymbol)) {
						return false;
					}
				}
			}

		}
		return true;
	}

	/**
	 * evalua la data suministrada y retorna el resultado de la traduccion
	 * 
	 * @param data
	 * @param traslator
	 * @return
	 */
	public static String valueData(String data, Translator traslator) {
		if (data.length() < 11) {
			return "No entendi el mensaje -> " + data;
		}
		Map<String, Character> symbols = traslator.getSymbol();
		Map<String, Double> valueMetals = traslator.getValueMetals();
		int arabic = 0;
		String[] result;
		Double valMetal = 0.0;
		;
		String[] text;
		String roman = "";

		if (data.substring(0, 10).equalsIgnoreCase("Cuánto es ")) {
			text = data.split("Cuánto es ");
		} else if (data.substring(0, 23).equalsIgnoreCase("Cuántos créditos tiene ")) {
			text = data.split("Cuántos créditos tiene ");
		} else {
			data = "-> " + data;
			text = data.split("-> ");
		}

		result = text[1].split(" ");

		for (String str : result) {
			if (symbols.containsKey(str)) {
				roman += symbols.get(str);
			} else if (valueMetals.containsKey(str)) {
				valMetal = valueMetals.get(str);
			} else {
				return "No entendi el mensaje " + data;
			}
		}
		arabic = numberArabic(roman);
		valMetal *= arabic;
		if (valMetal > 0) {
			return data.substring(23) + " cuesta " + valMetal + " créditos";
		} else {
			return data.substring(10) + " es " + arabic;
		}
	}

}
