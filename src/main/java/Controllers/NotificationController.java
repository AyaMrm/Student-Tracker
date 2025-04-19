package Controllers;

import Model.ConnectionDB;
import Model.Notification;
import Model.NotificationDAO;
import Model.TypeNotification;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class NotificationController {

    @FXML private TableView<Notification> tableNotifications;
    @FXML private TableColumn<Notification, String> colType;
    @FXML private TableColumn<Notification, String> colMessage;
    @FXML private TableColumn<Notification, Timestamp> colDate;
    @FXML private TableColumn<Notification, Boolean> colLu;

    @FXML private TextField fieldDestinataire;
    @FXML private ComboBox<TypeNotification> comboTypeNotif;
    @FXML private TextField fieldMessage;

    private NotificationDAO notificationDAO;
    private int currentUserId;

    public void initialize() throws SQLException {
        // Tu peux injecter dynamiquement la connexion et l'ID utilisateur via une méthode init() si tu veux
        this.currentUserId = 1; // à adapter selon le user connecté
        Connection conn = ConnectionDB.getConnection(); // à adapter avec ta méthode de connexion
        this.notificationDAO = new NotificationDAO(conn);

        // Associer les colonnes à des propriétés
        colType.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTypeNotification().toString()));
        colMessage.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMessage()));
        colDate.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getDateEnvoi()));
        colLu.setCellValueFactory(data -> new javafx.beans.property.SimpleBooleanProperty(data.getValue().isLu()));

        comboTypeNotif.setItems(FXCollections.observableArrayList(TypeNotification.values()));

        chargerNotifications();
    }

    @FXML
    private void chargerNotifications() {
        try {
            List<Notification> notifs = notificationDAO.getNotificationsParDestinataire(currentUserId);
            ObservableList<Notification> data = FXCollections.observableArrayList(notifs);
            tableNotifications.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            afficherAlerte("Erreur", "Impossible de charger les notifications", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleMarquerCommeLue() {
        Notification notif = tableNotifications.getSelectionModel().getSelectedItem();
        if (notif != null) {
            try {
                notificationDAO.marquerCommeLue(notif.getIdNotification());
                chargerNotifications();
            } catch (Exception e) {
                e.printStackTrace();
                afficherAlerte("Erreur", "Impossible de marquer comme lue", Alert.AlertType.ERROR);
            }
        } else {
            afficherAlerte("Info", "Sélectionnez une notification à marquer comme lue.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void handleRafraichir() {
        chargerNotifications();
    }

    @FXML
    private void handleEnvoyerNotification() {
        try {
            int destinataireId = Integer.parseInt(fieldDestinataire.getText());
            String message = fieldMessage.getText();
            TypeNotification type = comboTypeNotif.getValue();

            Notification notif = new Notification();
            notif.setIdNotification((int) (Math.random() * 100000)); // à remplacer par auto-incrément si besoin
            notif.setMessage(message);
            notif.setTypeNotification(type.toString());
            notif.setLu(false);
            notif.setDateEnvoi(Timestamp.from(Instant.now()));
            notif.setIdExpediteur(currentUserId);
            notif.setIdDestinataire(destinataireId);

            if (notificationDAO.ajouterNotification(notif)) {
                afficherAlerte("Succès", "Notification envoyée avec succès !", Alert.AlertType.INFORMATION);
                fieldDestinataire.clear();
                fieldMessage.clear();
                comboTypeNotif.setValue(null);
            } else {
                afficherAlerte("Erreur", "Échec de l'envoi de la notification.", Alert.AlertType.ERROR);
            }

        } catch (NumberFormatException e) {
            afficherAlerte("Erreur", "ID destinataire invalide", Alert.AlertType.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            afficherAlerte("Erreur", "Une erreur est survenue", Alert.AlertType.ERROR);
        }
    }

    private void afficherAlerte(String titre, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
