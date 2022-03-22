package br.com.abimael.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abimael.resource.CambioResource;
import br.com.abimael.service.CambioService;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

	@Autowired
	private CambioService cambioService;

	@GetMapping(value = "/{valor}/{from}/{to}")
	public CambioResource getCambio(@PathVariable("valor") BigDecimal valor, @PathVariable("from") String from, @PathVariable("to") String to) {
		return cambioService.findByFromAndTo(valor, from, to);
	}
}
