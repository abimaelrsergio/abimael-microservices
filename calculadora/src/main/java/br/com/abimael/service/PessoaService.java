package br.com.abimael.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.abimael.model.Pessoa;

@Service
public class PessoaService {

	private final AtomicLong counter = new AtomicLong();

	public Pessoa findById(String id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setPrimeiroNome("Abimel");
		pessoa.setUltimoNome("Sergio");
		pessoa.setSexo("Masculino");
		pessoa.setEndereco("São Paulo - SP");
		return pessoa;
	}

	public List<Pessoa> findAll() {
		List<Pessoa> pessoas = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Pessoa pessoa = mockPessoa(i);
			pessoas.add(pessoa);
		}
		return pessoas;
	}

	private Pessoa mockPessoa(int id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setPrimeiroNome("Abimel" + id);
		pessoa.setUltimoNome("Sergio" + id);
		pessoa.setSexo("Masculino");
		pessoa.setEndereco("São Paulo - SP");
		return pessoa;
	}

}
