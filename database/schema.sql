-- Table: produit
create table t_produit(
    pk_id serial primary key,
    reference varchar not null,
    libelle varchar not null,
    est_du_jour boolean,
    prix float8 check ( prix > 0 ),
    quantite_en_stock int check ( quantite_en_stock >= 0 )
);

-- Table: gestion stock
create table t_transaction(
    pk_id serial primary key,
    produit_id int not null,
    quantite int check ( quantite >= 0 ),
    date_ajout timestamp default current_timestamp,
    type_transaction int check ( type_transaction in (1, 2) ),
    FOREIGN KEY (produit_id) REFERENCES t_produit(pk_id)
);