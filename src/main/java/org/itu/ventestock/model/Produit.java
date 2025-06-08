package org.itu.ventestock.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité représentant un produit dans le système.
 * Correspond à la table t_produit dans la base de données.
 */
@Entity
@Table(name = "t_produit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long id;

    @Column(name = "reference", nullable = false)
    private String reference;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @Column(name = "est_du_jour")
    private Boolean estDuJour;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "quantite_en_stock")
    private Integer quantiteEnStock;
}
