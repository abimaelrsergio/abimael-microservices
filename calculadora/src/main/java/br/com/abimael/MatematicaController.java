package br.com.abimael;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.abimael.exception.OperacaoMatematicaNaoSuportadaException;
import br.com.abimael.service.MatematicaService;
import br.com.abimael.service.ValidadorService;

@RestController
public class MatematicaController {

	@Autowired
	private MatematicaService matematicaService;
	@Autowired
	private ValidadorService validadorService;

	@GetMapping("/media/{primeiroNumero}/{segundoNumero}")
	public Double media(@PathVariable("primeiroNumero") String primeiroNumero,
			@PathVariable("segundoNumero") String segundoNumero) throws Exception {
		if (!validadorService.isNumeric(primeiroNumero) || !validadorService.isNumeric(segundoNumero)) {
			throw new OperacaoMatematicaNaoSuportadaException("Só aceita valores numéricos");
		}
		return matematicaService.calcularMedia(primeiroNumero, segundoNumero);
	}

	@GetMapping("/raiz/{numero}")
	public Double raiz(@PathVariable("numero") String numero) throws Exception {
		if (!validadorService.isNumeric(numero)) {
			throw new OperacaoMatematicaNaoSuportadaException("Só aceita valores numéricos");
		}
		return matematicaService.calcularRaiz(numero);
	}

	@GetMapping("/multiplicar/{primeiroNumero}/{segundoNumero}")
	public Double multiplicar(@PathVariable("primeiroNumero") String primeiroNumero,
			@PathVariable("segundoNumero") String segundoNumero) throws Exception {
		if (!validadorService.isNumeric(primeiroNumero) || !validadorService.isNumeric(segundoNumero)) {
			throw new OperacaoMatematicaNaoSuportadaException("Só aceita valores numéricos");
		}
		return matematicaService.multiplicar(primeiroNumero, segundoNumero);
	}

	@GetMapping("/dividir/{primeiroNumero}/{segundoNumero}")
	public Double dividir(@PathVariable("primeiroNumero") String primeiroNumero,
			@PathVariable("segundoNumero") String segundoNumero) throws Exception {
		if (!validadorService.isNumeric(primeiroNumero) || !validadorService.isNumeric(segundoNumero)) {
			throw new OperacaoMatematicaNaoSuportadaException("Só aceita valores numéricos");
		}
		return matematicaService.dividir(primeiroNumero, segundoNumero);
	}

	@GetMapping("/subtrair/{primeiroNumero}/{segundoNumero}")
	public Double subtrair(@PathVariable("primeiroNumero") String primeiroNumero,
			@PathVariable("segundoNumero") String segundoNumero) throws Exception {
		if (!validadorService.isNumeric(primeiroNumero) || !validadorService.isNumeric(segundoNumero)) {
			throw new OperacaoMatematicaNaoSuportadaException("Só aceita valores numéricos");
		}
		return matematicaService.subtrair(primeiroNumero, segundoNumero);
	}

	@GetMapping("/somar/{primeiroNumero}/{segundoNumero}")
	public Double somar(@PathVariable("primeiroNumero") String primeiroNumero,
			@PathVariable("segundoNumero") String segundoNumero) throws Exception {
		if (!validadorService.isNumeric(primeiroNumero) || !validadorService.isNumeric(segundoNumero)) {
			throw new OperacaoMatematicaNaoSuportadaException("Só aceita valores numéricos");
		}
		return matematicaService.somar(primeiroNumero, segundoNumero);
	}
}
