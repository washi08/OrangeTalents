package com.orangetalents.comics.resource.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComicResource {

	@JsonProperty("id")
	private Long id;	
	@JsonProperty("titulo")
	private String titulo;	
	@JsonProperty("preco")
	private BigDecimal preco;	
	@JsonProperty("autores")
	private String autores;	
	@JsonProperty("isbn")
	private String isbn;
	@JsonProperty("descricao")
	private String descricao;
	
	public ComicResource(Long id, String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
	this.id = id;
	this.titulo = titulo;
	this.preco = preco;
	this.autores = autores;
	this.isbn = isbn;
	this.descricao = descricao;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
