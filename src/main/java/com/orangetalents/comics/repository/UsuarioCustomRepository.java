package com.orangetalents.comics.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.orangetalents.comics.datasource.model.Usuario;

@Repository
public class UsuarioCustomRepository {
	
	private final EntityManager em;
	
	public UsuarioCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Usuario> buscarUsuarioPorFiltro(Long id, String nome, String cpf) {
		String query = "SELECT U FROM Usuario AS U ";
		String condicao = "WHERE ";
		
		if(id != null) {
			query += condicao + "U.id = :id";
			condicao = "AND ";
		}
		
		if(nome != null) {
			query += condicao + "U.nome LIKE '%' || :nome || '%'";
			condicao = "AND ";
		}
		
		if(cpf != null) {
			query += condicao + "U.cpf = :cpf";
		}
		
		var q = em.createQuery(query, Usuario.class);
		
		if(id != null) {
			q.setParameter("id", id);
		}
		
		if(nome != null) {
			q.setParameter("nome", nome);
		}
		
		if(cpf != null) {
			q.setParameter("cpf", cpf);
		}
		
		return  q.getResultList();
	}

	

}
