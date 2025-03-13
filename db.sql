
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
spetialite varchar(30) not null ,
foreign key (idProfResponsable) references profs(idProf) on  delete set null
);

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



INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) 
VALUES (1111, 'Ougour', 'Sarah', 'Sarah.Ougour@gmail.com', 'hey', 'Etudiant');
INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) 
VALUES (1112, 'Kahli', 'Aya Meriem', 'AyaMeriem.Kahli@gmail.com', 'hello', 'Etudiant');
INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) 
VALUES (1113, 'Chaban', 'Rym', 'Rym.Chaban@gmail.com', 'CCC', 'Etudiant');

select * from utilisateurs;

ALTER TABLE utilisateurs MODIFY COLUMN motdepasse VARCHAR(255);



