package br.com.abimael.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.abimael.mapper.CambioMapper;
import br.com.abimael.repository.CambioRepository;
import br.com.abimael.resource.CambioResource;

@Service
public class CambioService {

	@Autowired
	private CambioMapper mapper;

	@Autowired
	private Environment environment;

	@Autowired
	private CambioRepository repository;

	public CambioResource findByFromAndTo(BigDecimal valor, String from, String to) {
		var cambio = repository.findByFromAndTo(from, to);
		if (cambio == null) {
			throw new RuntimeException("Currency Unsuported");
		}
		var port = environment.getProperty("local.server.port");
		BigDecimal conversionFactor = cambio.getConversionFactor();
		BigDecimal convertedValue = conversionFactor.multiply(valor);
		cambio.setEnvironment(port);
		cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
		return mapper.cambioToCambioResource(cambio);
	}

}
