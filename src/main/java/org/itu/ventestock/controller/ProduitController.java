package org.itu.ventestock.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.itu.ventestock.model.ProduitStock;
import org.itu.ventestock.service.ProduitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * GET /api/produits : Récupère tous les produits avec pagination et tri.
     *
     * @param page le numéro de la page à récupérer (commence à 0)
     * @param size le nombre d'éléments par page (par défaut 3)
     * @param sort le champ sur lequel trier (par défaut "id")
     * @param direction la direction du tri (ASC ou DESC, par défaut ASC)
     * @return le ResponseEntity avec le statut 200 (OK) et la page de produits dans le corps
     * 
     * @example GET /api/produits?page=0&size=3&sort=prix&direction=DESC
     * Récupère la première page de 3 produits triés par prix décroissant
     */
    @GetMapping
    @Operation(
        summary = "Récupérer les produits avec pagination et tri", 
        description = "Renvoie une page de produits selon les paramètres de pagination et de tri fournis"
    )
    @ApiResponse(
        responseCode = "200", 
        description = "Page de produits récupérée avec succès",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))
    )
    public ResponseEntity<Page<ProduitStock>> getAllProduits(
            @Parameter(description = "Numéro de page (commence à 0)", example = "0")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "Nombre d'éléments par page", example = "3")
            @RequestParam(defaultValue = "3") int size,

            @Parameter(description = "Champ sur lequel trier", example = "id")
            @RequestParam(defaultValue = "id") String sort,

            @Parameter(description = "Direction du tri (ASC ou DESC)", example = "ASC")
            @RequestParam(defaultValue = "ASC") String direction) {

        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(page, size, sortDirection, sort);

        Page<ProduitStock> produits = produitService.getAllProduits(pageable);
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
                            schema = @Schema(implementation = ProduitStock.class))),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé",
                    content = @Content)
    })
    public ResponseEntity<ProduitStock> getProduitById(
            @Parameter(description = "ID du produit à récupérer", required = true)
            @PathVariable Long id) {
        return produitService.getProduitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
