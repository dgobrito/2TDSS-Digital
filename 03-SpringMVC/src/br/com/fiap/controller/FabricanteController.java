package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.FabricanteDAO;
import br.com.fiap.model.Fabricante;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteDAO dao;
	
	@GetMapping("cadastrar")
	public ModelAndView abrirForm(){
		return new ModelAndView("fabricante/cadastro")
				.addObject("fabricante", new Fabricante());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(@Valid Fabricante fab, 
			BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()){
			return new ModelAndView("fabricante/cadastro");
		}else{
			dao.cadastrar(fab);
			redirect.addFlashAttribute("msg", "Cadastrado");
			return new ModelAndView("redirect:/fabricante/cadastrar");
		}
	}
	
}




