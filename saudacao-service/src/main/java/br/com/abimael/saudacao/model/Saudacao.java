package br.com.abimael.saudacao.model;

public class Saudacao {
	private final long id;
	private final String content;

	public Saudacao(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public long getId() {
		return id;
	}
}
