package Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Models.Translator;

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
	 * Metodo que combierte el numero romano a numero arabico
	 * @return number Arabic
	 */
	public static int numberArabic(String numberRoman) {
		int valorAnterior = 0;
		int suma = 0;
		// Recorre el n�mero romano de derecha a izquierda
		for (int i = numberRoman.length() - 1; i >= 0; i--) {
			char simbolo = numberRoman.charAt(i);

			// Obtiene el valor decimal del s�mbolo romano
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
	 * @param 
	 * @return boolean valid number Roman
	 */
	public static boolean esSyntaxRomanValid(String numberRoman) {
		
		String backRoman = "";
		char lastCharacter = ' ';
		boolean restI = false;
		boolean restX = false;
		boolean restC = false;
		
		// n�mero m�ximo de repeticiones permitidas
		Map<Character, Integer> symbolReps = new HashMap<>();
		symbolReps.put('I', 3);
		symbolReps.put('V', 1);
		symbolReps.put('X', 3);
		symbolReps.put('L', 1);
		symbolReps.put('C', 3);
		symbolReps.put('D', 1);
		symbolReps.put('M', 3);		

		// Recorre el n�mero romano
		for (int i = numberRoman.length() - 1; i >= 0; i--) {
			char symbol = numberRoman.charAt(i);
			// Verifica si la letra es v�lida
			if (!symbolReps.containsKey(symbol)) {
				return false;
			}
			
			// Verifica si se excede el n�mero m�ximo de repeticiones permitidas
			if (symbol == lastCharacter) {
				if (symbolReps.get(symbol) < 1) {
					return false;
				}
			} else {
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
	 * @param data
	 * @param traslator
	 * @return
	 */
	public static String valueData(String data, Translator traslator) {
		Map<String, Character> symbols = traslator.getSymbol();
		Map<String, Double> valueMetals = traslator.getValueMetals();
		int arabic = 0;
		String[] result;
		Double valMetal=0.0;;
		String[] text;		
		String roman = "";
		
		if(data.substring(0, 10).equalsIgnoreCase("Cu�nto es ") ) {								
			 text = data.split("Cu�nto es ");			
		}else if( data.substring(0, 23).equalsIgnoreCase("Cu�ntos cr�ditos tiene ") ) {			
			text = data.split("Cu�ntos cr�ditos tiene ");
		}else{
			text = data.split(data);
		}					
		
		result = text[1].split(" ");
		
		for(String str: result) {
			if(symbols.containsKey(str)) {
				roman += symbols.get(str);
			}else
			if(valueMetals.containsKey(str)) {
				valMetal = valueMetals.get(str);
			}			
		}
		arabic = numberArabic(roman);
		valMetal *= arabic; 
		if(valMetal>0) {
			return Arrays.toString(result) + " cuesta "+ valMetal + " cr�ditos";
		}else {
			return Arrays.toString(result) + " es " + arabic;
		}
	}
	
}
