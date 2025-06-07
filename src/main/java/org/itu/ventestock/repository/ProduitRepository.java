package org.itu.ventestock.repository;

import org.itu.ventestock.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Produit entity.
 * Provides methods to interact with the database for Produit entities.
 */
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}