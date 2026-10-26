package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bindings.Passenger;
import com.example.demo.bindings.Ticket;
@Service
public class TicketService {
	
	
	public Ticket bookTicket(Passenger p) {
		
		String apiUrl="http://localhost:8080/irctc/ticket";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Ticket> forentity=restTemplate.postForEntity(apiUrl, p, Ticket.class);
		Ticket body=forentity.getBody();
		return body;
		}
	
	public List<Ticket> getAllTickets(){
		
String apiUrl="http://localhost:8080/irctc/tickets";
		
RestTemplate restTemplate = new RestTemplate();
ResponseEntity<Ticket[]> forentity=restTemplate.getForEntity(apiUrl, Ticket[].class);

Ticket[] body=forentity.getBody();

List<Ticket> tickets=Arrays.asList(body);
return tickets;

	}

}
