package com.orangetalents.comics.datasource.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comic")
public class Comic implements Serializable {
	
	private static final long serialVersionUID = 5822701709914138923L;
	
	//////////////////////////////////////////////////
	//ATRIBUTOS
	//////////////////////////////////////////////////
	
	@Id
	@Column(name = "id")
	private Long id;	
	
	@Column(name = "titulo")
	private String titulo;	
	
	@Column(name = "preco")
	private BigDecimal preco;
	
	@Column(name = "autores")
	private String autores;	
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "descricao")
	private String descricao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "estante")
	private List<Usuario> leitores = new ArrayList<>();
	
	//////////////////////////////////////////////////
	//CONSTRUTORES
	//////////////////////////////////////////////////
	
	public Comic() {
	}
	
	public Comic(Long id, String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
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
	
	public List<Usuario> getLeitores() {
		return leitores;
	}

	public void setLeitores(List<Usuario> leitores) {
		this.leitores = leitores;
	}
	
	
	//////////////////////////////////////////////////
	//MÉTODOS
	//////////////////////////////////////////////////

	public void addUsuario(Usuario usuario) {
		leitores.add(usuario);
	}
}
