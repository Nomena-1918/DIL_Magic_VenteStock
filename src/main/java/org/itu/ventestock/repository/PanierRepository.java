package org.itu.ventestock.repository;

import org.itu.ventestock.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repository pour l'entité Panier.
 * Fournit des méthodes pour interagir avec la base de données pour les entités Panier.
 */
public interface PanierRepository extends JpaRepository<Panier, Long> {
}
