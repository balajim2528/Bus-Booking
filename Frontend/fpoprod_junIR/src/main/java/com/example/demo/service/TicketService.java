package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import com.example.demo.bindings.Passenger;
import com.example.demo.bindings.Ticket;

public interface TicketService {
	public Ticket bookTicket(Passenger p);
	
	public Collection<Ticket> getAllTickets();
	

}
