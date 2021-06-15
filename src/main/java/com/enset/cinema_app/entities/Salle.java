package com.enset.cinema_app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @ToString @ NoArgsConstructor
public class Salle implements Serializable{
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int nombrePlace;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cinema cinema;
	
	@OneToMany(mappedBy = "salle")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Place> places;
	
	@OneToMany(mappedBy = "salle")
	
	private Collection<Projection> projections;
	

}
