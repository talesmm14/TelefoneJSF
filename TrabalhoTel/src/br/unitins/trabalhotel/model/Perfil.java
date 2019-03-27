package br.unitins.trabalhotel.model;

public enum Perfil {
	
	ADMINISTRADOR(1, "Administrador"), 
	GERENTE(2, "Gerente"), 
	CLIENTE(3, "Cliente"), 
	FUNCIONARIO(4, "Funcionário");

	private int value;
	private String label;
	
	Perfil(int value, String label) {
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