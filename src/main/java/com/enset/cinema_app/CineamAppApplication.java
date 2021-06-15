package com.enset.cinema_app;

import com.enset.cinema_app.entities.Film;
import com.enset.cinema_app.entities.Salle;
import com.enset.cinema_app.entities.Ticket;
import com.enset.cinema_app.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.io.File;

@SpringBootApplication
public class CineamAppApplication implements CommandLineRunner {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private ICinemaInitService cinemaInitService;
    public static void main(String[] args) {
        SpringApplication.run(CineamAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Film.class, Salle.class, Ticket.class);
        cinemaInitService.initVilles();
        cinemaInitService.initCinemas();
        cinemaInitService.initSalles();
        cinemaInitService.initPlaces();
        cinemaInitService.initSeances();
        cinemaInitService.initCategories();
        cinemaInitService.initFilms();
        cinemaInitService.initProjections();
        cinemaInitService.initTickets();

    }
}
