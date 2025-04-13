CREATE DATABASE POO;
USE POO;

-- Table utilisateurs (aucune dépendance)
CREATE TABLE utilisateurs (
    idUser INT PRIMARY KEY NOT NULL,
    nom VARCHAR(30) NOT NULL,
    prenom VARCHAR(40) NOT NULL,
    email VARCHAR(70) UNIQUE NOT NULL,
    motdepasse VARCHAR(255) NOT NULL,
    role ENUM('Etudiant', 'Admin', 'Prof') NOT NULL
);

-- Table specialites (aucune dépendance)
CREATE TABLE specialites (
    idSpecialite INT PRIMARY KEY NOT NULL,
    nomSpecialite VARCHAR(50) NOT NULL UNIQUE
);

-- Table etudiants (dépend de utilisateurs et specialites)
CREATE TABLE etudiants (
    idEtudiant INT PRIMARY KEY NOT NULL,
    idUser INT NOT NULL,
    idSpecialite INT NOT NULL,
    section VARCHAR(2) NOT NULL,
    groupe VARCHAR(2) NOT NULL,
    idEmploiDuTemps INT, -- Note : idEmploiDuTemps sera ajouté comme clé étrangère plus tard
    FOREIGN KEY (idUser) REFERENCES utilisateurs(idUser) ON DELETE CASCADE,
    FOREIGN KEY (idSpecialite) REFERENCES specialites(idSpecialite) ON DELETE CASCADE
    -- La clé étrangère pour idEmploiDuTemps sera ajoutée après la création de emploisdutemps
);

-- Table annees (dépend de etudiants et specialites)
CREATE TABLE annees (
    idAnnee INT PRIMARY KEY NOT NULL,
    anneeScolaire VARCHAR(9) NOT NULL UNIQUE,
    idEtudiant INT NOT NULL,
    idSpecialite INT NOT NULL,
    moyenneGenerale DECIMAL(4,2) DEFAULT NULL,
    FOREIGN KEY (idEtudiant) REFERENCES etudiants(idEtudiant) ON DELETE CASCADE,
    FOREIGN KEY (idSpecialite) REFERENCES specialites(idSpecialite) ON DELETE CASCADE
);

-- Table semestres (dépend de annees)
CREATE TABLE semestres (
    idSemestre INT PRIMARY KEY NOT NULL,
    numero ENUM('Semestre 1', 'Semestre 2') NOT NULL,
    moyenneSemestre DECIMAL(4,2) DEFAULT NULL,
    idAnnee INT NOT NULL,
    FOREIGN KEY (idAnnee) REFERENCES annees(idAnnee) ON DELETE CASCADE
);

-- Table profs (dépend de utilisateurs et specialites)
CREATE TABLE profs (
    idProf INT PRIMARY KEY NOT NULL,
    idUser INT NOT NULL,
    idSpecialite INT NOT NULL,
    grade VARCHAR(20) NOT NULL,
    departement VARCHAR(30) NOT NULL,
    FOREIGN KEY (idUser) REFERENCES utilisateurs(idUser) ON DELETE CASCADE,
    FOREIGN KEY (idSpecialite) REFERENCES specialites(idSpecialite) ON DELETE CASCADE
);

-- Table modules (dépend de profs et semestres)
CREATE TABLE modules (
    idModule INT PRIMARY KEY NOT NULL,
    nom VARCHAR(30) NOT NULL,
    idProfResponsable INT,
    idSpecialite INT NOT NULL,
    idSemestre INT NOT NULL,
    methodeCalcul ENUM('40% - 60%', '50% - 50%', 'Personnalisée') DEFAULT '40% - 60%',
    coefControle DOUBLE,
    coefExamen DOUBLE,
    FOREIGN KEY (idProfResponsable) REFERENCES profs(idProf) ON DELETE SET NULL,
    FOREIGN KEY (idSpecialite) REFERENCES specialites(idSpecialite) ON DELETE CASCADE,
    FOREIGN KEY (idSemestre) REFERENCES semestres(idSemestre) ON DELETE CASCADE
);

-- Table emploisdutemps (dépend de annees et specialites)
CREATE TABLE emploisdutemps (
    idEmploiDuTemps INT PRIMARY KEY NOT NULL,
    idSpecialite INT NOT NULL,
    idAnnee INT NOT NULL,
    section VARCHAR(2) NOT NULL,
    groupe VARCHAR(2) NOT NULL,
    FOREIGN KEY (idSpecialite) REFERENCES specialites(idSpecialite) ON DELETE CASCADE,
    FOREIGN KEY (idAnnee) REFERENCES annees(idAnnee) ON DELETE CASCADE
);

-- Ajout de la clé étrangère idEmploiDuTemps dans etudiants (maintenant que emploisdutemps existe)
ALTER TABLE etudiants
ADD CONSTRAINT fk_etudiants_emploisdutemps
FOREIGN KEY (idEmploiDuTemps) REFERENCES emploisdutemps(idEmploiDuTemps) ON DELETE SET NULL;

-- Table jours (aucune dépendance)
CREATE TABLE jours (
    idJour INT PRIMARY KEY NOT NULL,
    jour ENUM('Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi', 'Dimanche') NOT NULL
);

-- Table seances (dépend de modules, profs et jours)
CREATE TABLE seances (
    idSeance INT PRIMARY KEY NOT NULL,
    heure_debut TIME NOT NULL,
    heure_fin TIME NOT NULL,
    idModule INT NOT NULL,
    idProf INT,
    salle VARCHAR(30) NOT NULL,
    idJour INT NOT NULL,
    FOREIGN KEY (idModule) REFERENCES modules(idModule) ON DELETE CASCADE,
    FOREIGN KEY (idProf) REFERENCES profs(idProf) ON DELETE SET NULL,
    FOREIGN KEY (idJour) REFERENCES jours(idJour) ON DELETE CASCADE
);

-- Table etudiants_modules (dépend de etudiants et modules)
CREATE TABLE etudiants_modules (
    idEtudiant INT NOT NULL,
    idModule INT NOT NULL,
    PRIMARY KEY (idEtudiant, idModule),
    FOREIGN KEY (idEtudiant) REFERENCES etudiants(idEtudiant) ON DELETE CASCADE,
    FOREIGN KEY (idModule) REFERENCES modules(idModule) ON DELETE CASCADE
);

-- Table admins (dépend de utilisateurs)
CREATE TABLE admins (
    idAdmin INT PRIMARY KEY NOT NULL,
    idUser INT NOT NULL,
    FOREIGN KEY (idUser) REFERENCES utilisateurs(idUser) ON DELETE CASCADE
);

-- Table profs_modules (dépend de profs et modules)
CREATE TABLE profs_modules (
    idProf INT NOT NULL,
    idModule INT NOT NULL,
    PRIMARY KEY (idProf, idModule),
    FOREIGN KEY (idProf) REFERENCES profs(idProf) ON DELETE CASCADE,
    FOREIGN KEY (idModule) REFERENCES modules(idModule) ON DELETE CASCADE
);

-- Table notes (dépend de etudiants, profs, modules et semestres)
CREATE TABLE notes (
    idNote INT PRIMARY KEY NOT NULL,
    coefficient INT CHECK (coefficient > 0),
    cc DECIMAL(4,2) CHECK (cc BETWEEN 0 AND 20),
    exam DECIMAL(4,2) CHECK (exam BETWEEN 0 AND 20),
    moyenne DECIMAL(4,2) CHECK (moyenne BETWEEN 0 AND 20),
    idEtudiant INT NOT NULL,
    idProf INT NOT NULL,
    idModule INT NOT NULL,
    idSemestre INT NOT NULL,
    FOREIGN KEY (idEtudiant) REFERENCES etudiants(idEtudiant) ON DELETE CASCADE,
    FOREIGN KEY (idProf) REFERENCES profs(idProf) ON DELETE CASCADE,
    FOREIGN KEY (idModule) REFERENCES modules(idModule) ON DELETE CASCADE,
    FOREIGN KEY (idSemestre) REFERENCES semestres(idSemestre) ON DELETE CASCADE
);

-- Table presence (dépend de etudiants, modules et profs)
CREATE TABLE presence (
    idPresence INT PRIMARY KEY NOT NULL,
    statut ENUM('Présent', 'Absent', 'Justifié') NOT NULL,
    heure TIME NOT NULL,
    datePresence DATE NOT NULL,
    idEtudiant INT NOT NULL,
    idModule INT NOT NULL,
    idProf INT NOT NULL,
    FOREIGN KEY (idEtudiant) REFERENCES etudiants(idEtudiant) ON DELETE CASCADE,
    FOREIGN KEY (idModule) REFERENCES modules(idModule) ON DELETE CASCADE,
    FOREIGN KEY (idProf) REFERENCES profs(idProf) ON DELETE CASCADE
);

-- Table coursdevoirs (dépend de profs, modules et etudiants)
CREATE TABLE coursdevoirs (
    idCoursDevoirs INT PRIMARY KEY NOT NULL,
    message TEXT,
    coursEnPDF VARCHAR(300),
    type ENUM('COURS', 'DEVOIR') NOT NULL,
    idProf INT NOT NULL,
    idModule INT NOT NULL,
    devoirDone BOOLEAN NOT NULL DEFAULT FALSE,
    idEtudiant INT NOT NULL,
    FOREIGN KEY (idProf) REFERENCES profs(idProf) ON DELETE CASCADE,
    FOREIGN KEY (idModule) REFERENCES modules(idModule) ON DELETE CASCADE,
    FOREIGN KEY (idEtudiant) REFERENCES etudiants(idEtudiant) ON DELETE CASCADE
);

-- Table testsexams (dépend de modules et profs)
CREATE TABLE testsexams (
    idTestExam INT PRIMARY KEY NOT NULL,
    type ENUM('TEST', 'EXAM') NOT NULL,
    date DATE NOT NULL,
    heure TIME NOT NULL,
    idModule INT NOT NULL,
    idProf INT NOT NULL,
    section VARCHAR(2) NOT NULL,
    groupe VARCHAR(2) NOT NULL,
    description TEXT,
    FOREIGN KEY (idModule) REFERENCES modules(idModule) ON DELETE CASCADE,
    FOREIGN KEY (idProf) REFERENCES profs(idProf) ON DELETE CASCADE
);

-- Table notifications (dépend de utilisateurs)
CREATE TABLE notifications (
    idNotification INT PRIMARY KEY NOT NULL,
    message TEXT NOT NULL,
    date_envoi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lu BOOLEAN DEFAULT FALSE,
    type_notification ENUM('Alerte', 'Demande', 'Information') NOT NULL,
    idExpediteur INT NOT NULL,
    idDestinataire INT NOT NULL,
    FOREIGN KEY (idExpediteur) REFERENCES utilisateurs(idUser) ON DELETE CASCADE,
    FOREIGN KEY (idDestinataire) REFERENCES utilisateurs(idUser) ON DELETE CASCADE
);
