package org.itu.ventestock.service;

import org.itu.ventestock.model.Produit;
import org.itu.ventestock.repository.ProduitRepository;
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

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    /**
     * Récupère tous les produits.
     *
     * @return Liste de tous les produits
     */
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    /**
     * Récupère tous les produits avec pagination et tri.
     *
     * @param pageable Informations de pagination et de tri
     * @return Page de produits
     */
    public Page<Produit> getAllProduits(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    /**
     * Récupère un produit par son ID.
     *
     * @param id L'ID du produit à récupérer
     * @return Optional contenant le produit s'il est trouvé, vide sinon
     */
    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }
}
