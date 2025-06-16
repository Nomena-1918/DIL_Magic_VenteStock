package org.itu.ventestock.repository;

import org.itu.ventestock.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repository pour l'entité Produit.
 * Fournit des méthodes pour interagir avec la base de données pour les entités Produit.
 */
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
