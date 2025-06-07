-- PostgreSQL Database Creation Script
-- Run this script as a PostgreSQL superuser (e.g., postgres) before running schema.sql

-- Create the database if it doesn't exist
DO
$$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'dil_magic_vente_stock') THEN
      CREATE DATABASE dil_magic_vente_stock;
   END IF;
END
$$;

-- Note: After running this script, connect to the new database and run schema.sql
-- to create the user, tables, and other database objects.