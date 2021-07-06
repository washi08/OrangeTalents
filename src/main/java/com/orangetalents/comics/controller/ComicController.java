package com.orangetalents.comics.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orangetalents.comics.datasource.DTO.ComicDTO;
//import com.orangetalents.comics.endpoint.ComicEndpoint;
import com.orangetalents.comics.service.ComicService;


@RestController
@EnableFeignClients
@RequestMapping(value = "/orangetalents")
public class ComicController {
	
	@Autowired
	private ComicService comicService;
	/*@Autowired
	private ComicEndpoint comicEndpoint;*/
	
	@GetMapping(path = "/comics/id/{id}")
	public ComicDTO getComicsPorId(@PathVariable(name = "id", required = true) Long id){
		return (ComicDTO) comicService.buscarComicPorId(id);
	}
	
	/*@GetMapping(path = "/comics")
	public List<ComicDTO> getAllComics(){
		return comicEndpoint.getComic();
	}*/
}
