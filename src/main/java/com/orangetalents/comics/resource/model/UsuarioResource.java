package com.orangetalents.comics.resource.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioResource {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("cpf")
	private String cpf;
	@JsonProperty("email")
	private String email;
	@JsonProperty("nascimento")
	private Date nascimento;
	
	public UsuarioResource(Long id, String nome, String cpf, String email, Date nascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.nascimento = nascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	
	
}
