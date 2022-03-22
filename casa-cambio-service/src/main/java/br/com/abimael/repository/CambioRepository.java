package br.com.abimael.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abimael.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);

}
