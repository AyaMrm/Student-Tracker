package Model;
import java.sql.Timestamp;

public class Notification {
	 private int idNotification;
	    private String message;
	    private Timestamp dateEnvoi;  
	    private boolean lu;  
	    private TypeNotification typeNotification;
	    private int idExpediteur;
	    private int idDestinataire;

		public Notification(){

		}
	    public Notification(int idNotification, String message, Timestamp dateEnvoi, boolean lu,
				TypeNotification typeNotification, int idExpediteur, int idDestinataire) {
			super();
			this.idNotification = idNotification;
			this.message = message;
			this.dateEnvoi = dateEnvoi;
			this.lu = lu;
			this.typeNotification = typeNotification;
			this.idExpediteur = idExpediteur;
			this.idDestinataire = idDestinataire;
		}

		public int getIdNotification() {
			return idNotification;
		}

		public void setIdNotification(int idNotification) {
			this.idNotification = idNotification;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Timestamp getDateEnvoi() {
			return dateEnvoi;
		}

		public void setDateEnvoi(Timestamp dateEnvoi) {
			this.dateEnvoi = dateEnvoi;
		}

		public boolean isLu() {
			return lu;
		}

		public void setLu(boolean lu) {
			this.lu = lu;
		}

		public TypeNotification getTypeNotification() {
			return typeNotification;
		}

		public void setTypeNotification(String typeNotification) {
			TypeNotification type = TypeNotification.valueOf(typeNotification);
			this.typeNotification = type;
		}

		public int getIdExpediteur() {
			return idExpediteur;
		}

		public void setIdExpediteur(int idExpediteur) {
			this.idExpediteur = idExpediteur;
		}

		public int getIdDestinataire() {
			return idDestinataire;
		}

		public void setIdDestinataire(int idDestinataire) {
			this.idDestinataire = idDestinataire;
		}

		@Override
		public String toString() {
			return "Notification [idNotification=" + idNotification + ", message=" + message + ", dateEnvoi="
					+ dateEnvoi + ", lu=" + lu + ", typeNotification=" + typeNotification + ", idExpediteur="
					+ idExpediteur + ", idDestinataire=" + idDestinataire + "]";
		}
	    
		
	    
}