package com.orangetalents.comics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.orangetalents.comics.datasource.model.Comic;
import com.orangetalents.comics.datasource.model.Usuario;
import com.orangetalents.comics.repository.UsuarioCustomRepository;
import com.orangetalents.comics.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioCustomRepository usuarioCustomRepository;
	@Autowired
	private ComicService comicService;
	
	public void criarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
      }
	
	public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
      }  
	    
    public List<Usuario> buscarUsuarioPorFiltro(Long id, String nome, String cpf) {
    	return usuarioCustomRepository.buscarUsuarioPorFiltro(id,nome,cpf);   	  
      } 
    
    public Usuario salvarUsuario(Usuario usuario) {
    	Usuario newUsuario = new Usuario();
    	newUsuario.setEmail(usuario.getEmail());
    	newUsuario.setCpf(usuario.getCpf());
    	newUsuario.setNome(usuario.getNome());
    	newUsuario.setNascimento(usuario.getNascimento());
    	newUsuario.getEstante()
    	.addAll(usuario
    			.getEstante()
    			.stream()
    			.map(c -> {
    				Comic comic = comicService.findComicById(c.getId());
    				comic.getLeitores().add(usuario);
    				return comic;
    			}).toList());
    	return usuarioRepository.save(usuario);
    				
    			}
    	
    }