package br.com.abimael.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abimael.model.Livro;

@RestController
@RequestMapping("livro-service")
public class LivroController {

	@Autowired
	private Environment environment;

	@GetMapping(value = "/{id}/{moeda}")
	public Livro findLivro(@PathVariable("id") Long id, @PathVariable("moeda") String moeda) {
		var porta = environment.getProperty("local.server.port");
		return new Livro(id, "Abimael", "livro 1", new Date(), Double.valueOf(150), moeda, porta);
	}

}
