package br.com.abimael.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversorService {

	@Autowired
	private ValidadorService validadorService;

	public Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (validadorService.isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}
}
