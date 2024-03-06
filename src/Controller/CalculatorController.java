package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Models.Translator;
import Utils.Calculator;

public class CalculatorController extends TranslateController{

	
	
	/**
	 * Define el diccionario del traductor
	 */
	private static void romanCalculator() {
		System.out.println("para insertar el test de numeros romanos escriba ok, para terminar escriba exit");
		Scanner scanner = new Scanner(System.in);
        List<String> numberRomans = new ArrayList<>();
        String romanText;
        do {
	        System.out.println("Introduzca el número Romano: ");
	        
	        romanText = scanner.next();
	
	        if(romanText.equalsIgnoreCase("ok")) {
	        	numberRomans = romanTestList();
	        	break;
	        }else {
	        	numberRomans.add(romanText);
	        }
        }while(romanText == "exit");
        
        for (String numberRoman : numberRomans) {

			if (Calculator.esSyntaxRomanValid(numberRoman)) {
				 System.out.println(numberRoman + " tiene una sintaxis válida. " + "El número es: " + Calculator.numberArabic(numberRoman));
			} else {
				System.out.println(numberRoman + " no tiene una sintaxis válida.");
			}
		}
    }
	
	/**
	 * Datos de prueba de validacion de los numeros romanos
	 */
	public static List<String> romanTestList(){
		return new ArrayList<>(Arrays.asList(
				"MCMIII", "VIX", "MIMIII", "MDM", "VL", "LD", "DIII", "MMDIII", "II", "III", "III", "V", "VI", "VII", "VIII",
				"VIII", "X", "XI", "XII", "XIII", "XIII", "XV", "XVI", "XVII", "XVIII", "XVIII", "XX", "XXI", "XXII",
				"XXIII", "XXIII", "XXV", "XXVI", "XXVII", "XXVIII", "XXVIII", "XXX", "XXXI", "XXXII", "XXXIII",
				"XXXIII", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXVIII", "XL", "XLI", "XLII", "XLIII", "XLIII", "XLV",
				"XLVI", "XLVII", "XLVIII", "XXXXVII", "L", "LI", "LII", "LIII", "LIIII", "LV", "LVI", "LVII", "LVIII",
				"LVII", "LX", "LXI", "LXII", "LXIII", "LXII", "LXV", "LXVI", "LXVII", "LXVIII", "LXVII", "LXX", "LXXI",
				"LXXII", "LXXIII", "", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXVIII", "LXXX", "LXXXI", "LXXXII",
				"LXXXIII", "LXXXII", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXVII", "XC", "XCI", "XCII", "XCIII",
				"XCIII", "XCV", "XCVI", "XCVII", "XCVIII", "XCVII", "C"
		));
	}
	/************ main *****************/
	
	public static void main(String[] args) {
		Translator t = dictionaryTest(); 
		Scanner scanner = new Scanner(System.in);
		
		int opcion;
		do {
			System.out.println();
            System.out.println("----------------------- Menú ----------------------");
            System.out.println("1. Insertar Diccionario");
            System.out.println("2. Traducir Texto");
            System.out.println("3. Insertar Diccionario Script");
            System.out.println("4. Calcular número romano");
            System.out.println("5. Salir");
            System.out.println();
            System.out.print("Introduzca una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	t = readDataTypeGuided();
                	System.out.println();
                    break;
                case 2:
					translateText(t);
                	System.out.println();
                    break;
                case 3:
                	t = readDataTypeScript();
                	System.out.println();
                    break;
                case 4:
                	romanCalculator();
                	System.out.println();
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción no válida. Introduzca un número entre 1 y 5.");
                    System.out.println();
            }
        } while (opcion != 5);

	}
}
