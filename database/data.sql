BEGIN;
-- Désactiver temporairement les contraintes de clé étrangère
SET CONSTRAINTS ALL DEFERRED;

-- Vider les tables existantes (l'ordre est important à cause des clés étrangères)
TRUNCATE TABLE t_transaction, t_produit, t_user RESTART IDENTITY;

-- Instructions d'insertion pour le jeu de données des utilisateurs
INSERT INTO t_user (pk_id, psuedo, nom, prenom, mot_de_passe)
VALUES 
  (1, 'frodon', 'Baggins', 'Frodon', 'admin'),
  (2, 'sam', 'Baggins', 'Samwise', 'user');

-- Instructions d'insertion pour le jeu de données des produits
-- Note: Les pk_id sont explicitement définis pour la clarté
INSERT INTO t_produit (pk_id, reference, libelle, est_du_jour, prix, quantite_en_stock)
VALUES 
  (1, 'PROD001', 'Chapeau Magique', false, 100000, 20),
  (2, 'PROD002', 'Anneau des cieux', true, 250000, 250),
  (3, 'PROD003', 'Épée Tranchante', false, 25000, 2),
  (4, 'PROD004', 'Baguette Mystique', true, 150000, 15),
  (5, 'PROD005', 'Potion d''Invisibilité', false, 75000, 30),
  (6, 'PROD006', 'Grimoire des Anciens', true, 300000, 5),
  (7, 'PROD007', 'Amulette de Protection', false, 120000, 25),
  (8, 'PROD008', 'Cape d''Invisibilité', true, 200000, 10),
  (9, 'PROD009', 'Bottes de Célérité', false, 90000, 18);

-- Transactions d'entrée de stock pour initialiser les quantités
-- Type 1 = Entrée de stock, Type 2 = Sortie de stock
INSERT INTO t_transaction (pk_id, produit_id, user_id, quantite, type_transaction, date_ajout)
VALUES 
  (1, 1, 1, 20, 1, '2025-01-01 10:00:00'),
  (2, 2, 1, 250, 1, '2025-01-01 10:15:00'),
  (3, 3, 1, 2, 1, '2025-01-02 09:30:00'),
  (4, 4, 1, 15, 1, '2025-01-02 11:45:00'),
  (5, 5, 2, 30, 1, '2025-01-03 14:20:00'),
  (6, 6, 2, 5, 1, '2025-01-03 15:30:00'),
  (7, 7, 2, 25, 1, '2025-01-04 10:00:00'),
  (8, 8, 2, 10, 1, '2025-01-04 11:30:00'),
  (9, 9, 2, 18, 1, '2025-01-05 13:45:00');

-- Pas besoin de réactiver les contraintes avec SET CONSTRAINTS
-- car elles sont automatiquement réactivées à la fin de la transaction
COMMIT;