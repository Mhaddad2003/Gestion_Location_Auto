create table client(
    CIN VARCHAR(15),
    nom VARCHAR(15),
    prenom VARCHAR(15),
    tel VARCHAR(20) NOT NULL,
    Permis VARCHAR(30) NOT NULL,
    password VARCHAR(20),
    PRIMARY KEY(CIN)
);