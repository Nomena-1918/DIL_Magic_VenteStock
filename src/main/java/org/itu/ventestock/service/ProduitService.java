package org.itu.ventestock.service;

import org.itu.ventestock.model.Produit;
import org.itu.ventestock.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Produit entity.
 * Provides business logic for Produit entities.
 */
@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    /**
     * Get all products.
     *
     * @return List of all products
     */
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    /**
     * Get a product by its ID.
     *
     * @param id The ID of the product to retrieve
     * @return Optional containing the product if found, empty otherwise
     */
    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }
}