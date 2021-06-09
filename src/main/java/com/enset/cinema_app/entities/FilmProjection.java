package com.enset.cinema_app.entities;

import com.enset.cinema_app.entities.Film;
import com.enset.cinema_app.entities.Salle;
import com.enset.cinema_app.entities.Seance;
import com.enset.cinema_app.entities.Ticket;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name="filmNeededInfoProjection",types={com.enset.cinema_app.entities.Projection.class})
public interface FilmProjection {
    public Long getId();
    public double getPrix();
    public Date getDateProjection();
    public Salle getSalle();
    public Film getFilm();
    public Seance getSeance();
    public Collection<Ticket> getTickets();
}
