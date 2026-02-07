package Model;

public class AdminTable {
int idAdmin;
String nom;
String prenom;
String email;
String motdepasse;
public int getIdAdmin() {
	return idAdmin;
}
public void setIdAdmin(int idAdmin) {
	this.idAdmin = idAdmin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMotdepasse() {
	return motdepasse;
}
public void setMotdepasse(String motdepasse) {
	this.motdepasse = motdepasse;
}
public AdminTable(int idAdmin, String nom, String prenom, String email, String motdepasse) {
	this.idAdmin = idAdmin;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.motdepasse = motdepasse;
}
}
