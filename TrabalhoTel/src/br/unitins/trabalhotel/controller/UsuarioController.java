package br.unitins.trabalhotel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.unitins.trabalhotel.application.Util;
import br.unitins.trabalhotel.model.Perfil;
import br.unitins.trabalhotel.model.Telefone;
import br.unitins.trabalhotel.model.Usuario;

@Named
@ApplicationScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -8172260296010703261L;
	
	private Usuario usuario;
	private Telefone telefone;
	
	private List<Usuario> listaUsuario;
	private List<Telefone> listaTelefone;
	
	
	public Telefone getTelefone() {
		if (telefone == null)
			telefone = new Telefone();
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
			listaTelefone.add(new Telefone("63","90239432"));
			listaUsuario.add(new Usuario(1, "Joao", "joao", "123", Perfil.FUNCIONARIO,listaTelefone));;
		}
		return listaUsuario;
	}
	
	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void editar(Usuario usuario) {
		setUsuario((Usuario)usuario.getClone());
	}
	
	public void incluir() {
		// validacao de senha no servidor
		if (getUsuario().getSenha() == null || 
			getUsuario().getSenha().trim().equals("") ) {
			Util.addMessageError("A senha deve ser informada.");
			return;
		}
		listaTelefone.add(new Telefone(telefone.getDdd(),telefone.getTelefone()));
		getListaUsuario().add(getUsuario());
		limpar();
	}
	
	public void alterar() {	
		// validacao de senha no servidor
		if (getUsuario().getSenha() == null || 
				getUsuario().getSenha().trim().equals("") ) {
				Util.addMessageError("A senha deve ser informada.");
				return;
		}
		
		// obtendo o indice (posicao da lista)
		int index = getListaUsuario().indexOf(getUsuario());
		System.out.println(getUsuario().getId());
		if (index != -1) {
			// alterando a posicao da lista com um novo usuario
			getListaUsuario().set(index, getUsuario());
			limpar();
		}
			
	}
	
	public void excluir() {
		int index = getListaUsuario().indexOf(getUsuario());
		getListaUsuario().remove(index);
		if (index != -1)
			limpar();
	}
	
	public void limpar() {
		usuario = null;
		telefone = null;
	}
	
	public void incluirTelefone() {
		listaTelefone.add(new Telefone(telefone.getDdd(),telefone.getTelefone()));
	}
}