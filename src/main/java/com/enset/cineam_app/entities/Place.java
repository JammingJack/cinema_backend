package com.enset.cineam_app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private double longitude,latidude,altitude;
    @ManyToOne
    private Salle salle;
    @OneToMany(mappedBy="place")
    private Collection<Ticket> tickets;
}
