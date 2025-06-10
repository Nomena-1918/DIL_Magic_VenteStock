package org.itu.ventestock.service;

import org.itu.ventestock.model.ProduitStock;
import org.itu.ventestock.repository.ProduitStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe de service pour l'entité Produit.
 * Fournit la logique métier pour les entités Produit.
 */
@Service
public class ProduitService {

    private final ProduitStockRepository produitStockRepository;

    public ProduitService(ProduitStockRepository produitStockRepository) {
        this.produitStockRepository = produitStockRepository;
    }

    /**
     * Récupère tous les produits.
     *
     * @return Liste de tous les produits
     */
    public List<ProduitStock> getAllProduits() {
        return produitStockRepository.findAll();
    }

    /**
     * Récupère tous les produits avec pagination et tri.
     *
     * @param pageable Informations de pagination et de tri
     * @return Page de produits
     */
    public Page<ProduitStock> getAllProduits(Pageable pageable) {
        return produitStockRepository.findAll(pageable);
    }

    /**
     * Récupère un produit par son ID.
     *
     * @param id L'ID du produit à récupérer
     * @return Optional contenant le produit s'il est trouvé, vide sinon
     */
    public Optional<ProduitStock> getProduitById(Long id) {
        return produitStockRepository.findById(id);
    }
}
