package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bindings.Passenger;
import com.example.demo.bindings.Ticket;
import com.example.demo.service.TicketServiceImpl;

@RestController
public class TicketController {
	@Autowired
	private TicketServiceImpl service;
	
	@PostMapping("/ticket")
	public ResponseEntity<Ticket>bookTicket(@RequestBody Passenger p){
		Ticket ticket=service.bookTicket(p);
		return new ResponseEntity<> (ticket,HttpStatus.CREATED);
	}
	
	@GetMapping("/tickets")
		public ResponseEntity<Collection<Ticket>> getTickets(){
			
			Collection<Ticket> alltickets= service.getAllTickets();
			return new ResponseEntity<> (alltickets,HttpStatus.OK);
			
			
		}
	}


