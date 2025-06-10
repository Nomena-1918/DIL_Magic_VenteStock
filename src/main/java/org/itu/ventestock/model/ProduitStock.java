package org.itu.ventestock.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;

/**
 * Entité en lecture seule représentant un produit avec sa quantité en stock.
 * Mappée à la vue SQL 'v_produit_stock'.
 */
@Entity
@Table(name = "v_produit_stock")
@Getter
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProduitStock {

    @Id
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
    private Integer quantiteStock;
}
