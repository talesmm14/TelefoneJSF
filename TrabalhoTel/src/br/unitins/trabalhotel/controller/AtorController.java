package br.unitins.trabalhotel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.unitins.trabalhotel.model.Papel;
import br.unitins.trabalhotel.model.Telefone;
import br.unitins.trabalhotel.model.Ator;

@Named
@ApplicationScoped
public class AtorController implements Serializable {

	private static final long serialVersionUID = -8172260296010703261L;

	private Ator ator;
	private Telefone telefone;

	private List<Ator> listaUsuario;
	private List<Telefone> listaTelefone;

	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public Telefone getTelefone() {
		if (telefone == null)
			telefone = new Telefone();
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Ator> getListaUsuario() {
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<Ator>();
			listaTelefone = new ArrayList<Telefone>();
			listaTelefone.add(new Telefone("63", "90239432"));
			listaUsuario.add(new Ator(1, "Joao", "zinho", "Filmasso", Papel.VILAO, listaTelefone));
			listaTelefone = null;
		}
		return listaUsuario;
	}

	public Papel[] getListaPerfil() {
		return Papel.values();
	}

	public Ator getAtor() {
		if (ator == null)
			ator = new Ator();
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public void editar(Ator ator) {
		setAtor((Ator) ator.getClone());
	}

	public void incluir() {
		if ((getTelefone().getDdd() == null || getTelefone().getDdd().trim().equals(""))
				|| (getTelefone().getTelefone() == null || getTelefone().getTelefone().trim().equals(""))) {
			getAtor().getListaTelefones().add(new Telefone(telefone.getDdd(), telefone.getTelefone()));
		}
		getListaUsuario().add(getAtor());
		limpar();
		listaTelefone = null;
		telefone = null;

	}

	public void alterar() {

		// obtendo o indice (posicao da lista)
		int index = getListaUsuario().indexOf(getAtor());
		System.out.println(getAtor().getId());
		if (index != -1) {
			// alterando a posicao da lista com um novo usuario
			getListaUsuario().set(index, getAtor());
			limpar();
		}

	}

	public void excluir() {
		int index = getListaUsuario().indexOf(getAtor());
		getListaUsuario().remove(index);
		if (index != -1)
			limpar();
	}

	public void limpar() {
		ator = null;
		telefone = null;
	}

	public void incluirTelefone() {
		if ((getTelefone().getDdd() == null) || (getTelefone().getTelefone() == null)) {
			return;
		}
		int index = getListaUsuario().indexOf(getAtor());
		getListaUsuario().set(index, getAtor());

		getAtor().getListaTelefones().add(new Telefone(telefone.getDdd(), telefone.getTelefone()));
		if (index != -1) {
			// alterando a posicao da lista com um novo usuario
			getListaUsuario().set(index, getAtor());
			limpar();
		}
		listaTelefone = null;
		telefone = null;
	}
}