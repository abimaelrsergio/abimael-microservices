package br.com.abimael.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.abimael.model.Livro;
import br.com.abimael.resource.LivroResource;

@Mapper(componentModel = "spring")
public interface LivroMapper {

	Livro livroResourceToLivro(LivroResource livro);

	@Mapping(target = "moeda", ignore = true)
	@Mapping(target = "ambiente", ignore = true)
	LivroResource livroToLivroResource(Livro livro);
}
