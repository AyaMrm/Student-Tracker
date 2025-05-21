package Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class NotificationDAO {
 
    private Connection connection;

    public NotificationDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean notificationExiste(int idNotification) throws SQLException {
        String sql = "SELECT COUNT(*) FROM notifications WHERE idNotification = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idNotification);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    public boolean ajouterNotification(Notification notification) throws SQLException {
      
    	String sql = "INSERT INTO notifications (idNotification, message, date_envoi, lu, type_notification, idExpediteur, idDestinataire) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, notification.getIdNotification());
            stmt.setString(2, notification.getMessage());
            stmt.setTimestamp(3, notification.getDateEnvoi());
            stmt.setBoolean(4, notification.isLu());
            stmt.setString(5, notification.getTypeNotification().name());  // Convertir l'énumération en String
            stmt.setInt(6, notification.getIdExpediteur());
            stmt.setInt(7, notification.getIdDestinataire());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean modifierNotification(Notification notification) throws SQLException {
        if (!notificationExiste(notification.getIdNotification())) return false;

        String sql = "UPDATE notifications SET message = ?, date_envoi = ?, lu = ?, type_notification = ?, idExpediteur = ?, idDestinataire = ? "
                   + "WHERE idNotification = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, notification.getMessage());
            stmt.setTimestamp(2, notification.getDateEnvoi());
            stmt.setBoolean(3, notification.isLu());
            stmt.setString(4, notification.getTypeNotification().name());
            stmt.setInt(5, notification.getIdExpediteur());
            stmt.setInt(6, notification.getIdDestinataire());
            stmt.setInt(7, notification.getIdNotification());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean supprimerNotification(int idNotification) throws SQLException {
        if (!notificationExiste(idNotification)) return false;

        String sql = "DELETE FROM notifications WHERE idNotification = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idNotification);
            return stmt.executeUpdate() > 0;
        }
    }

    public Notification getNotificationParId(int idNotification) throws SQLException {
        String sql = "SELECT * FROM notifications WHERE idNotification = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idNotification);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractNotification(rs);
            }
        }
        return null;
    }

    public List<Notification> getNotificationsParDestinataire(int idDestinataire) throws SQLException {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE idDestinataire = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idDestinataire);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notifications.add(extractNotification(rs));
            }
        }
        return notifications;
    }
    
    // Rechercher les notifications par expéditeur
    public List<Notification> getNotificationsParExpediteur(int idExpediteur) throws SQLException {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE idExpediteur = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idExpediteur);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notifications.add(extractNotification(rs));
            }
        }
        return notifications;
    }

    // Marquer une notification comme lue
    public boolean marquerNotificationCommeLue(int idNotification) throws SQLException {
        String sql = "UPDATE notifications SET lu = true WHERE idNotification = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idNotification);
            return stmt.executeUpdate() > 0;  // Retourne true si l'update a réussi
        }
    }

    private Notification extractNotification(ResultSet rs) throws SQLException {
        return new Notification(
                rs.getInt("idNotification"),
                rs.getString("message"),
                rs.getTimestamp("date_envoi"),
                rs.getBoolean("lu"),
                TypeNotification.valueOf(rs.getString("type_notification")),  // Convertir en TypeNotification
                rs.getInt("idExpediteur"),
                rs.getInt("idDestinataire")
        );
    }

    public List<Notification> getNouvellesNotifications(int idDestinataire) {
        List<Notification> list = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE idDestinataire = ? AND lu = 0";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idDestinataire);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Notification notif = new Notification();
                notif.setIdNotification(rs.getInt("idNotification"));
                notif.setMessage(rs.getString("message"));
                notif.setDateEnvoi(rs.getTimestamp("date_envoi"));
                notif.setLu(rs.getBoolean("lu"));
                notif.setTypeNotification(rs.getString("type_notification"));
                notif.setIdExpediteur(rs.getInt("idExpediteur"));
                notif.setIdDestinataire(rs.getInt("idDestinataire"));
                list.add(notif);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void marquerCommeLue(int idNotification) {
        String sql = "UPDATE notifications SET lu = 1 WHERE idNotification = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idNotification);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}