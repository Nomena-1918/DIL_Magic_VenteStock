-- Instructions d'insertion pour le jeu de données des produits
-- Note: Les pk_id sont explicitement définis pour la clarté
INSERT INTO t_produit (pk_id, reference, libelle, est_du_jour, prix)
VALUES 
  (1, 'PROD001', 'Chapeau Magique', false, 100000),
  (2, 'PROD002', 'Anneau des cieux', true, 250000),
  (3, 'PROD003', 'Épée Tranchante', false, 25000),
  (4, 'PROD004', 'Baguette Mystique', true, 150000),
  (5, 'PROD005', 'Potion d''Invisibilité', false, 75000),
  (6, 'PROD006', 'Grimoire des Anciens', true, 300000),
  (7, 'PROD007', 'Amulette de Protection', false, 120000),
  (8, 'PROD008', 'Cape d''Invisibilité', true, 200000),
  (9, 'PROD009', 'Bottes de Célérité', false, 90000);

-- Instructions d'insertion pour le jeu de données des utilisateurs
INSERT INTO t_user (pk_id, pseudo, nom, prenom, mot_de_passe)
VALUES 
  (1, 'frodon', 'Baggins', 'Frodon', 'admin'),
  (2, 'sam', 'Baggins', 'Samwise', 'user');

-- Transactions d'entrée de stock pour initialiser les quantités
-- Type 1 = Entrée de stock, Type 2 = Sortie de stock
INSERT INTO t_transaction (pk_id, produit_id, quantite, type_transaction, date_ajout)
VALUES 
  (1, 1, 20, 1, '2025-01-01 10:00:00'),
  (2, 2, 250, 1, '2025-01-01 10:15:00'),
  (3, 3, 2, 1, '2025-01-02 09:30:00'),
  (4, 4, 15, 1, '2025-01-02 11:45:00'),
  (5, 5, 30, 1, '2025-01-03 14:20:00'),
  (6, 6, 5, 1, '2025-01-03 15:30:00'),
  (7, 7, 25, 1, '2025-01-04 10:00:00'),
  (8, 8, 10, 1, '2025-01-04 11:30:00'),
  (9, 9, 18, 1, '2025-01-05 13:45:00');