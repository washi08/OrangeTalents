package com.orangetalents.comics.datasource.DTO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicDTO {
	
	//////////////////////////////////////////////////
	//ATRIBUTOS
	//////////////////////////////////////////////////
	
	private Long id;
	private String titulo;
	private BigDecimal preco;
	private String autores;
	private String isbn;
	private String descricao;
		
	//////////////////////////////////////////////////
	//CONSTRUTORES
	//////////////////////////////////////////////////

	public ComicDTO() {
	}
	
	public ComicDTO(Long id, String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
		this.id = id;
		this.titulo = titulo;
		this.preco = preco;
		this.autores = autores;
		this.isbn = isbn;
		this.descricao = descricao;
	}

	//////////////////////////////////////////////////
	//GETS AND SETS
	//////////////////////////////////////////////////
	
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
	
	@SuppressWarnings("deprecation")
	public void setPreco(BigDecimal preco) {
		this.preco = preco.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	@SuppressWarnings("deprecation")
	public void setPreco(Boolean descontoAtivo, BigDecimal preco) {
		if(descontoAtivo) {
			this.preco = preco.setScale(2, BigDecimal.ROUND_HALF_EVEN);
			this.descricao = "DESCONTO DE 10% HOJE ... "+this.descricao;
		}else { 
			this.preco = preco.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		}
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
