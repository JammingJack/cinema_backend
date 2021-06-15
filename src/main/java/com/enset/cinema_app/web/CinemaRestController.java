package com.enset.cinema_app.web;

import lombok.Data;
import com.enset.cinema_app.dao.FilmRepository;
import com.enset.cinema_app.dao.TicketRepository;
import com.enset.cinema_app.entities.Film;
import com.enset.cinema_app.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping(path = "/imageFilm/{id}", produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable (name="id")Long id) throws IOException {
		Film f= filmRepository.findById(id).get();
		String photoName =f.getPhoto();
		//File file= new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
		File file= new File(System.getProperty("user.dir")+"/images/"+photoName);
		Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}
	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> payerTickets(@RequestBody TicketFrom ticketFrom) {
		List<Ticket> listTickets=new ArrayList<>();
		
		ticketFrom.getTickets().forEach(idTicket->{
		
			Ticket ticket=ticketRepository.findById(idTicket).get();
			ticket.setNomClient(ticketFrom.getNomClient());
			ticket.setReserve(true);
			ticket.setCodePayement(ticketFrom.getCodePayement());
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		});
		return listTickets;
	}
}

@Data
class TicketFrom{
	private String nomClient;
	private int codePayement;
	private List<Long> tickets=new ArrayList<>();
}