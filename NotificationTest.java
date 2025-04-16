package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class NotificationTest {
	
	 public static void main(String[] args) {
		 try {
          	// Connexion à la base
          	Connection connection = DatabaseConnection.getConnection();

  	        if (connection == null) {
  	            System.err.println(" Connexion à la base de données échouée.");
  	            return;
  	        }
            
  	        connection.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
         
	            NotificationDAO notificationDAO = new NotificationDAO(connection);

	            // 1. Ajouter une notification
	            Notification notification = new Notification(1, "Message de test", new Timestamp(System.currentTimeMillis()), false, TypeNotification.Information, 1, 2);
	            boolean added = notificationDAO.ajouterNotification(notification);
	            System.out.println("Notification ajoutée: " + added);

	            // 2. Récupérer une notification par ID
	            Notification retrievedNotification = notificationDAO.getNotificationParId(1);
	            System.out.println("Notification récupérée: " + retrievedNotification);

	            // 3. Modifier la notification
	            notification.setMessage("Message modifié");
	            boolean updated = notificationDAO.modifierNotification(notification);
	            System.out.println("Notification modifiée: " + updated);

	            // 4. Marquer comme lue
	            boolean markedAsRead = notificationDAO.marquerNotificationCommeLue(1);
	            System.out.println("Notification marquée comme lue: " + markedAsRead);

	            // 5. Supprimer la notification
	            boolean deleted = notificationDAO.supprimerNotification(1);
	            System.out.println("Notification supprimée: " + deleted);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
