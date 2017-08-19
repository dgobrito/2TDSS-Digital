package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AtletaController {

	@RequestMapping("atleta/cadastro") //URL
	public String abrirForm(){
		return "atleta/form"; //página
	}
	
	@RequestMapping(value="atleta/cadastrar",
								method=RequestMethod.POST)
	public String processaForm(String nome, 
							float peso, float altura){
		System.out.println(nome + " " + peso + " " + altura);
		return "atleta/sucesso";
	}
	
}




