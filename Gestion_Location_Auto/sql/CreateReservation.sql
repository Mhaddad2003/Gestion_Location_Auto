create Table Reservation(
    IdR int auto_increment,
    DaysNumber int not null,
    CIN VARCHAR(15),
    Matricule VARCHAR(20),
    PRIMARY KEY(IdR),
    FOREIGN KEY(Matricule) REFERENCES voiture(Matricule),
    FOREIGN KEY(CIN) REFERENCES client(CIN)
);
