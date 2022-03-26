package br.com.abimael.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String autor;
	private Date dataLancamento;
	private Double preco;
	private String titulo;
	private String moeda;
	private String ambiente;

	public Livro() {
	}

	public Livro(Long id, String autor, String titulo, Date dataLancamento, Double preco, String moeda, String ambiente) {
		this.id = id;
		this.autor = autor;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
		this.titulo = titulo;
		this.moeda = moeda;
		this.ambiente = ambiente;
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

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ambiente, autor, dataLancamento, id, moeda, preco, titulo);
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
		return Objects.equals(ambiente, other.ambiente) && Objects.equals(autor, other.autor)
				&& Objects.equals(dataLancamento, other.dataLancamento) && Objects.equals(id, other.id)
				&& Objects.equals(moeda, other.moeda) && Objects.equals(preco, other.preco)
				&& Objects.equals(titulo, other.titulo);
	}

	
	
	
}
