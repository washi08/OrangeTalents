package com.orangetalents.comics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.comics.datasource.model.Usuario;
import com.orangetalents.comics.service.UsuarioService;

@RestController
@RequestMapping(value = "/orangetalents")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
		
	@GetMapping(path = "/usuarios/filtro")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> buscarUsuarioPorFiltro(
			@RequestParam(value="id", required = false) Long id, 
			@RequestParam(value="nome", required = false) String nome, 
			@RequestParam(value="cpf", required = false) String cpf) {
			
		return usuarioService.buscarUsuarioPorFiltro(id, nome, cpf);
	}
	
	@PostMapping(path = "/usuarios/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void criarUsuario (@RequestBody Usuario usuario) {
		usuarioService.criarUsuario(usuario);		
	}
	
	@PostMapping(path = "/estante")
	@ResponseStatus(HttpStatus.CREATED)
	public void InserirNaEstante (@RequestBody Usuario usuario) {
		usuarioService.salvarUsuario(usuario);		
	}
}