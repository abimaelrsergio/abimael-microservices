package br.com.abimael.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.abimael.resource.CambioResource;

@FeignClient(name = "cambio-service", url = "localhost:8000")
public interface CambioProxy {

	@GetMapping(value = "/cambio-service/{valor}/{from}/{to}")
	public CambioResource getCambio(@PathVariable("valor") Double valor, @PathVariable("from") String from,
			@PathVariable("to") String to);
}
