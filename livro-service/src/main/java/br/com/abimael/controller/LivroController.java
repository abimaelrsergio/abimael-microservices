package br.com.abimael.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abimael.mapper.LivroMapper;
import br.com.abimael.resource.LivroResource;
import br.com.abimael.service.LivroService;

@RestController
@RequestMapping("livro-service")
public class LivroController {

	@Autowired
	private LivroService service;

	@Autowired
	private LivroMapper mapper;

	@Autowired
	private Environment environment;

	@GetMapping(value = "/{id}/{moeda}")
	public LivroResource findLivro(@PathVariable("id") Long id, @PathVariable("moeda") String moeda) {
		var livro = service.findLivro(id, moeda);
		LivroResource livroResource = mapper.livroToLivroResource(livro);
		adicionarPorta(livroResource);
		return livroResource;
	}

	private void adicionarPorta(LivroResource livroResource) {
		var porta = environment.getProperty("local.server.port");
		livroResource.setAmbiente(porta + " FEIGN");
	}

}
