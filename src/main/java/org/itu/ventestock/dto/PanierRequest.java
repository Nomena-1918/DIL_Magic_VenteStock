package org.itu.ventestock.dto;

import lombok.Data;

@Data
public class PanierRequest {
    private Long produitId;
    private int quantite;
}
