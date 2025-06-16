package org.itu.ventestock.controller;

import org.itu.ventestock.service.PanierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.itu.ventestock.dto.PanierRequest;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Contrôleur REST pour la gestion des paniers.
 */
@RestController
@RequestMapping("/api/paniers")
public class PanierController {

    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @PostMapping
    public ResponseEntity<?> ajouterAuPanier(@RequestBody PanierRequest request) {

        panierService.ajoutPanier(request);
        return ResponseEntity.ok("Produit ajouté au panier avec succès");
    }

    @GetMapping
    public ResponseEntity<?> getUserPanier() {
        // TODO : Récupération de l'ID de l'utilisateur depuis le contexte de sécurité
        return panierService.getUserPanier(1L); // Remplacer 1L par l'ID de l'utilisateur connecté
    }
    
}
