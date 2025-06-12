-- Table: produit
create table t_produit(
    pk_id serial primary key,
    reference varchar not null,
    libelle varchar not null,
    est_du_jour boolean,
    prix float8 check ( prix > 0 ),
    quantite_en_stock int check ( quantite_en_stock >= 0 )
);

-- Table: user
create table t_user(
    pk_id serial primary key,
    psuedo varchar not null,
    nom varchar not null,
    prenom varchar not null,
    mot_de_passe varchar not null,
);

-- Table: gestion stock
create table t_transaction(
    pk_id serial primary key,
    produit_id int not null,
    user_id int not null,
    quantite int check ( quantite >= 0 ),
    date_ajout timestamp default current_timestamp,
    type_transaction int check ( type_transaction in (1, 2) ),
    FOREIGN KEY (produit_id) REFERENCES t_produit(pk_id),
    FOREIGN KEY (user_id) REFERENCES t_user(pk_id)
);
