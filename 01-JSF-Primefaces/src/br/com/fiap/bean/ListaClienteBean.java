package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.entity.Cliente;

@ManagedBean
public class ListaClienteBean {

	private List<Cliente> lista;
	
	private ClienteBO bo;
	
	private String nome;
	
	public void buscar(){
		lista = bo.buscarPorNome(nome);
	}
	
	@PostConstruct
	private void init(){
		bo = new ClienteBO();
		lista = bo.listar();
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
