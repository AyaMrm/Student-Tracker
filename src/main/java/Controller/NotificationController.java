// Terminé !
package Controller;

import Model.Notification;
import Service.NotificationService;
import java.util.List;

public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public boolean ajouterNotification(Notification notif) {
        return notificationService.ajouterNotification(notif);
    }

    public boolean modifierNotification(Notification notif) {
        return notificationService.modifierNotification(notif);
    }

    public boolean supprimerNotification(int id) {
        return notificationService.supprimerNotification(id);
    }

    public Notification getNotificationParId(int id) {
        return notificationService.getNotificationParId(id);
    }

    public List<Notification> getNotificationsParDestinataire(int idDestinataire) {
        return notificationService.getNotificationsParDestinataire(idDestinataire);
    }

    public List<Notification> getNotificationsParExpediteur(int idExpediteur) {
        return notificationService.getNotificationsParExpediteur(idExpediteur);
    }

    public boolean marquerNotificationCommeLue(int id) {
        return notificationService.marquerCommeLue(id);
    }
}
