-- Création de l'utilisateur
-- Remarque : Dans PostgreSQL, nous utilisons IF NOT EXISTS avec un bloc DO pour la création conditionnelle d'utilisateur
DO
$$
    BEGIN
        IF NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = 'dil') THEN
            CREATE USER "dil" WITH PASSWORD 'root';
        END IF;
    END
$$;

-- Accorder tous les privilèges à l'utilisateur
GRANT ALL PRIVILEGES ON DATABASE dil_magic_vente_stock TO "dil";

-- Droits sur toutes les tables existantes
GRANT ALL PRIVILEGES
    ON ALL TABLES IN SCHEMA public
    TO dil;

-- Droits sur toutes les séquences (pour les colonnes SERIAL/IDENTITY)
GRANT ALL PRIVILEGES
    ON ALL SEQUENCES IN SCHEMA public
    TO dil;

-- Au besoin, autoriser l’usage du schéma (pour que dil voit les objets)
GRANT USAGE
    ON SCHEMA public
    TO dil;
