package org.itu.ventestock.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.itu.ventestock.model.Produit;
import org.itu.ventestock.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des produits.
 */
@RestController
@RequestMapping("/api/produits")
@Tag(name = "Produit", description = "L'API des Produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    /**
     * GET /api/produits : Récupère tous les produits.
     *
     * @return le ResponseEntity avec le statut 200 (OK) et la liste des produits dans le corps
     */
    @GetMapping
    @Operation(summary = "Récupérer tous les produits", description = "Renvoie une liste de tous les produits disponibles")
    @ApiResponse(responseCode = "200", description = "Liste des produits récupérée avec succès",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Produit.class)))
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }

    /**
     * GET /api/produits/:id : Récupère un produit par son id.
     *
     * @param id l'identifiant du produit à récupérer
     * @return le ResponseEntity avec le statut 200 (OK) et le produit dans le corps, ou avec le statut 404 (Non trouvé)
     */
    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un produit par id", description = "Renvoie un produit selon l'id fourni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produit récupéré avec succès",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produit.class))),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé",
                    content = @Content)
    })
    public ResponseEntity<Produit> getProduitById(
            @Parameter(description = "ID du produit à récupérer", required = true)
            @PathVariable Long id) {
        return produitService.getProduitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
