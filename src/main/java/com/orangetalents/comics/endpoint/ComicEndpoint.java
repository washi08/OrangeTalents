package com.orangetalents.comics.endpoint;

//import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.orangetalents.comics.datasource.DTO.ComicDTO;

@FeignClient (name = "comic", url = "http://gateway.marvel.com/v1/public")
public interface ComicEndpoint {
	
	/*@RequestMapping(value = "/comics?ts=1625198212&apikey=d98c9eb6fa58d8e3fc820e8a4d3a431e&hash=25066d3351c8a9bf321db1b59cb99662")
	public List<ComicDTO> getComic();*/
	
	@RequestMapping(value = "/comics/{id}?ts=1625198212&apikey=d98c9eb6fa58d8e3fc820e8a4d3a431e&hash=25066d3351c8a9bf321db1b59cb99662")
	public String getComicPorId(@PathVariable(name = "id", required = true) Long id);
}
