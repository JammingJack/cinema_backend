package com.enset.cineam_app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
    public class Salle {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        private String name;
        private int nombrePlace;
        @ManyToOne
        private Cinema cinema;
        @OneToMany(mappedBy="salle")
        private Collection<Place> places;
        @OneToMany(mappedBy="salle")
        private Collection<Projection> projections;
}