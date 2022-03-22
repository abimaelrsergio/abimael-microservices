package br.com.abimael.mapper;

import org.mapstruct.Mapper;

import br.com.abimael.model.Cambio;
import br.com.abimael.resource.CambioResource;

@Mapper(componentModel = "spring")
public interface CambioMapper {

	CambioResource cambioToCambioResource(Cambio cambio);

	Cambio cambioResourceToCambio(CambioResource cambioResource);

}
