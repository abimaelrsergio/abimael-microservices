package br.com.abimael.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abimael.model.Livro;
import br.com.abimael.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findLivro(Long id, String moeda) {
		var livro = repository.getById(id);
		if (livro == null) {
			throw new RuntimeException("Livro não encontrado");
		}
		return livro;
	}

}
