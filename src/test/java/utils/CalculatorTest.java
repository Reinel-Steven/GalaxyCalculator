package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import controller.TranslateController;
import models.Translator;

public class CalculatorTest {
	
	@Test
	void testIsSyntaxRomanValid() {
		List<String> listRomanTrue = new ArrayList<>(Arrays.asList(
				"MCMIII", "L", "LI", "LII", "LIII", "LV", "LVI", "LVII", "LVIII",
				"LVII", "LX", "LXI", "LXII", "LXIII", "LXII", "LXV", "LXVI", "LXVII", "LXVIII", "LXVII", "LXX", "LXXI",
				"LXXII", "LXXIII", "", "LXXV", "LXXVI", "LXXVII"
		));
		for(String roman : listRomanTrue) {
			boolean isRoman = Calculator.esSyntaxRomanValid(roman);
			Assertions.assertEquals(true, isRoman);
		}
		
		List<String> listRomanFalse = new ArrayList<>(Arrays.asList(
				"VIX", "MIMIII", "MDM", "VL", "LD", "XXXXVII", "LIIII", "VIX"
		));
		for(String roman : listRomanFalse) {
			boolean isRoman = Calculator.esSyntaxRomanValid(roman);
			Assertions.assertEquals(false, isRoman);
		}
		
	}
	
	@Test
	void testNumberRoman() {
		List<String> listRoman = new ArrayList<>(Arrays.asList(				
				"LVII", "LX", "LXI", "LXXII", "LXIII", "LXII", "LXV", "LXVII", "LXXXVIII", "CXVII", "MXX", "MDXXI"
		));
		List<Integer> listArabic = new ArrayList<>(Arrays.asList(				
				57, 60, 61, 72, 63, 62, 65,  67, 88, 117, 1020, 1521
		));
		for(String roman : listRoman) {
			int res =  Calculator.numberArabic(roman);
			Assertions.assertEquals(listArabic.get(listRoman.indexOf(roman)), res);
		}
		
	}
	
	@Test
	void testValueData() {
		List<String> data = TranslateController.textToTranslateTest();
		Translator t = TranslateController.dictionaryTest();
		
		List<String> expected = new ArrayList<>();
		expected.add("pish tegj glob glob es 42");
		expected.add("glob prok Silver cuesta 48.0 créditos");
		expected.add("glob prok Gold cuesta 57800.0 créditos");
		expected.add("No entendi el mensaje -> HelloWorld");
		expected.add("glob prok Iron cuesta 782.0 créditos");
		expected.add("No entendi el mensaje -> Cuánta madera podría arrojar una marmota si una marmota pudiera arrojar madera");
		
		for(String exp : expected ) {			
			String real = data.get(expected.indexOf(exp));
			Assertions.assertEquals(exp, Calculator.valueData(real, t));
		}
		
		
	}
}
