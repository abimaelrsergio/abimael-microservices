package br.com.abimael.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "book")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "author", nullable = false, length = 180)
	private String autor;

	@Column(name = "launch_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;

	@Column(name = "price", nullable = false)
	private Double preco;

	@Column(name = "title", nullable = false, length = 250)
	private String titulo;

	public Livro() {
	}

	public Livro(Long id, String autor, String titulo, Date dataLancamento, Double preco) {
		this.id = id;
		this.autor = autor;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, dataLancamento, id, preco, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(dataLancamento, other.dataLancamento)
				&& Objects.equals(id, other.id) && Objects.equals(preco, other.preco)
				&& Objects.equals(titulo, other.titulo);
	}

}
