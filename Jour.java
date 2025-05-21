package Model;
import java.util.List;

public class Jour {

    private int idJour;
    private JourSemaine jour; 
    private List<Seance> seances;  // Liste des séances associées à ce jour


    public Jour(int idJour, JourSemaine jour){
        this.idJour = idJour;
        this.jour=jour;
    }
    public Jour(int idJour, JourSemaine jour, List<Seance> seances) {
        this.idJour = idJour;
        this.jour = jour;
        this.seances = seances;
    }

    public int getIdJour() {
        return idJour;
    }

    public void setIdJour(int idJour) {
        this.idJour = idJour;
    }


    public JourSemaine getJour() {
        return jour;
    }

    public void setJour(JourSemaine jour) {
        this.jour = jour;
    }


    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

	@Override
	public String toString() {
		return "Jour [idJour=" + idJour + ", jour=" + jour + ", seances=" + seances + "]";
	}

   
}
