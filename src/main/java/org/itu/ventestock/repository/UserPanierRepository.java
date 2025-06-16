package org.itu.ventestock.repository;

import java.util.List;

import org.itu.ventestock.model.UserPanier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repository pour l'entité UserPanier.
 * Fournit des méthodes pour interagir avec la base de données pour les entités UserPanier.
 */
public interface UserPanierRepository extends JpaRepository<UserPanier, Long> {

    List<UserPanier> findAllByUserId(Long userId);
}
