package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.bindings.Passenger;
import com.example.demo.bindings.Ticket;
@Service
public class TicketServiceImpl implements TicketService {
   Map<Integer,Ticket> map = new HashMap<>();
   @Override
   public Ticket bookTicket(Passenger p) {
	    Ticket t = new Ticket();
	    Random r = new Random(); 
	    int id;
	    do {
	        id = r.nextInt(10000); 
	    } while (map.containsKey(id)); 

	    t.setTicketNum(id);
	    BeanUtils.copyProperties(p, t);
	    t.setStatus("confirmed");
	    map.put(id, t);
	    return t;
	}


	@Override
	public Collection<Ticket> getAllTickets() {
		
		return map.values();
	}

}
