package br.com.abimael.saudacao.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.abimael.saudacao.configuration.SaudacaoConfig;
import br.com.abimael.saudacao.model.Saudacao;

@RestController
public class SaudacaoController {
	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private SaudacaoConfig config;

	@RequestMapping("/saudacao")
	public Saudacao greeting(@RequestParam(value = "name", defaultValue = "Mundo") String name) {
		if (name.isEmpty()) {
			name = config.getDefaultValue();
		}
		return new Saudacao(counter.incrementAndGet(), String.format(template, config.getSaudacao(), name));
	}
}
