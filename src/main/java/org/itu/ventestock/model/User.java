package org.itu.ventestock.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long id;

    @Column(nullable = false)
    private String pseudo;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;
}
