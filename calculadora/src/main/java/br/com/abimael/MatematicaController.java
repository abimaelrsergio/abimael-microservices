package br.com.abimael;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.abimael.exception.OperacaoMatematicaNaoSuportadaException;

@RestController
public class MatematicaController {

	@GetMapping("/somar/{primeiroNumero}/{segundoNumero}")
	public Double somar(@PathVariable("primeiroNumero") String primeiroNumero,
			@PathVariable("segundoNumero") String segundoNumero) throws Exception {
		if (!isNumeric(primeiroNumero) || !isNumeric(segundoNumero)) {
			throw new OperacaoMatematicaNaoSuportadaException("Só aceita valores numéricos");
		}
		Double sum = convertToDouble(primeiroNumero) + convertToDouble(segundoNumero);
		return sum;
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
