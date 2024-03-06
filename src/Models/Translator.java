package Models;

import java.util.HashMap;
import java.util.Map;

public class Translator {

	private Map<String, Character> symbols;

	private Map<String, Double> valueMetals;

	public Translator() {
		symbols = new HashMap<>();
		valueMetals = new HashMap<>();
	}

	/**
	 * @param
	 * @return captura los datos de forma guiada, paso a paso
	 */
	public Translator(Map<String, Character> symbols, Map<String, Double> valueMetals) {
		this.symbols = symbols;
		this.valueMetals = valueMetals;
	}

	public Map<String, Character> getSymbol() {
		return symbols;
	}

	public void setSymbol(String text, Character symbol) {
		this.symbols.put(text, symbol);
	}

	public Map<String, Double> getValueMetals() {
		return valueMetals;
	}

	public void setValueMetals(String name, Double value) {
		this.valueMetals.put(name, value);
	}

}
