package br.unitins.trabalhotel.model;

import java.util.ArrayList;
import java.util.List;

public class Ator extends DefaultEntity {

	private String nome;
	private String sobrenome;
	private String filme;
	private Papel papel;
	private List<Telefone> listaTelefones;

	public List<Telefone> getListaTelefones() {
		if (listaTelefones == null) {
			listaTelefones = new ArrayList<Telefone>();
		}
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public Ator() {

	}

	public Ator(Integer id, String nome, String sobrenome, String filme, Papel papel, List<Telefone> listaTelefones) {
		super();
		setId(id);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.filme = filme;
		this.papel = papel;
		this.listaTelefones = listaTelefones;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	public Papel getPerfil() {
		return papel;
	}

	public void setPerfil(Papel papel) {
		this.papel = papel;
	}
	
	
}