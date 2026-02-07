package Controllers;

import Model.Notification;
import Model.NotificationDAO;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationService {

    private final NotificationDAO notificationDAO;
    private final int userId;
    private Timer timer;

    public NotificationService(Connection conn, int userId) {
        this.notificationDAO = new NotificationDAO(conn);
        this.userId = userId;
    }

    public void start() {
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    List<Notification> nouvellesNotifs = notificationDAO.getNouvellesNotifications(userId);
                    for (Notification notif : nouvellesNotifs) {
                        showNotificationPopup(notif);
                        notificationDAO.marquerCommeLue(notif.getIdNotification());
                    }
                });
            }
        }, 0, 5000);
    }


    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private void showNotificationPopup(Notification notif) {
        Alert.AlertType alertType;
        switch (notif.getTypeNotification().toString()) {
            case "Alerte":
                alertType = Alert.AlertType.ERROR;
                break;
            case "Demande":
                alertType = Alert.AlertType.CONFIRMATION;
                break;
            default:
                alertType = Alert.AlertType.INFORMATION;
        }

        Alert alert = new Alert(alertType);
        alert.setTitle("Nouvelle notification");
        alert.setHeaderText("Message de l'utilisateur #" + notif.getIdExpediteur());
        alert.setContentText(notif.getMessage());
        alert.show();
    }
}