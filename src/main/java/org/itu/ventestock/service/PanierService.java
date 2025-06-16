package org.itu.ventestock.service;

import org.itu.ventestock.model.Panier;
import org.itu.ventestock.model.Produit;
import org.itu.ventestock.model.User;
import org.itu.ventestock.model.UserPanier;
import org.itu.ventestock.repository.PanierRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import org.itu.ventestock.dto.PanierRequest;
import org.itu.ventestock.repository.*;

/**
 * Classe de service pour l'entité Panier.
 * Fournit la logique métier pour les entités Panier.
 */ 
@Service
public class PanierService {

    private final PanierRepository PanierRepository;
    private final ProduitRepository ProduitRepository;
    private final UserRepository UserRepository;
    private final UserPanierRepository UserPanierRepository;

    public PanierService(PanierRepository PanierRepository, ProduitRepository ProduitRepository, UserRepository UserRepository, UserPanierRepository UserPanierRepository) {
        this.PanierRepository = PanierRepository;
        this.ProduitRepository = ProduitRepository;
        this.UserRepository = UserRepository;
        this.UserPanierRepository = UserPanierRepository;
    }

    public ResponseEntity<Panier> ajoutPanier(PanierRequest request) {
        
        // TODO : Récupération de l'ID de l'utilisateur depuis le contexte de sécurité
        Long userId = 1L; // Remplacer par la logique pour obtenir l'ID de l'utilisateur connecté
        User user = UserRepository.findById(userId).orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        Produit produit = ProduitRepository.findById(request.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        Panier panier = Panier.builder()
                .user(user)
                .produit(produit)
                .quantite(request.getQuantite())
                .build();

        Panier saved = PanierRepository.save(panier);

        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<List<UserPanier>> getUserPanier(Long userId) {
        return ResponseEntity.ok(UserPanierRepository.findAllByUserId(userId));
    }
}
