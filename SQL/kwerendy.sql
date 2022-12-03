create database if not exists klubyPilkarskie;
use klubyPilkarskie;
create table if not exists Kluby(Id_k INT(3) PRIMARY KEY AUTO_INCREMENT, Kraj VARCHAR(255), Miasto VARCHAR(255), Nazwa VARCHAR(255));
create table if not exists Pilkarze(Id_p INT(3) PRIMARY KEY AUTO_INCREMENT, Imie VARCHAR(255), Nazwisko VARCHAR(255), Rok_urodzenia VARCHAR(4), Id_k INT (3), FOREIGN KEY (Id_k) REFERENCES Kluby(Id_k));
create table if not exists Wypozyczenia(Id_w INT(3) PRIMARY KEY AUTO_INCREMENT, id_k INT(3), id_p INT(3), Do_kiedy DATE, FOREIGN KEY (id_k) REFERENCES Kluby(Id_k), FOREIGN KEY (id_p) REFERENCES Pilkarze(Id_p));
create table if not exists Trener(Id_t INT(3) PRIMARY KEY AUTO_INCREMENT, Imie VARCHAR(255), Nazwisko VARCHAR(255), Rok_urodzenia VARCHAR(4), Id_k INT(3), FOREIGN KEY (Id_k) REFERENCES Kluby(Id_k));


INSERT INTO Kluby(Kraj, Miasto, Nazwa) VALUES ("Polska", "Warszawa", "Legia Warszawa"),
("Hiszpania", "Madryt", "Real Madryt"),
("Polska", "Krakow", "Wisla Krakow"),
("Polska", "Poznan", "Lech Poznan");
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Kowalski", "2000", 1);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Nowakowski", "1996", 1);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Marian", "Wisniewski", "1995", 1);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Janek", "Kowalski", "2003", 1);

INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Kowalski", "2003", 2);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Nowakowski", "1997", 2);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Marian", "Wisniewski", "1993", 2);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Janek", "Kowalski", "2002", 2);

INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Kowalski", "1996", 3);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Nowakowski", "2003", 3);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Marian", "Wisniewski", "2000", 3);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Janek", "Kowalski", "2001", 3);

INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Kowalski", "1993", 4);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Nowakowski", "2004", 4);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Marian", "Wisniewski", "1994", 4);
INSERT INTO Pilkarze(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Janek", "Kowalski", "2002", 4);


INSERT INTO Trener(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Marcin", "Nowakowski", "1976", 1);
INSERT INTO Trener(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Marcin", "Kowalski", "1982", 2);
INSERT INTO Trener(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Jan", "Rawski", "1997", 3);
INSERT INTO Trener(Imie, Nazwisko, Rok_urodzenia, Id_k) VALUES ("Andrzej", "Marecki", "1968", 4);

INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (1, 1, '2022.09.30');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (3, 5, '2022.10.30');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (2, 4, '2022.12.30');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (4, 7, '2021.08.30');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (4, 10, '2023.09.30');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (2, 11, '2025.06.17');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (1, 12, '2021.05.30');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (3, 14, '2023.01.30');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (4, 9, '2022.02.17');
INSERT INTO Wypozyczenia(id_k, id_p, Do_kiedy) VALUES (3, 2, '2022.11.30');