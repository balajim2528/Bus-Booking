package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.bindings.Ticket;
import com.example.demo.service.TicketService;

@SpringBootApplication
public class FpoprodJunmmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(FpoprodJunmmApplication.class, args);
		TicketService bean=	context.getBean(TicketService.class);
		List<Ticket> getAllTickets=bean.getAllTickets();
		System.out.println(getAllTickets);
		
	}

}
