-- Création de la base de données
CREATE DATABASE hardcore;

-- Création de l'utilisateur
CREATE USER fenix WITH PASSWORD 'Passer123';

-- Attribution des droits à l'utilisateur sur la base de données
GRANT ALL PRIVILEGES ON DATABASE hardcore TO fenix;
