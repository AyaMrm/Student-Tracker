package Controllers;

import Model.Auth;

import Model.Utilisateur;


import java.sql.Connection;


public class AuthService {

protected Auth auth;


public AuthService(Connection cnx){

this.auth = new Auth(cnx);

}


public boolean ajouterUtilisateur(Utilisateur user, String password){

return auth.ajouterUtilisateur(user, password);

}


public Utilisateur connecter(int idUser, String password){

return auth.connecter(idUser, password);

}


public boolean changePassword(int idUser, String old, String newPass){

return auth.changePassword(idUser, old, newPass );

}

}
