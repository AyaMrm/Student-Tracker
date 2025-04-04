
create database StudentTracker;
USE StudentTracker;

create table utilisateurs(
idUser int primary key not null ,
nom varchar(30) not null ,
prenom varchar(40) not null ,
email varchar(70) unique not null ,
motdepasse varchar(70) not null ,
role enum('Etudiant', 'Admin', 'Prof' )
);

create table annees(
idAnnee int primary key not null ,
moyGeneral float ,
methodeCalcul enum( '40% - 60%' , '50% - 50%', 'Personnalisée')not null default '40% - 60%', 
anneeScolaire varchar(9) not null unique 
);
alter table annees modify column moyGeneral decimal(4,2);
ALTER TABLE annees DROP COLUMN methodeCalcul;
ALTER TABLE annees ADD COLUMN idEtudiant INT NOT NULL UNIQUE;
ALTER TABLE annees ADD CONSTRAINT fk_idEtudiant FOREIGN KEY (idEtudiant) REFERENCES etudiants(idEtudiant) ON DELETE CASCADE;

create table profs(
idProf int primary key not null ,
foreign key (idProf) references utilisateurs(idUser) on delete cascade ,
specialite varchar(50) not null ,
grade varchar(20) not null ,
departement varchar(30) not null 
);

create table modules(
idModule int primary key not null,
nom varchar(30) not null,
idProfResponsable int ,
specialite varchar(30) not null ,
foreign key (idProfResponsable) references profs(idProf) on  delete set null
);
ALTER TABLE modules DROP COLUMN spetialite;
ALTER TABLE modules ADD COLUMN idSpecialite INT NOT NULL UNIQUE;
ALTER TABLE modules ADD CONSTRAINT fk_idSpecialite FOREIGN KEY (idSpecialite) REFERENCES specialites(idSpecialite) ON DELETE CASCADE;
alter table modules add column methodeCalcul enum('40% - 60%', '50% - 50%', 'Personnalisée') default '40% - 60%';
ALTER TABLE modules
ADD COLUMN coefControle DOUBLE,
ADD COLUMN coefExamen DOUBLE;

create table emploisdutemps(
idEmploiDuTemps int primary key not null,
jour enum('Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi', 'Dimanche') not null ,
heure_debut time not null ,
heure_fin time not null ,
salle varchar(30) not null ,
idModule int not null ,
idProf int  ,
section varchar(2) not null ,
groupe varchar(2) not null ,
idAnnee int not null ,
foreign key (idModule) references modules(idModule) on delete cascade,
foreign key (idProf) references profs(idProf) on delete set null,
foreign key (idAnnee) references annees(idAnnee) on delete cascade
);
ALTER TABLE emploisdutemps
DROP FOREIGN KEY emploisdutemps_ibfk_1,
DROP FOREIGN KEY emploisdutemps_ibfk_2,
DROP COLUMN jour,
DROP COLUMN heure_debut,
DROP COLUMN heure_fin,
DROP COLUMN salle,
DROP COLUMN idModule,
DROP COLUMN idProf;

alter table emploisdutemps add column idSpecialite int not null;
alter table emploisdutemps add foreign key  (idSpecialite) references specialites(idSpecialite) on delete cascade;
create table specialites(
idSpecialite int primary key not null ,
nomSpecialite varchar(50) not null);



create table seances(
idSeance int primary key not null ,
heure_debut time not null ,
heure_fin time not null ,
idModule int not null ,
idProf int ,
salle varchar(30) not null ,
idJour int not null ,
foreign key (idJour) references jours(idJour) on delete cascade
);

create table jours(
idJour int primary key not null,
jour enum('Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi', 'Dimanche') not null 
);

create table etudiants(
idEtudiant int primary key  not null ,
foreign key (idEtudiant) references utilisateurs(idUser) on delete cascade , 
specialite varchar(30) not null ,
section varchar(2) not null ,
groupe varchar(2) not null , 
idAnnee int ,
idEmploiDuTemps int  ,
foreign key (idEmploiDuTemps) references emploisdutemps(idEmploiDuTemps) on delete set null ,
foreign key (idAnnee) references annees(idAnnee) on delete set null 
);
ALTER TABLE etudiants DROP FOREIGN KEY etudiants_ibfk_3;
ALTER TABLE etudiants DROP COLUMN idAnnee;
alter table etudiants add column moyenneGenerale decimal(4,2) default null;



create table etudiants_modules(
idEtudiant int ,
idModule int ,
primary key (idEtudiant , idModule),
foreign key (idEtudiant) references etudiants(idEtudiant) on delete cascade ,
foreign key (idModule) references modules(idModule) on delete cascade 
);

create table admins(
idAdmin int primary key not null ,
foreign key (idAdmin) references utilisateurs(idUser) on delete cascade 
);


create table profs_modules(
idProf int ,
idModule int ,
primary key (idProf , idModule ),
foreign key (idModule) references modules(idModule) on delete cascade,
foreign key (idProf) references profs(idProf) on delete cascade

);


create table notes(
idNote int primary key not null ,
coefficient int check (coefficient >0),
cc float check (cc between 0 and 20),
exam float check (exam between 0 and 20),
moyenne float check (moyenne between 0 and 20),
idEtudiant int not null ,
idProf int not null ,
idModule int not null ,
foreign key (idEtudiant) references etudiants(idEtudiant) on delete cascade ,
foreign key (idModule) references modules(idModule) on delete cascade ,
foreign key (idProf) references profs(idProf) on delete cascade  
);
 alter table notes modify column moyenne decimal(4,2);
 alter table notes add column idSemestre int not null;
alter table notes add foreign key  (idSemestre) references semestres(idSemestre) on delete cascade;



 create table presence(
 idPresence int primary key not null ,
 statut enum("Présent" , "Absent" ,"Justifié") not null,
 heure time not null,
 datePresence date not null ,
 idEtudiant int not null ,
 idModule int not null ,
 idProf int not null ,
 foreign key (idEtudiant) references etudiants(idEtudiant) on delete cascade ,
 foreign key (idModule) references modules(idModule) on delete cascade ,
 foreign key (idProf) references profs(idProf) on delete cascade
 );
 
 create table coursdevoirs(
 idCoursDevoirs int primary key not null ,
 message text ,
 coursEnPDF varchar(300),
 idProf int not null ,
 idModule int not null ,
 devoirDone boolean not null default false,
 idEtudiant int not null ,
 foreign key (idProf) references profs(idProf) on delete cascade,
 foreign key (idModule) references modules(idModule) on delete cascade,
 foreign key (idEtudiant) references etudiants(idEtudiant) on delete cascade 
 );
 alter table coursdevoirs add column type enum('COUR' , 'DEVOIR') not null;

 

create table testsexams(
idTestExam int primary key not null ,
type enum('TEST' , 'EXAM') not null ,
date date not null ,
heure time not null ,
idModule int not null,
idProf int not null ,
section varchar(2) not null ,
groupe varchar(2) not null ,
description text ,
foreign key (idModule) references modules(idModule) on delete cascade,
foreign key (idProf) references profs(idProf) on delete cascade
);

create table notifications(
idNotification int primary key not null,
 message text not null ,
 date_envoi timestamp default current_timestamp,
 lu boolean default false,
 type_notification enum("Alerte" , "Demande" , "Information") not null ,
 idExpediteur int not null ,
 idDestinataire int not null ,
 foreign key (idExpediteur) references utilisateurs(idUser) on delete cascade,
 foreign key (idDestinataire) references utilisateurs(idUser)  on delete cascade 
);

create table semestres (
    idSemestre int primary key not null,
    numero enum('Semestre 1', 'Semestre 2') not null,
    moyenneSemestre DECIMAL(4,2) DEFAULT NULL,
    idAnnee int  not null,
    foreign key (idAnnee) references annees(idAnnee) on delete cascade
);



INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) 
VALUES (1111, 'Ougour', 'Sarah', 'Sarah.Ougour@gmail.com', 'hey', 'Etudiant');
INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) 
VALUES (1112, 'Kahli', 'Aya Meriem', 'AyaMeriem.Kahli@gmail.com', 'hello', 'Etudiant');
INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) 
VALUES (1113, 'Chaban', 'Rym', 'Rym.Chaban@gmail.com', 'CCC', 'Etudiant');

select * from utilisateurs;

ALTER TABLE utilisateurs MODIFY COLUMN motdepasse VARCHAR(255);

SELECT * FROM modules ORDER BY nom ASC;
/*INSERT INTO modules (idModule, nom, idProfResponsable, spetialite) 
values (1, "Analyse1", 3 ,"Ingénieur en informatique") ;

SELECT COUNT(*) FROM modules WHERE idModule = ? */

INSERT INTO modules (idModule, nom, idProfResponsable, spetialite) VALUES (?, ?, ?, ?);

DESC modules;

