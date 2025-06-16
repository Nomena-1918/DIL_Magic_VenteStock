-- Table: produit
create table t_produit(
    pk_id serial primary key,
    reference varchar not null,
    libelle varchar not null,
    est_du_jour boolean,
    prix float8 check ( prix > 0 )
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

-- Table: user
create table t_user(
    pk_id serial primary key,
    pseudo varchar not null,
    nom varchar not null,
    prenom varchar not null,
    mot_de_passe varchar not null
);

-- Table: panier
create table t_panier(
    pk_id serial primary key,
    user_id int not null,
    produit_id int not null,
    quantite int check ( quantite > 0 ),
    date_creation timestamp default current_timestamp,
    FOREIGN KEY (produit_id) REFERENCES t_produit(pk_id),
    FOREIGN KEY (user_id) REFERENCES t_user(pk_id)
);

-- View: produit avec quantité en stock
create view v_produit_stock as
select 
    p.pk_id,
    p.reference,
    p.libelle,
    p.est_du_jour,
    p.prix,
    coalesce(sum(case when t.type_transaction = 1 then t.quantite else -t.quantite end), 0) as quantite_en_stock 
from
    t_produit p
left join
    t_transaction t on p.pk_id = t.produit_id
group by
    p.pk_id, p.reference, p.libelle, p.est_du_jour, p.prix;


-- View: panier d'un utilisateur
create view v_user_panier as 
select
    ROW_NUMBER() OVER () as pk_id,
    user_id, 
    produit_id, 
    sum(quantite) as quantite
from 
    t_panier 
group by 
    user_id, 
    produit_id
    