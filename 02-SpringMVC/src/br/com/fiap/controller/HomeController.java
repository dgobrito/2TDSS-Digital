package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("index") //URL
	public String home(){
		//Página de resposta
		return "home/inicio";
	}
	
}
