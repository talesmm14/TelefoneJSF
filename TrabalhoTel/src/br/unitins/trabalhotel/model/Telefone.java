package br.unitins.trabalhotel.model;

public class Telefone extends DefaultEntity {

	private String ddd;
	private String telefone;

	public Telefone() {

	}

	public Telefone(String ddd, String telefone) {
		super();
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}