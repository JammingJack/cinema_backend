package com.enset.cinema_app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @ToString @ NoArgsConstructor
public class Projection {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateProjection;
	private double prix;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Salle salle;
	@ManyToOne
	private Film film;
	
	@OneToMany(mappedBy = "projection")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Ticket> tickets;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Seance seance;
	

}
