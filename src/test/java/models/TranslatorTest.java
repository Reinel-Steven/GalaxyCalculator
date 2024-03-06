package models;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TranslatorTest {

	@Test
	void test() {
		Translator translator;
		
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

		translator = new Translator(symbols, valueMetals);
		
		Assertions.assertEquals("I", translator.getSymbol().get("glob").toString());
		Assertions.assertEquals("V", translator.getSymbol().get("prok").toString());
		Assertions.assertEquals("X", translator.getSymbol().get("pish").toString());
		Assertions.assertEquals("L", translator.getSymbol().get("tegj").toString());
	}
}
