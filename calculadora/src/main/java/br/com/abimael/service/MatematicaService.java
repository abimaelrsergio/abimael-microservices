package br.com.abimael.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatematicaService {

	@Autowired
	private ConversorService conversorService;

	public Double calcularMedia(String primeiroNumero, String segundoNumero) {
		return (conversorService.convertToDouble(primeiroNumero) + conversorService.convertToDouble(segundoNumero)) / 2;
	}

	public Double calcularRaiz(String numero) {
		return Math.sqrt(conversorService.convertToDouble(numero));
	}

	public Double multiplicar(String primeiroNumero, String segundoNumero) {
		return conversorService.convertToDouble(primeiroNumero) * conversorService.convertToDouble(segundoNumero);
	}

	public Double dividir(String primeiroNumero, String segundoNumero) {
		return conversorService.convertToDouble(primeiroNumero) / conversorService.convertToDouble(segundoNumero);
	}

	public Double subtrair(String primeiroNumero, String segundoNumero) {
		return conversorService.convertToDouble(primeiroNumero) - conversorService.convertToDouble(segundoNumero);
	}

	public Double somar(String primeiroNumero, String segundoNumero) {
		return conversorService.convertToDouble(primeiroNumero) + conversorService.convertToDouble(segundoNumero);
	}

}
