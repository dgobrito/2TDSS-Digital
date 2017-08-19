package br.com.fiap.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.DBException;

@ManagedBean
@SessionScoped
public class ClienteBean {

	private Cliente cliente;
	
	private ClienteBO bo;
	
	public String abrirCadastro(){
		criaCliente();
		return "cliente?faces-redirect=true";
	}
	
	@PostConstruct
	private void init(){
		//Inicializando os objetos
		criaCliente();
		bo = new ClienteBO();
	}

	private void criaCliente() {
		cliente = new Cliente();
		cliente.setDataNascimento(Calendar.getInstance());
	}
	
	public StreamedContent getFoto(){
		DefaultStreamedContent content = new DefaultStreamedContent();
		content.setContentType("image/jpg");
		
		try {
			if (FacesContext.getCurrentInstance().getRenderResponse() ||
					cliente.getFoto() == null){
				content.setStream(new FileInputStream("C:\\arquivos\\foto.jpg"));
			}else{
				//content.setStream(
				//	new FileInputStream("C:\\arquivos\\" + cliente.getFoto()));
				content.setStream(
					new ByteArrayInputStream(cliente.getFoto()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return content;
	}
	
	public void subir(FileUploadEvent event){
		cliente.setFoto(event.getFile().getContents());
		//Grava a foto no disco do servidor
		/*try {
			//recuperar o nome do arquivo
			String nome = event.getFile().getFileName();
			//Cria o arquivo
			File file = new File("C:\\arquivos\\", nome);
			//Escreve o conteudo no arquivo
			FileOutputStream stream = new FileOutputStream(file);
			stream.write(event.getFile().getContents());
			stream.close();
			//Coloca o nome do arquivo no cliente 
			cliente.setFoto(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			if (cliente.getCodigo() == 0){
				bo.cadastrar(cliente);
				msg = new FacesMessage("Cadastrado!");
			}else{
				bo.atualizar(cliente);
				msg = new FacesMessage("Atualizado!");
			}
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro..");
		}
		criaCliente();
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
								.getFlash().setKeepMessages(true);
		return "cliente?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
