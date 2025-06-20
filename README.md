# Magic Vente Stock

Une application d'e-commerce pour des produits magiques.

## Description du projet

Magic Vente Stock est une application Spring Boot qui permet de gérer un inventaire de produits magiques. Elle offre une API REST pour consulter les produits disponibles.

## Prérequis

- Java 21
- PostgreSQL 
- Gradle (ou utiliser le wrapper Gradle inclus)

## Installation

### Option 1: Installation locale

1. Cloner le dépôt
   ```bash
   git clone https://github.com/Nomena-1918/DIL_Magic_VenteStock
   cd DIL_Magic_VenteStock
   ```

2. Configuration de la base de données PostgreSQL

   Exécuter les scripts SQL dans l'ordre suivant:
   ```bash
   # Se connecter à PostgreSQL en tant que superutilisateur
   psql -U postgres

   # Exécuter les scripts
   \i database/create_database.sql
   \c dil_magic_vente_stock
   \i database/create_user.sql
   \i database/schema.sql
   \i database/data.sql
   ```

   Ces scripts vont:
   - Créer la base de données `dil_magic_vente_stock`
   - Créer l'utilisateur `dil` avec le mot de passe `root`
   - Créer la table des produits
   - Insérer des données initiales

3. Compiler et exécuter l'application
   ```bash
   # Avec le wrapper Gradle
   ./gradlew bootRun
   ```

### Option 2: Utilisation de Docker

1. Cloner le dépôt
   ```bash
   git clone https://github.com/Nomena-1918/DIL_Magic_VenteStock
   cd DIL_Magic_VenteStock
   ```

2. Construire l'image Docker
   ```bash
   docker build -t magic-vente-stock .
   ```

3. Exécuter le conteneur Docker
   ```bash
   docker run -p 8000:8000 magic-vente-stock
   ```

   **Note**: Cette configuration Docker n'inclut pas la base de données. Pour une utilisation complète, vous devrez:
   - Configurer une base de données PostgreSQL séparément
   - Modifier la configuration de l'application pour se connecter à cette base de données

## Utilisation

Une fois l'application démarrée, vous pouvez accéder à:

- L'interface Swagger UI: http://localhost:8000/magic-vente-stock/swagger-ui/index.html
- L'API REST: http://localhost:8000/magic-vente-stock/api/produits

## Structure du projet

```
DIL_Magic_VenteStock/
├── database/                      # Scripts SQL pour la base de données
│   ├── create_database.sql        # Création de la base de données
│   ├── create_user.sql            # Création de l'utilisateur
│   ├── data.sql                   # Données initiales
│   └── schema.sql                 # Schéma de la base de données
├── src/
│   ├── main/
│   │   ├── java/org/itu/ventestock/
│   │   │   ├── config/            # Configuration de l'application
│   │   │   ├── controller/        # Contrôleurs REST
│   │   │   ├── model/             # Entités JPA
│   │   │   ├── repository/        # Repositories Spring Data
│   │   │   ├── service/           # Services métier
│   │   │   └── DilMagicVenteStockApplication.java  # Point d'entrée
│   │   └── resources/
│   │       └── application.yml    # Configuration de l'application
│   └── test/                      # Tests unitaires
├── build.gradle.kts               # Configuration de build Gradle
└── README.md                      # Ce fichier
```


## Configuration

### Fichiers de configuration

La configuration de l'application se trouve dans le fichier `src/main/resources/application.yml`:

- Port du serveur: 8000
- Chemin de contexte: /magic-vente-stock
- Base de données: PostgreSQL (configuration via variables d'environnement)

### Variables d'environnement

L'application utilise des variables d'environnement pour la configuration de la base de données. Deux fichiers sont fournis:

- `.env.example`: Un exemple de fichier de configuration avec des valeurs fictives. Ce fichier est versionné dans Git.
- `.env`: Le fichier de configuration réel avec vos valeurs personnelles. Ce fichier est ignoré par Git pour des raisons de sécurité.

Pour configurer l'application:

1. Copiez le fichier `.env.example` vers `.env`
   ```bash
   cp .env.example .env
   ```

2. Modifiez le fichier `.env` avec vos propres valeurs:
   ```
   DB_HOST=localhost
   DB_PORT=5432
   DB_NAME=dil_magic_vente_stock
   USERNAME=dil
   PASSWORD=root
   ```

## Technologies utilisées

- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Lombok
- SpringDoc OpenAPI (Swagger)
