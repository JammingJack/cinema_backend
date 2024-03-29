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
public class Film {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private String realisateur;
	private Date dateSortie;
	private double duree;
	private String photo;
	
	@OneToMany(mappedBy = "film")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Projection> projections;
	
	@ManyToOne
	private Categorie categorie;
	

}
