-- Table: produit
create table t_produit(
    pk_id serial primary key,
    reference varchar not null,
    libelle varchar not null,
    est_du_jour boolean,
    prix float8 check ( prix > 0 ),
    quantite_en_stock int check ( quantite_en_stock >= 0 )
);
