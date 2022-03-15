package br.com.abimael.service;

import org.springframework.stereotype.Service;

@Service
public class ValidadorService {

	public boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
