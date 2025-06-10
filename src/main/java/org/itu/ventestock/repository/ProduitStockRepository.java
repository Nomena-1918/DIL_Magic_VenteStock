package org.itu.ventestock.repository;

import org.itu.ventestock.model.ProduitStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de repository pour l'entité ProduitStock.
 * Fournit des méthodes pour interagir avec la base de données pour les entités ProduitStock.
 */
@Repository
public interface ProduitStockRepository extends JpaRepository<ProduitStock, Long> {
}
