package Service;

import Model.Utilisateur;
import Model.Role;

public class RoleManager {
    private final Utilisateur currentUser;

    public RoleManager(Utilisateur currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isAdmin() {
        return currentUser.getRole() == Role.ADMIN;
    }

    public boolean isProf() {
        return currentUser.getRole() == Role.PROF;
    }

    public boolean isEtudiant() {
        return currentUser.getRole() == Role.ETUDIANT;
    }

    public boolean hasRole(Role role) {
        return currentUser.getRole() == role;
    }

    public boolean canAccessFeature(String feature) {
        return false;
    }

    public void checkAccess(Role requiredRole) {
        if (!hasRole(requiredRole)) {
            throw new SecurityException("Accès refusé : rôle requis - " + requiredRole);
        }
    }
}
