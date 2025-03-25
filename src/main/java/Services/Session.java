package Services;

import Model.Utilisateur;

public class Session {
    private static Session instance ;
    private Utilisateur userConnecter;

    private Session(){}

    public static Session getInstance(){
        if (instance == null){
            instance = new Session();
        }
        return instance;
    }

    public void setUserConnecter(Utilisateur user){
        this.userConnecter = user;
    }

    public Utilisateur getUserConnecter(){
        return userConnecter;
    }
    public void clearUserConnecter(){
        userConnecter = null;
    }
}
