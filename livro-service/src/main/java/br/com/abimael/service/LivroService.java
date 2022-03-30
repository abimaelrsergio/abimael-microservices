package br.com.abimael.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.abimael.model.Livro;
import br.com.abimael.repository.LivroRepository;
import br.com.abimael.resource.CambioResource;

@Service
public class LivroService {

	private static final String URL = "http://localhost:8000/cambio-service/{valor}/{de}/{para}";
	@Autowired
	private LivroRepository repository;

	public Livro findLivro(Long id, String moeda) {
		var livro = repository.getById(id);
		if (livro == null) {
			throw new RuntimeException("Livro não encontrado");
		}

		HashMap<String, String> params = new HashMap<>();
		params.put("valor", livro.getPreco().toString());
		params.put("de", "USD");
		params.put("para", moeda);
		var response = new RestTemplate().getForEntity(URL, CambioResource.class, params);
		var cambio = response.getBody();
		livro.setPreco(cambio.getConvertedValue());
		return livro;
	}

}
