package com.wolken.wolkenapp.garage_consume_webservices;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wolken.wolkenapp.garage_consume_webservices.dto.ConsumeGarageDTO;


public class App 
{

    public static void main( String[] args )
    {   Logger logger = Logger.getLogger(App.class);
//    	get();
//    	post();
//    	put();
    	delete();
    
    }
    static void get() {
    	Logger logger = Logger.getLogger(App.class);
    	RestTemplate restTemplate = new RestTemplate();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	
    	HttpEntity<ConsumeGarageDTO> entity = new HttpEntity<ConsumeGarageDTO>(headers);
    	ResponseEntity<Object[]> responseEntity = restTemplate.exchange("http://localhost:8080/garage-webservices/getAll",
    			HttpMethod.GET,
    			entity, 
    			Object[].class);                //Since we use List in get method of Controller - List<VehicleDTO> ..We have to return Object[] 
    	Object[] object = responseEntity.getBody();
    	
    	logger.info("get data");
    	for (int j = 0; j < object.length; j++) {
    		logger.info(object[j]);
    	}
//    	logger.info(responseEntity.getBody());
    
    }
    static void post(){
    	Logger logger = Logger.getLogger(App.class);
    	RestTemplate restTemplate = new RestTemplate();
    	
    	ConsumeGarageDTO consumeGarageDTO = new ConsumeGarageDTO();
    	consumeGarageDTO.setVehicleId(6);
    	consumeGarageDTO.setNoOfWheels(2);
    	consumeGarageDTO.setType("Scooty");
    	consumeGarageDTO.setColor("White");
    	
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	
    	HttpEntity<ConsumeGarageDTO> entity = new HttpEntity<ConsumeGarageDTO>(consumeGarageDTO, headers);
    	
    	ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/garage-webservices/save",
    			HttpMethod.POST, 
    			entity,
    			String.class);
    	logger.info("save data:");
    	logger.info(responseEntity.getBody());
    }
    
    static void put(){
    	Logger logger = Logger.getLogger(App.class);
    	RestTemplate restTemplate = new RestTemplate();
    	
    	ConsumeGarageDTO consumeGarageDTO = new ConsumeGarageDTO();
    	consumeGarageDTO.setNoOfWheels(4);
    	consumeGarageDTO.setType("Bicycle");
    	
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	
    	HttpEntity<ConsumeGarageDTO> entity = new HttpEntity<ConsumeGarageDTO>(consumeGarageDTO, headers);
    	
    	ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/garage-webservices/update",
    			HttpMethod.PUT, 
    			entity,
    			String.class);
    	logger.info("update data:");
    	logger.info(responseEntity.getBody());
    }
    
    static void delete(){
    	Logger logger = Logger.getLogger(App.class);
    	RestTemplate restTemplate = new RestTemplate();
    	
    	ConsumeGarageDTO consumeGarageDTO = new ConsumeGarageDTO();
    	consumeGarageDTO.setColor("Silver");

    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	
    	HttpEntity<ConsumeGarageDTO> entity = new HttpEntity<ConsumeGarageDTO>(consumeGarageDTO, headers);
    	
    	ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/garage-webservices/delete",
    			HttpMethod.DELETE, 
    			entity,
    			String.class);
    	logger.info("delete data:");
    	logger.info(responseEntity.getBody());
    }
}
