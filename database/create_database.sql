-- Script de création de base de données PostgreSQL
-- Exécutez ce script en tant que superutilisateur PostgreSQL (par exemple, postgres) avant d'exécuter schema.sql

-- Créer la base de données si elle n'existe pas
DO
$$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'dil_magic_vente_stock') THEN
      CREATE DATABASE dil_magic_vente_stock;
   END IF;
END
$$;

-- Remarque : Après avoir exécuté ce script, connectez-vous à la nouvelle base de données et exécutez schema.sql
-- pour créer l'utilisateur, les tables et autres objets de la base de données.
