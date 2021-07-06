package com.orangetalents.comics.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.orangetalents.comics.datasource.DTO.ComicDTO;
import com.orangetalents.comics.endpoint.ComicEndpoint;
import com.orangetalents.comics.datasource.model.Comic;
import com.orangetalents.comics.repository.ComicRepository;

@Service
@EnableFeignClients
public class ComicService {
	
	@Autowired
	private ComicRepository comicRepository;
	@Autowired
	private ComicEndpoint comicEndpoint;
	
	public void criarComic(Comic comicBanco) {
		comicRepository.save(comicBanco);
      }
	
	public List<Comic> buscarComics() {
        return comicRepository.findAll();
      }  
	
    public ComicDTO buscarComicPorId(Long id) {
    	String JsonStr = comicEndpoint.getComicPorId(id);
		ObjectMapper mapper = new ObjectMapper();
		ComicDTO comic = new ComicDTO();
		BigDecimal num2 = new BigDecimal(0);
		
		try {
			//Mapear tag Data do Json
			JsonNode JsonStr2 = mapper.readTree(JsonStr);
			ObjectNode JsonStr3 = (ObjectNode) JsonStr2;
			JsonStr2 = JsonStr3.get("data");
			
			//Mapear array results dentro da tag Data
			ArrayNode ArrayResults = (ArrayNode) JsonStr2.get("results");
			Iterator<JsonNode> iteratorResults = ArrayResults.elements();
			JsonNode results = iteratorResults.next();
			
			//Mapear array prices dentro do array results
			ArrayNode ArrayPrices = (ArrayNode) results.get("prices");
			Iterator<JsonNode> iteratorPrices = ArrayPrices.elements();
			JsonNode resultsPreco = iteratorPrices.next();
			
			//Mapear array creators dentro do array results
			ObjectNode JsonStr4 = (ObjectNode) results;
			JsonStr4 = (ObjectNode) JsonStr4.get("creators");
			ArrayNode ArrayCreatosItems = (ArrayNode) JsonStr4.get("items");
			Iterator<JsonNode> iteratorCreatorsItems = ArrayCreatosItems.elements();
			JsonNode resultsCreatorsItems = iteratorCreatorsItems.next();
			
			comic.setId(results.get("id").asLong());
			comic.setTitulo(results.get("title").asText());
			comic.setDescricao(results.get("description").asText());
			comic.setIsbn(results.get("isbn").asText());
			comic.setAutores(resultsCreatorsItems.get("name").asText());
			
			String str = resultsPreco.get("price").asText();
			String isbn = results.get("isbn").asText();
			
			BigDecimal num = new BigDecimal(str);
			num2 = num;
			if(isbn == null || isbn == "") {
				comic.setPreco(num);
			} else {
				comic.setPreco(verificaDesconto(isbn),calculaDesconto(num));
			}
			
			//Inserir comic no banco de dados
			Comic comicBanco = new Comic();
			comicBanco.setId(comic.getId());
			comicBanco.setTitulo(comic.getTitulo());
			comicBanco.setDescricao(comic.getDescricao());
			comicBanco.setIsbn(comic.getIsbn());
			comicBanco.setAutores(comic.getAutores());
			comicBanco.setPreco(verificaDesconto(comic.getIsbn()), calculaDesconto(num2));
			
			criarComic(comicBanco);
			System.out.println("comicbanco = "+comicBanco.getTitulo());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comic;
     }  
    
    public Optional<Comic> buscarComicBancoPorId(Long id) {
    	return  comicRepository.findById(id);
      }  
    
    public BigDecimal calculaDesconto(BigDecimal preco) {
    	BigDecimal desconto = preco.multiply(new BigDecimal(0.10));
		return preco.subtract(desconto);
    }
    
    public Boolean verificaDesconto(String isbn) {		
		Date date = new Date(); 
		Calendar calendar = new GregorianCalendar(); 
		calendar.setTime(date); 
		int dia = calendar.get(Calendar.DAY_OF_WEEK); 
		char ultimoDigito = ultimoDigito(isbn);
		
		Boolean descontoAtivo = false;
		
		if (Calendar.MONDAY == dia && (ultimoDigito == '0' || ultimoDigito == '1')) {
			descontoAtivo = true;
		}
		if (Calendar.TUESDAY == dia && (ultimoDigito == '2' || ultimoDigito == '3')) {
			descontoAtivo = true;
		}
		if (Calendar.WEDNESDAY == dia && (ultimoDigito == '4' || ultimoDigito == '5')) {
			descontoAtivo = true;
		}
		if (Calendar.THURSDAY == dia && (ultimoDigito == '6' || ultimoDigito == '7')) {
			descontoAtivo = true;
		}
		if (Calendar.FRIDAY == dia && (ultimoDigito == '8' || ultimoDigito == '9')) {
			descontoAtivo = true;
		}
		
		return descontoAtivo;
	}

	public static char ultimoDigito(String isbn) {
	    if (isbn != null && isbn.length() > 0) {
	        return isbn.charAt(isbn.length() - 1);
	    }
	    return (char) 0;
	}
	
	public Comic findComicById(Long comicId) {
		return comicRepository.findById(comicId).orElse(new Comic());
	}
}
