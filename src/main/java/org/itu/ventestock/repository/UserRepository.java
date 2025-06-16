package org.itu.ventestock.repository;

import org.itu.ventestock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repository pour l'entité User.
 * Fournit des méthodes pour interagir avec la base de données pour les entités User.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
