package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.model.Prato;

@Controller
@RequestMapping("/prato")
public class PratoController {

	//Simular o banco de dados
	private static List<Prato> lista = new ArrayList<>();
	
	@GetMapping("cadastrar")
	public String abrirForm(){
		return "prato/cadastro";
	}
	
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Prato prato){
		lista.add(prato);
		ModelAndView retorno = new ModelAndView("prato/sucesso");
		retorno.addObject("p",prato);
		return retorno;
	}
	
	//Nova ação para listar...
	@GetMapping("listar")
	public ModelAndView listagem(){
		ModelAndView retorno = new ModelAndView("prato/lista");
		retorno.addObject("lista", lista);
		return retorno;
	}
	
}
