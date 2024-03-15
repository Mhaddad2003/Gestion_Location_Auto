create table voiture (
    Matricule varchar(20) Not null,
    Module varchar(20) Not null,
    Marque varchar(25) Not null,
    Prix int Not null ,
    Coleur varchar(10) Not null,
    Disponibilite boolean Not null,
    PRIMARY KEY(Matricule)
);