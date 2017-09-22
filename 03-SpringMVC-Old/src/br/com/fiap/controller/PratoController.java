package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dao.PratoDAO;
import br.com.fiap.model.Prato;

@Controller
@RequestMapping("/prato")
public class PratoController {

	//Simular o banco de dados
	//private static List<Prato> lista = new ArrayList<>();
	@Autowired
	private PratoDAO dao;
	
	@GetMapping("cadastrar")
	public String abrirForm(){
		return "prato/cadastro";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Prato prato){
		//lista.add(prato);
		dao.cadastrar(prato);
		ModelAndView retorno = new ModelAndView("prato/sucesso");
		retorno.addObject("p",prato);
		return retorno;
	}
	
	//Nova ação para listar...
	@GetMapping("listar")
	public ModelAndView listagem(){
		ModelAndView retorno = new ModelAndView("prato/lista");
		retorno.addObject("lista", dao.listar());
		return retorno;
	}
	
}
