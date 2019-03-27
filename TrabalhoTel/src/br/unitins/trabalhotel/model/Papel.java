package br.unitins.trabalhotel.model;

public enum Papel {
	
	PRINCIPAL(1, "Principal"), 
	VILAO(2, "Vilão"), 
	FIGURANTE(3, "Figurante"), 
	SECUNDARIO(4, "Secundario");

	private int value;
	private String label;
	
	Papel(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
}