package org.itu.ventestock.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entité représentant un panier dans le système.
 * Correspond à la view v_user_panier dans la base de données.
 */
@Entity
@Table(name = "v_user_panier")
@Getter
@Immutable
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPanier {

    @Id
    @Column(name = "pk_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;

    @Column(name = "quantite", nullable = false)
    private int quantite;
}
