package com.orangetalents.comics.datasource.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
		
	private static final long serialVersionUID = 5822701709914138923L;
	
	//////////////////////////////////////////////////
	//ATRIBUTOS
	//////////////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;	
	
	@Column(name = "cpf")
	private String cpf;	
	
	@Column(name = "email")
	private String email;	
	
	@Column(name = "nascimento")
	private Date nascimento;
	
	@ManyToMany
	@JoinTable(
			name = "estante",
			joinColumns = @JoinColumn(name = "id_usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_comic")
	)	
	private List<Comic> estante = new ArrayList<>();
	
	//////////////////////////////////////////////////
	//CONSTRUTORES
	//////////////////////////////////////////////////
	
	public Usuario() {
	}
	
	public Usuario(String nome, String cpf, String email, Date nascimento) {
		//this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.nascimento = nascimento;
	}
	
	public Usuario(String nome, String cpf, String email, Date nascimento, List<Comic> estante) {
		//this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.nascimento = nascimento;
		this.estante = estante;
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

	public List<Comic> getEstante() {
		return estante;
	}

	public void setEstante(List<Comic> estante) {
		this.estante = estante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	//////////////////////////////////////////////////
	//MÉTODOS
	//////////////////////////////////////////////////
	
	public void estante(Comic comic) {
		estante.add(comic);
	}
}
