package com.enset.cinema_app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @ToString @ NoArgsConstructor
public class Place {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private double longitude,latitude,altitude;
	@ManyToOne
	private Salle salle;
	
	@OneToMany(mappedBy = "place")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Ticket> tickets;

}
