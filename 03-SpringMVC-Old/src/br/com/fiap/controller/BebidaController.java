package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dao.BebidaDAO;
import br.com.fiap.model.Bebida;

@Controller
@RequestMapping("/bebida")
public class BebidaController {

	@Autowired //Injeção de dependencia
	private BebidaDAO dao;
	
	@GetMapping("listar")
	public ModelAndView listar(){
		ModelAndView retorno = 
			new ModelAndView("bebida/lista");
		retorno.addObject("bebidas", dao.listar());
		return retorno;
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Bebida bebida){
		dao.cadastrar(bebida);
		ModelAndView retorno = 
				new ModelAndView("bebida/cadastro");
		retorno.addObject("msg","Cadastrado!");
		return retorno;
	}
	
	@GetMapping("cadastrar")
	public String abrirForm(){
		return "bebida/cadastro";
	}
	
}





